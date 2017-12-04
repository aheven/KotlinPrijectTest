package heven.greendaotest.http

import heven.greendaotest.constant.AppConstant
import heven.greendaotest.utils.Logger
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
object HttpClientManager {
    private val DEFAULT_TIMEOUT = 10L // 请求超时时间
    val mOkHttpClient: OkHttpClient

    init {
        //手动创建一个OkHttpClient并设置超时时间
        val httpClientBuilder = OkHttpClient.Builder()
        mOkHttpClient = httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val request = chain.request()
                    val newBuilder = request.url().newBuilder()
                    val requestPramsMap = ApiPublicParams().getRequestPubMap()
                    for (entry in requestPramsMap.entries) {
                        newBuilder.addQueryParameter(entry.key, entry.value)
                    }

                    val newRequest = request.newBuilder().url(newBuilder.build()).build()

                    Logger.i(AppConstant.AUTHOR, "HttpClientManager ...  intercept() -> newRequest = $newRequest")
                    chain.proceed(newRequest)
                }.build()
    }
}