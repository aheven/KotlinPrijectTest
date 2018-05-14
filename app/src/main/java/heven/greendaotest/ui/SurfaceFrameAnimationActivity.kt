package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import android.view.View
import heven.greendaotest.R
import kotlinx.android.synthetic.main.activity_surface_frame_animation.*

class SurfaceFrameAnimationActivity : BaseActivity() {
    override fun getLayoutResID(): Int = R.layout.activity_surface_frame_animation

    override fun initActivity() {

    }

    fun clickButton(view: View) {
        when (view.id) {
            R.id.start -> {
                val paths = arrayListOf<String>()
                val list = resources.assets.list("richLoading")

                list.forEach {
                    paths.add("richLoading/$it")
                }
                specialGiftSurfaceView.startAnimation(paths)
            }
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SurfaceFrameAnimationActivity::class.java)
            context.startActivity(intent)
        }
    }
}