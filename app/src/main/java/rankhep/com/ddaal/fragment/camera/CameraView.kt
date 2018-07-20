package com.eka.applicatio

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.hardware.Camera
import android.os.Environment
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class CameraView : SurfaceView, SurfaceHolder.Callback {

    private var mCamera: Camera? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun surfaceChanged(surfaceHolder: SurfaceHolder?, i: Int, w: Int, h: Int) {
        mCamera?.autoFocus { b, camera -> }
        if (surfaceHolder?.surface == null)
            return
    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder?) {
        mCamera?.run {
            stopPreview()
            release()
        }
        mCamera = null
    }

    fun changeFlash() {
        mCamera?.run {
            parameters = mCamera?.parameters?.apply {
                flashMode = if (flashMode == Camera.Parameters.FLASH_MODE_TORCH) Camera.Parameters.FLASH_MODE_OFF else Camera.Parameters.FLASH_MODE_TORCH
            }
            startPreview()
        }
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {
        if (mCamera == null)
            mCamera = Camera.open()
        mCamera?.run {
            parameters = mCamera!!.parameters.apply {
                set("orientation", "portrait")
                setRotation(90)
                val sizes = supportedPreviewSizes
                getOptimumSize().let {
                    setPictureSize(it.width, it.height)
                }
//            params.flashMode = Camera.Parameters.FLASH_MODE_TORCH;
                setPreviewSize(sizes.first().width, sizes.first().height)
            }
            setDisplayOrientation(90)
            setPreviewDisplay(surfaceHolder)
            startPreview()
        }
    }

    private fun getOptimumSize(): Camera.Size {
        var ratioWidth = 0
        var ratioHeight = 0
        mCamera?.run {
            val params = parameters
            var biggestWidth = params.supportedPreviewSizes.first().width
            var biggestHeight = params.supportedPreviewSizes.first().height

            var i = 2
            while (i < biggestHeight) {
                val hResult = biggestHeight % i
                val wResult = biggestWidth % i
                if (hResult == 0 && wResult == 0) {
                    biggestHeight /= i
                    biggestWidth /= i
                } else
                    i++
            }
            ratioHeight = biggestHeight
            ratioWidth = biggestWidth

            params.supportedPictureSizes.forEach {
                var width = it.width
                var height = it.height

                i = 2
                while (i < height) {
                    val hResult = height % i
                    val wResult = width % i
                    if (hResult == 0 && wResult == 0) {
                        height /= i
                        width /= i
                    } else
                        i++
                }
                if (width == ratioWidth && height == ratioHeight) {
                    return it

                }

            }
        }
        return mCamera!!.parameters.supportedPreviewSizes.first()
    }

    fun getPicture(callback: (img: ByteArray) -> Unit) {
        mCamera?.takePicture(null, null) { biteArray, camera ->

            //            val params = mCamera!!.parameters
//            val w = params.previewSize.width
//            val h = params.previewSize.height
//            val format = params.previewFormat
//
//            val image = YuvImage(biteArray, format, w, h, null)
//            val out = ByteArrayOutputStream()
//            val area = Rect(0, 0, w, h)
//
//            image.compressToJpeg(area, 50, out)

//            callback.invoke(BitmapFactory.decodeByteArray(out.toByteArray(), 0, out.size()))

//            val bmp = BitmapFactory.decodeByteArray(biteArray, 0, biteArray.size)

            callback.invoke(biteArray)
        }
    }

    fun setFocus(onFocus: (Boolean, Camera) -> Unit) {
        mCamera?.autoFocus { b, camera ->
            onFocus(b, camera)
        }
    }

    fun saveImage() {
        getPicture { img ->
            val bmp = BitmapFactory.decodeByteArray(img, 0, img.size)
            var folder = Environment.getExternalStorageDirectory().absolutePath + "/ddaal/"
            val filename = "img${SimpleDateFormat("yyyyMMddhhmmss").format(Date())}.jpg"
            Log.e("asdf", filename)
            var folderPath = File(folder)
            if (!folderPath.isDirectory)
                folderPath.mkdirs()
            val out = FileOutputStream(folder + filename)
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.close()
        }
    }
}