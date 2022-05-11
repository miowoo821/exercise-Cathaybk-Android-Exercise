package com.tpower.cathaybk.git_user.contract

import com.tpower.cathaybk.git_user.model.bean.GitUser
import com.tpower.cathaybk.global.base.IBaseView
import com.tpower.cathaybk.global.base.IPresenter


/* Created on 2022/5/10 */

interface GitUserContract {

    interface View: IBaseView {
        fun setGitUser(gitUserList: ArrayList<GitUser>)

        fun showError(errorMsg:String,errorCode:Int)
    }


    interface Presenter: IPresenter<View> {
        fun geGitUser()
    }
}