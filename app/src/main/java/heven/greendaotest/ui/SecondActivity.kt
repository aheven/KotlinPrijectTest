package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import heven.greendaotest.MainActivity
import heven.greendaotest.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by PC-201711161643$ on 2017/11/22 0022.
 */
class SecondActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show.text = "second"

        show.setOnClickListener {
            MainActivity.start(this)
            finish()
        }
    }

    companion object {
        fun start(context: Context){
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }
    }
}