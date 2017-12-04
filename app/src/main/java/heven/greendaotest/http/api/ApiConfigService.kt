package heven.greendaotest.http.api

import heven.greendaotest.bean.MainUrlBean
import heven.greendaotest.http.BaseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
interface ApiConfigService {
    @GET("config/domainUrl")
    fun getMainUrl(): Observable<BaseModel<MainUrlBean>>
}