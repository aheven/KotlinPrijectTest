package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import android.view.View
import heven.greendaotest.R
import kotlinx.android.synthetic.main.activity_rise_number.*

class RiseNumberActivity : BaseActivity() {
    override fun getLayoutResID(): Int = R.layout.activity_rise_number

    override fun initActivity() {
        riseNumber.withNumber(500,200)
    }

    fun clickButton(view: View) {
        when (view.id) {
            R.id.start -> riseNumber.start()
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, RiseNumberActivity::class.java)
            context.startActivity(intent)
        }
    }
}