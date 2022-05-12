package com.tpower.cathaybk.git_user.presenter

import com.tpower.cathaybk.git_user.contract.GitUserDetailContract
import com.tpower.cathaybk.git_user.model.GitUserDetailModel
import com.tpower.cathaybk.global.base.BasePresenter
import com.tpower.cathaybk.net.exception.ExceptionHandle


/* Created on 2022/5/12 */

class GitUserDetailPresent : BasePresenter<GitUserDetailContract.View>(), GitUserDetailContract.Presenter   {
    private val gitUserDetailModel by lazy { GitUserDetailModel() }

    override fun getGitUserDetail(name:String) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = gitUserDetailModel.requestGitUserDetail(name)
            .subscribe({
                    gitUser->
                mRootView?.setGitUserDetail(gitUser)
            },{
                    throwable->
                mRootView?.showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode)
            })
        addSubscription(disposable)
    }

}