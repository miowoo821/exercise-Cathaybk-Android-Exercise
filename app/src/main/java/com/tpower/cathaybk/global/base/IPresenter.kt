package com.tpower.cathaybk.global.base


/* Created on 2022/5/10 */

interface IPresenter<in V : IBaseView> {
    fun attachView(mRootView: V)

    fun detachView()
}