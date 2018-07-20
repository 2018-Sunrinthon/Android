package rankhep.com.ddaal.utils


import android.content.Context
import android.os.Build
import android.graphics.Paint.FILTER_BITMAP_FLAG
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.renderscript.RSRuntimeException
import com.squareup.picasso.Transformation


class BlurTransformation @JvmOverloads constructor(context: Context, radius: Int = MAX_RADIUS, private val mSampling: Int = DEFAULT_DOWN_SAMPLING) : Transformation {
    private val mContext: Context = context.applicationContext
    private var mRadius: Int = 0

    init {
        mRadius = radius
        if (mRadius > 25) {
            mRadius = 25
        } else if (mRadius <= 0) {
            mRadius = 1
        }
    }

    override fun transform(source: Bitmap): Bitmap {
        val scaledWidth = source.width / mSampling
        val scaledHeight = source.height / mSampling
        var bitmap = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.scale(1 / mSampling.toFloat(), 1 / mSampling.toFloat())
        val paint = Paint()
        paint.flags = Paint.FILTER_BITMAP_FLAG
        canvas.drawBitmap(source, 0f, 0f, paint)
        try {
            bitmap = RenderScriptBlur.blur(mContext, bitmap, mRadius)
        } catch (e: RSRuntimeException) {
        }

        source.recycle()
        return bitmap
    }

    override fun key(): String {
        return "BlurTransformation(radius=$mRadius, sampling=$mSampling)"
    }

    companion object {
        private val MAX_RADIUS = 25
        private val DEFAULT_DOWN_SAMPLING = 1
    }
}