package heven.greendaotest.utils

import android.util.Log
import heven.greendaotest.constant.AppConstant

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
object Logger {
    fun v(tag: String, log: String) {
        if (AppConstant.DEBUG) Log.v(tag, log)
    }

    fun d(tag: String, log: String) {
        if (AppConstant.DEBUG) Log.d(tag, log)
    }

    fun i(tag: String, log: String) {
        if (AppConstant.DEBUG) Log.i(tag, log)
    }

    fun w(tag: String, log: String) {
        if (AppConstant.DEBUG) Log.w(tag, log)
    }

    fun w(tag: String, format: String, vararg args: Any) {
        if (AppConstant.DEBUG) Log.w(tag, String.format(format, *args))
    }


    fun e(tag: String, log: String) {
        if (AppConstant.DEBUG) Log.e(tag, log)
    }
}