package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import android.view.View
import heven.greendaotest.R
import heven.greendaotest.bean.RoomServerBean
import heven.greendaotest.presenter.HttpPresenter
import heven.greendaotest.presenter.HttpPresenterIml
import heven.greendaotest.presenter.view.HttpView
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : BaseActivity(), HttpView {

    private val httpPresenter: HttpPresenter = HttpPresenterIml(this)
    private val result: StringBuilder = StringBuilder()

    override fun getLayoutResID(): Int = R.layout.activity_network

    override fun initActivity() {

    }

    fun clickButton(view: View) {
        when (view.id) {
            R.id.network -> httpPresenter.getRoomServer()
        }
    }

    override fun getRoomServerSuccess(roomServerBean: RoomServerBean) {
        result.append(roomServerBean.toString())
        show.text = result.toString()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NetworkActivity::class.java)
            context.startActivity(intent)
        }
    }
}