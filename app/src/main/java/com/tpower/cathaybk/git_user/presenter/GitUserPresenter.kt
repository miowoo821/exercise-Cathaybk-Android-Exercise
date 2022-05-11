package com.tpower.cathaybk.git_user.presenter

import com.tpower.cathaybk.git_user.contract.GitUserContract
import com.tpower.cathaybk.git_user.model.GitUserModel
import com.tpower.cathaybk.global.base.BasePresenter
import com.tpower.cathaybk.net.exception.ExceptionHandle


/* Created on 2022/5/10 */

class GitUserPresenter: BasePresenter<GitUserContract.View>(),GitUserContract.Presenter  {
    private val gitUserModel by lazy { GitUserModel() }


    override fun geGitUser() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = gitUserModel.requestGitUserList()
            .subscribe({
                    gitUserList->
                mRootView?.setGitUser(gitUserList)
            },{
                    throwable->
                mRootView?.showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode)
            })
        addSubscription(disposable)
    }

}