package heven.greendaotest.ui

import android.content.Context
import android.content.Intent
import heven.greendaotest.R
import heven.greendaotest.bean.User
import heven.greendaotest.databinding.ActivityDataBindingBinding

class DataBindingActivity : BaseDataBindActivity<ActivityDataBindingBinding>() {
    private val user: User = User()
    override fun getLayoutResID(): Int = R.layout.activity_data_binding

    override fun initActivity() {
        user.firstName = "Heven"
        user.lastName = "Holt"
        user.headImage = resources.getString(R.string.image_url)
        binding.user = user
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, DataBindingActivity::class.java)
            context.startActivity(intent)
        }
    }
}