package heven.greendaotest.ui

import android.view.View
import heven.greendaotest.R
import heven.greendaotest.presenter.view.HttpView

class MainActivity : BaseActivity(), HttpView {

    override fun getLayoutResID(): Int = R.layout.activity_main

    override fun initActivity() {

    }

    fun clickButton(view: View) {
        when (view.id) {
            R.id.network -> NetworkActivity.start(this)
            R.id.netty -> NettyActivity.start(this)
            R.id.surfaceFrameAnimation -> SurfaceFrameAnimationActivity.start(this)
        }
    }
}
