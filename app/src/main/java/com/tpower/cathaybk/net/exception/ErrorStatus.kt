package com.tpower.cathaybk.net.exception


/* Created on 2022/5/10 */

object ErrorStatus {
    @JvmField
    val SUCCESS = 0

    /**未知錯誤*/
    @JvmField
    val UNKNOWN_ERROR = 1002

    /**伺服器錯誤*/
    @JvmField
    val SERVER_ERROR = 1003

    /**TIME OUT*/
    @JvmField
    val NETWORK_ERROR = 1004

    /**API解析錯誤*/
    @JvmField
    val API_ERROR = 1005

}