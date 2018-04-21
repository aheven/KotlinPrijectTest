package heven.greendaotest.http.api

import heven.greendaotest.bean.RoomServerBean
import heven.greendaotest.bean.BaseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
interface ApiConfigService {
    @GET("im/roomserver")
    fun getRoomServer(): Observable<BaseModel<RoomServerBean>>
}