package heven.greendaotest.http

import heven.greendaotest.bean.BaseModel
import heven.greendaotest.constant.AppConstant
import heven.greendaotest.utils.Logger
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
object RxHelper {
    fun <T> handleResult(): ObservableTransformer<BaseModel<T>, T> =
            ObservableTransformer { upstream ->
                val flatMap = upstream.flatMap<T> { result ->
                    if (result.isSuccess) { // code: 200
                        if (result.data == null) Observable.error(ApiResultDataNullException()) else {
                            Logger.i(AppConstant.AUTHOR, "RxHelper ...  handleResult() -> result = ${result.data}")
                            createData(result.data)
                        }
                    } else {
                        Observable.error(ApiException(result.code, result.message))
                    }
                }
                flatMap.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }

    private fun <T> createData(data: T): ObservableSource<out T>? {
        return Observable.create({ e ->
            try {
                e.onNext(data)
                e.onComplete()
            } catch (ex: Exception) {
                e.onError(ex)
            }
        })
    }
}