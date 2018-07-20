package com.eka.applicatio

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.fragment_camera.*
import okhttp3.MediaType
import rankhep.com.ddaal.R
import okhttp3.MultipartBody
import okhttp3.RequestBody
import rankhep.com.dhlwn.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


class CameraFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_camera, null)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestPermission()
        startCamera()

        closeBtn.setOnClickListener {

        }
        flashBtn.setOnClickListener {
            cameraView.changeFlash()
        }

        cameraView.setOnClickListener {
            (it as CameraView).setFocus { b, camera -> }
        }

        pictureBtn.setOnClickListener {
            cameraView.saveImage() { path ->
                val requestFile = RequestBody.create(MediaType.parse("multipart/png"), File(path))
                val body = MultipartBody.Part.createFormData("post_profile_image_url", File(path).name, requestFile)
                NetworkHelper.networkInstance.getOcr(body).enqueue(object: Callback<String> {
                    override fun onFailure(call: Call<String>?, t: Throwable?) {
                        Log.e("Error", t?.message)
                    }

                    override fun onResponse(call: Call<String>?, response: Response<String>?) {
                        Toast.makeText(context,""+response?.body(), LENGTH_SHORT).show()
                    }

                })

            }
        }
    }

    private fun startCamera() {
        val holder = cameraView.holder
        holder.addCallback(cameraView)
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(context!!, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context!!, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity!!,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                    1000)

        } else {
            startCamera()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1000) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun imgRotate(bitmap: Bitmap, rotate: Float): Bitmap {
        val width = bitmap.width
        val height = bitmap.height
        val matrix = Matrix()
        matrix.postRotate(rotate)

        var rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true)
        bitmap.recycle()
        return rotatedBitmap
    }

    fun makeBitmapFromByteArray(byteArray: ByteArray): Bitmap {
        val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        return bmp
    }

    companion object {
        fun getInstance() = CameraFragment()
    }
}