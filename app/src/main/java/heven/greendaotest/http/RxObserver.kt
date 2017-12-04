package heven.greendaotest.http

import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.ToastUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
class RxObserver<T>(private val doNext:(T)->Unit, private val doNull: (() -> Unit)? = null) : Observer<T> {

    private var mDisposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        mDisposable = d
    }

    override fun onComplete() {
        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }

    override fun onNext(t: T) {
        doNext.invoke(t)
    }

    override fun onError(e: Throwable) {
        if (!NetworkUtils.isConnected()){
            doError("网络不可用...")
        }else if (e is UnknownHostException){// 未知主机
            doErrorSwitchHost()
        }else if (e is retrofit2.HttpException){
            if ("HTTP 404 Not Found" == e.message || "HTTP 502 Fiddler - DNS Lookup Failed" == e.message) { // 404 not found
                doErrorSwitchHost()
            } else {
                e.message?.let { doError(it) }
            }
        }else if (e is SocketTimeoutException){
            doError("请求超时，请稍后再试...")
        } else if (e is ConnectException) {
            doError("网络连接有误，请稍后再试...")
        }else if (e is ApiException){// 非 200 错误
            e.message?.let { doError(it) }
        }else if (e is ApiResultDataNullException){
            doNull?.invoke()
        }else {
            doError("请求失败，请稍后再试...")
        }

        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }

    private fun doErrorSwitchHost() {
        ToastUtils.showShort("连接不上服务器...")
    }

    private fun doError(message: String) {
        ToastUtils.showShort(message)
    }
}