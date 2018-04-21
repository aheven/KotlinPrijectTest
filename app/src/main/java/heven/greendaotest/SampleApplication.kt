package heven.greendaotest

import com.tencent.tinker.loader.app.TinkerApplication
import com.tencent.tinker.loader.shareutil.ShareConstants

/*
参数1：tinkerFlags 表示Tinker支持的类型 dex only、library only or all suuport，default: TINKER_ENABLE_ALL
参数2：delegateClassName Application代理类 这里填写你自定义的ApplicationLike
参数3：loaderClassName Tinker的加载器，使用默认即可
参数4：tinkerLoadVerifyFlag 加载dex或者lib是否验证md5，默认为false
* */
class SampleApplication : TinkerApplication(ShareConstants.TINKER_ENABLE_ALL, "heven.greendaotest.BaseApplication",
        "com.tencent.tinker.loader.TinkerLoader", false)