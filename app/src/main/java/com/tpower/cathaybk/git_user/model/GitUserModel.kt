package com.tpower.cathaybk.git_user.model

import com.tpower.cathaybk.git_user.model.bean.GitUser
import com.tpower.cathaybk.net.RetrofitManager
import com.tpower.cathaybk.rx.scheduler.SchedulerUtils
import io.reactivex.Observable


/* Created on 2022/5/10 */

class GitUserModel {
    /**獲取GitUser*/
    fun requestGitUserList(): Observable<ArrayList<GitUser>> {

        return RetrofitManager.service.getGitUserData().compose(SchedulerUtils.ioToMain())
    }

    /**下拉更多*/
    fun loadMoreData():Observable<ArrayList<GitUser>>{

        return RetrofitManager.service.getMoreGitUser()
            .compose(SchedulerUtils.ioToMain())
    }
}