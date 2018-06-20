package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import heven.greendaotest.R

class Dagger2Activity : BaseActivity() {
    override fun getLayoutResID(): Int = R.layout.activity_dagger2

    override fun initActivity() {

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, Dagger2Activity::class.java)
            context.startActivity(intent)
        }
    }
}