package heven.greendaotest.presenter.view

import heven.greendaotest.bean.MainUrlBean

/**
 * Created by PC-201711161643$ on 2017/11/22 0022.
 */
interface HttpView{
    fun getMainUrlSuccess(mainUrlBean: MainUrlBean){}
}