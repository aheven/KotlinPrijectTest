package heven.greendaotest

import android.app.Application
import android.content.Context
import android.content.Intent
import android.support.multidex.MultiDex
import com.blankj.utilcode.util.Utils
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.tinker.loader.app.DefaultApplicationLike
import heven.greendaotest.constant.AppConstant

/**
 * Created by PC-201711161643$ on 2017/11/20 0020.
 */
class BaseApplication(application: Application, tinkerFlags: Int, tinkerLoadVerifyFlag: Boolean, applicationStartElapsedTime: Long, applicationStartMillisTime: Long, tinkerResultIntent: Intent) :
        DefaultApplicationLike(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent) {

    override fun onCreate() {
        super.onCreate()
//        CrashReport.initCrashReport(applicationContext, AppConstant.APP_BUGLY_ID, !AppConstant.DEBUG)
//        Bugly.init(application, AppConstant.APP_BUGLY_ID, true)
        INSTANCE = this
        Utils.init(application)
    }

    override fun onBaseContextAttached(base: Context?) {
        super.onBaseContextAttached(base)
        MultiDex.install(base)
        Beta.installTinker(this)
    }

    fun registerActivityLifecycleCallback(callbacks: Application.ActivityLifecycleCallbacks) {
        application.registerActivityLifecycleCallbacks(callbacks)
    }

    companion object {
        lateinit var INSTANCE: BaseApplication
    }
}