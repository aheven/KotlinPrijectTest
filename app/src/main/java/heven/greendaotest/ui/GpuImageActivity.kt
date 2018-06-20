package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import android.hardware.Camera
import heven.greendaotest.R
import heven.greendaotest.camera.CameraHelper
import jp.co.cyberagent.android.gpuimage.GPUImage
import kotlinx.android.synthetic.main.activity_gpu_image.*

class GpuImageActivity : BaseActivity() {
    private var gpuImage: GPUImage? = null
    private var cameraHelper: CameraHelper? = null
    private var cameraLoader: CameraLoader? = null
    override fun getLayoutResID(): Int = R.layout.activity_gpu_image

    override fun initActivity() {
        gpuImage = GPUImage(this)
        gpuImage?.setGLSurfaceView(surfaceView)

        cameraHelper = CameraHelper(this)
        cameraLoader = CameraLoader()
    }

    override fun onResume() {
        super.onResume()
        cameraLoader?.onResume()
    }

    override fun onPause() {
        cameraLoader?.onPause()
        super.onPause()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, GpuImageActivity::class.java)
            context.startActivity(intent)
        }
    }

    private inner class CameraLoader {

        private var mCurrentCameraId = 1
        private var mCameraInstance: Camera? = null

        fun onResume() {
            setUpCamera(mCurrentCameraId)
        }

        fun onPause() {
            releaseCamera()
        }

//        fun switchCamera() {
//            releaseCamera()
//            mCurrentCameraId = (mCurrentCameraId + 1) % cameraHelper?.numberOfCameras!!
//            setUpCamera(mCurrentCameraId)
//        }

        private fun setUpCamera(id: Int) {
            mCameraInstance = getCameraInstance(id)
            val parameters = mCameraInstance!!.parameters
            // TODO adjust by getting supportedPreviewSizes and then choosing
            // the best one for screen size (best fill screen)
            if (parameters.supportedFocusModes.contains(
                            Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
                parameters.focusMode = Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE
            }
            mCameraInstance!!.parameters = parameters

            val orientation = cameraHelper?.getCameraDisplayOrientation(
                    this@GpuImageActivity, mCurrentCameraId)
            val cameraInfo = CameraHelper.CameraInfo2()
            cameraHelper?.getCameraInfo(mCurrentCameraId, cameraInfo)
            val flipHorizontal = cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT
            gpuImage?.setUpCamera(mCameraInstance, orientation!!, flipHorizontal, false)
        }

        /** A safe way to get an instance of the Camera object.  */
        private fun getCameraInstance(id: Int): Camera? {
            var c: Camera? = null
            try {
                c = cameraHelper?.openCamera(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return c
        }

        private fun releaseCamera() {
            mCameraInstance!!.setPreviewCallback(null)
            mCameraInstance!!.release()
            mCameraInstance = null
        }
    }
}