package com.tpower.cathaybk.git_user.contract

import com.tpower.cathaybk.git_user.model.bean.GitUser
import com.tpower.cathaybk.global.base.IBaseView
import com.tpower.cathaybk.global.base.IPresenter


/* Created on 2022/5/12 */

interface GitUserDetailContract {

    interface View : IBaseView {
        fun setGitUserDetail(gitUser: GitUser)
        fun showError(errorMsg: String, errorCode: Int)
    }


    interface Presenter : IPresenter<View> {
        fun getGitUserDetail(name:String)
    }
}