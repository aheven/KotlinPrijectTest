package heven.greendaotest.http

import heven.greendaotest.constant.ApiConstant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Api管理工具类，通过该类创建相应的api-service类
 */
object ApiServiceManager {
    private val mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiConstant.API_BASE_URL)
            .client(HttpClientManager.mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun <T> create(service: Class<T>): T = mRetrofit.create(service)
}