package heven.greendaotest.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseDataBindActivity<T> : RxAppCompatActivity() where T : ViewDataBinding {
    protected lateinit var binding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResID())
        binding.setLifecycleOwner(this)
        initActivity()
    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutResID(): Int

    /**
     * 初始化activity
     */
    abstract fun initActivity()
}