package rankhep.com.ddaal.utils

import android.content.Context
import android.renderscript.Element.U8_4
import android.graphics.Bitmap
import android.renderscript.*


object RenderScriptBlur {
    @Throws(RSRuntimeException::class)
    fun blur(context: Context, targetBitmap: Bitmap, radius: Int): Bitmap {
        var renderScript: RenderScript? = null
        try {
            renderScript = RenderScript.create(context)
            val input = Allocation.createFromBitmap(renderScript, targetBitmap, Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT)
            val output = Allocation.createTyped(renderScript, input.type)
            val blur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
            blur.run {
                setInput(input)
                setRadius((if (radius > 25) 25 else radius).toFloat())
                forEach(output)
                output.copyTo(targetBitmap)
            }
        } finally {
            if (renderScript != null) {
                renderScript.destroy()
            }
        }
        return targetBitmap
    }
}