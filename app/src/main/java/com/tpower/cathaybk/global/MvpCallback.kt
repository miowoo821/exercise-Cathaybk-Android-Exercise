package com.tpower.cathaybk.global


/* Created on 2022/5/10 */

interface MvpCallback {
    fun onSuccess(msg:String)//資料請求成功
    fun onFailure(msg:String)//資料請求失敗
    fun onError()//資料請求錯誤
    fun onComplete()//資料請求完成
}