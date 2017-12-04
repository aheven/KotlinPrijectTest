package heven.greendaotest.http

import android.content.pm.PackageManager
import android.support.v4.util.ArrayMap
import android.text.TextUtils
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.PhoneUtils
import com.blankj.utilcode.util.SPUtils
import heven.greendaotest.BaseApplication
import heven.greendaotest.BuildConfig
import heven.greendaotest.constant.StorageConstant

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 * 公共参数类
 */
class ApiPublicParams {
    // 公共请求参数 (cnt:9)
    val API_PARAM_TOKEN = "token"
    val API_PARAM_UID = "uid"
    val API_PARAM_OS = "os"
    val API_PARAM_OSVERSION = "osversion"
    val API_PARAM_VERSION = "version"
    val API_PARAM_TIME = "time"
    val API_PARAM_CHANNEL = "channel"
    val API_PARAM_IMEI = "imei"
    val API_PARAM_NETWORK = "network"

    var sApiParamToken: String = "0"
    var sApiParamChannel = getChannelName()
    var sApiParamImei = try {
        PhoneUtils.getIMEI()
    } catch (ex: Exception) {
        "860000000000000"
    }
    var sApiParamNetwork = getNetWork()

    private fun getNetWork(): String =
        "wifi"


    /**
     * 获取友盟渠道名
     *
     * @return 如果没有获取成功，那么返回值为空
     */
    private fun getChannelName(): String? {
//        var channelName: String? = null
//        try {
//            val packageManager = BaseApplication.INSTANCE.packageManager
//            if (packageManager != null) {
//                //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
//                val applicationInfo = packageManager.getApplicationInfo(BuildConfig.APPLICATION_ID, PackageManager.GET_META_DATA)
//                if (applicationInfo != null) {
//                    if (applicationInfo.metaData != null) {
//                        //此处这样写的目的是为了在debug模式下也能获取到渠道号，如果用getString的话只能在Release下获取到。
//                        channelName = applicationInfo.metaData.get("UMENG_CHANNEL").toString()
//                    }
//                }
//
//            }
//        } catch (e: PackageManager.NameNotFoundException) {
//            e.printStackTrace()
//        }
        return "qq"
    }

    private fun getApiToken(): String {
        if (TextUtils.isEmpty(sApiParamToken)) {
            sApiParamToken = SPUtils.getInstance().getString(StorageConstant.SP_TOKEN)
        }
        return sApiParamToken
    }

    fun getUid(): Int {
          return SPUtils.getInstance().getInt(StorageConstant.SP_UID)
    }

    fun getRequestPubMap(): Map<String, String> {
        val params = ArrayMap<String, String>()

        params.put(API_PARAM_TOKEN, getApiToken())
//        params.put(API_PARAM_UID, String.valueOf(sApiParamUid));
        params.put(API_PARAM_UID, getUid().toString())
        params.put(API_PARAM_OS, "2") // 0-默认1-苹果 2-安卓
        params.put(API_PARAM_OSVERSION, android.os.Build.VERSION.RELEASE)
        params.put(API_PARAM_VERSION, BuildConfig.VERSION_NAME)
        params.put(API_PARAM_TIME, System.currentTimeMillis().toString())
        params.put(API_PARAM_CHANNEL, sApiParamChannel)
        params.put(API_PARAM_IMEI, sApiParamImei)
        params.put(API_PARAM_NETWORK, sApiParamNetwork)
        return params
    }
}