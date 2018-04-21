package heven.greendaotest.http.api

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import heven.greendaotest.bean.RoomServerBean
import heven.greendaotest.http.ApiServiceManager
import heven.greendaotest.http.RxHelper
import heven.greendaotest.http.RxObserver

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
object ApiConfig {
    private val sService = ApiServiceManager.create(ApiConfigService::class.java)

    fun <E> getRoomServer(rxObserver: RxObserver<RoomServerBean>, provider: LifecycleProvider<E>) {
        sService.getRoomServer()
                .compose(RxHelper.handleResult())
                .bindToLifecycle(provider)
                .subscribe(rxObserver)
    }
}