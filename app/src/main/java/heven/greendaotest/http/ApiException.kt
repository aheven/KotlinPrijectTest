package heven.greendaotest.http

/**
 * Created by PC-201711161643$ on 2017/11/21 0021.
 */
class ApiException(code: Int, message: String) : Exception(message, Throwable(code.toString()))