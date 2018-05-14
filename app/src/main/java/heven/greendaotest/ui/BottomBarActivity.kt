package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import heven.greendaotest.R

class BottomBarActivity : BaseActivity() {
    override fun getLayoutResID(): Int = R.layout.activity_bottom_bar

    override fun initActivity() {

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, BottomBarActivity::class.java)
            context.startActivity(intent)
        }
    }
}