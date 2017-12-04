package heven.greendaotest

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * Created by PC-201711161643$ on 2017/11/20 0020.
 */
class BaseApplication : Application() {
    lateinit var daoSession: DaoSession

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        setupDatabase()
        Utils.init(this)
    }

    private fun setupDatabase() {
        val devOpenHelper = DaoMaster.DevOpenHelper(this, "green.db")
        val db = devOpenHelper.writableDatabase
        val daoMaster = DaoMaster(db)
        daoSession = daoMaster.newSession()
    }


     companion object{
         lateinit var INSTANCE:BaseApplication
    }
}