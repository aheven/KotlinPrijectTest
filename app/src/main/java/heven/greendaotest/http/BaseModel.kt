package heven.greendaotest.http

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
data class BaseModel<out T>(val code: Int, val message: String) {
    val data: T? = null
    val isSuccess
    get() = code == 200
}