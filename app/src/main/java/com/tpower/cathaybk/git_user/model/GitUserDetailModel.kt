package com.tpower.cathaybk.git_user.model

import com.tpower.cathaybk.git_user.model.bean.GitUser
import com.tpower.cathaybk.net.RetrofitManager
import com.tpower.cathaybk.rx.scheduler.SchedulerUtils
import io.reactivex.Observable


/* Created on 2022/5/12 */

class GitUserDetailModel {
    /**獲取GitUserDetail*/
    fun requestGitUserDetail(name:String): Observable<GitUser> {
        return RetrofitManager.service.getGitUserDataDetail(name).compose(SchedulerUtils.ioToMain())
    }
}