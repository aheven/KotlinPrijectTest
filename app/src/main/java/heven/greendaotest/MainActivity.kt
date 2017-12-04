package heven.greendaotest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import heven.greendaotest.bean.MainUrlBean
import heven.greendaotest.presenter.HttpPresenter
import heven.greendaotest.presenter.HttpPresenterIml
import heven.greendaotest.presenter.view.HttpView
import heven.greendaotest.ui.BaseActivity
import heven.greendaotest.ui.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),HttpView {
    private val httpPresenter:HttpPresenter = HttpPresenterIml(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        httpPresenter.getMainUrl()

        show.setOnClickListener {
            SecondActivity.start(this)
        }
    }

    override fun onResume() {
        super.onResume()
        httpPresenter.timeTick()
    }

    override fun getMainUrlSuccess(mainUrlBean: MainUrlBean) {
        show.text = mainUrlBean.toString()
    }

    companion object {
        fun start(context: Context){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
