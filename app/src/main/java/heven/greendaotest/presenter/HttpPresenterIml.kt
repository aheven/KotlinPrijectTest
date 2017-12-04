package heven.greendaotest.presenter

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import heven.greendaotest.http.RxObserver
import heven.greendaotest.http.api.ApiConfig
import heven.greendaotest.presenter.view.HttpView
import heven.greendaotest.utils.Logger
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by PC-201711161643$ on 2017/11/22 0022.
 */
class HttpPresenterIml<E, out V>(private val view: V) : HttpPresenter where V : LifecycleProvider<E>, V:HttpView{

    override fun getMainUrl() {
        ApiConfig.getMainUrl(RxObserver({
            view.getMainUrlSuccess(it)
        }),view)
    }

    override fun timeTick() {
        Observable.interval(0,1,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindToLifecycle(view)
                .subscribe { Logger.e("timeTick",it.toString()) }
    }
}