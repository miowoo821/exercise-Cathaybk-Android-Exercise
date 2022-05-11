package com.tpower.cathaybk.git_user.view

import android.os.Bundle
import android.view.View
import com.tpower.cathaybk.R
import com.tpower.cathaybk.git_user.presenter.GitUserPresenter
import com.tpower.cathaybk.global.base.BaseFragment


/* Created on 2022/5/10 */

class GitUserListFragment :BaseFragment(){
    override fun getLayoutId(): Int = R.layout.fragment_git_user_list

    private val mPresenter by lazy { GitUserPresenter() }

    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): GitUserListFragment {
            val fragment = GitUserListFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        activity?.let { StatusBarUtil.setPaddingSmart(it, toolbar) }

    }
}