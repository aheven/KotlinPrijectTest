package heven.greendaotest.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

class User : BaseObservable() {

    var firstName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }
        @Bindable get

    var lastName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
        @Bindable get

    var headImage:String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.headImage)
        }
        @Bindable get

    fun changeUser(){
        firstName = "你好"
        lastName = "databinding"
        headImage = "https://mmbiz.qpic.cn/mmbiz_jpg/ibOPib7DDfdicpia8GMYsnFyrnSsRbz3QE1z58SS5JOsKfjI6Ldia6Fc737jJSXx77zRVUZlDE1YD4f7qZqzcOw3ktg/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1"
    }
}