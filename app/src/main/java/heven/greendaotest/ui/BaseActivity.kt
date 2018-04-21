package heven.greendaotest.ui

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by PC-201711161643$ on 2017/11/22 0022.
 */
abstract class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())
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