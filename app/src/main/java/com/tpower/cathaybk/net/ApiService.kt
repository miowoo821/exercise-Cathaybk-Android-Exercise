package com.tpower.cathaybk.net

import com.tpower.cathaybk.git_user.model.bean.GitUser
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/* Created on 2022/5/10 */

interface ApiService {

    /** 取得GitUser */
    @GET("users")
    fun getGitUserData():Observable<ArrayList<GitUser>>

    /** 取得更多GitUser */
    @GET("users")
    fun getMoreGitUser():Observable<ArrayList<GitUser>>

    /** 取得GitUserDetail */
    @GET("users/{username}")
    fun getGitUserDataDetail(@Path("username") username:String):Observable<GitUser>

}