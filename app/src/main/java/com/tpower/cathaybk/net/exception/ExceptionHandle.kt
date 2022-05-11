package com.tpower.cathaybk.net.exception

import com.google.gson.JsonParseException

import org.json.JSONException

import java.net.ConnectException

import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException


/* Created on 2022/5/10 */

class ExceptionHandle {

    companion object {
        var errorCode = ErrorStatus.UNKNOWN_ERROR
        var errorMsg = "請求失敗，請稍後重試"

        fun handleException(e: Throwable): String {
            e.printStackTrace()
            if (e is SocketTimeoutException) {
                errorMsg = "網路連接異常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is ConnectException) {
                errorMsg = "網路連接異常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException) {
                errorMsg = "資料解析異常"
                errorCode = ErrorStatus.SERVER_ERROR
            } else if (e is ApiException) {//伺服器返回錯誤
                errorMsg = e.message.toString()
                errorCode = ErrorStatus.SERVER_ERROR
            } else if (e is UnknownHostException) {
                errorMsg = "網路連接異常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is IllegalArgumentException) {
                errorMsg = "參數錯誤"
                errorCode = ErrorStatus.SERVER_ERROR
            } else {//未知错误
                errorMsg = "未知錯誤"
                errorCode = ErrorStatus.UNKNOWN_ERROR
            }
            return errorMsg
        }

    }

}