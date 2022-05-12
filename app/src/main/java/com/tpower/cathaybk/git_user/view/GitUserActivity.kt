package com.tpower.cathaybk.git_user.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tpower.cathaybk.R
import com.tpower.cathaybk.git_user.contract.GitUserContract
import com.tpower.cathaybk.git_user.model.bean.GitUser
import com.tpower.cathaybk.git_user.presenter.GitUserPresenter
import com.tpower.cathaybk.git_user.view.adapter.GitUserListAdapter
import com.tpower.cathaybk.global.base.BaseActivity


/* Created on 2022/5/10 */

class GitUserActivity : BaseActivity(), GitUserContract.View  {
    private val mPresenter by lazy { GitUserPresenter() }
    lateinit var rvGitUserList: RecyclerView

    private val linearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
    override fun layoutId(): Int {
        return R.layout.activity_git_user
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView(){
        rvGitUserList = findViewById(R.id.rvGitUserList)
        mPresenter.attachView(this)
        mPresenter.geGitUser()
    }

    override fun setGitUser(gitUserList: ArrayList<GitUser>) {
        var mGitUserListAdapter: GitUserListAdapter? = null
        mGitUserListAdapter = GitUserListAdapter(this, gitUserList, R.layout.item_git_user)
        mGitUserListAdapter.setOnItemClickListener(object : GitUserListAdapter.OnItemClickListener {
            override fun onItemClick(obj: GitUser, position: Int) {
                toDetail(obj)
            }
        })
        rvGitUserList.adapter = mGitUserListAdapter
        rvGitUserList.layoutManager = linearLayoutManager
        rvGitUserList.itemAnimator = DefaultItemAnimator()
    }

    fun toDetail(obj: GitUser){
        obj.login
        val intent = Intent(this,GitUserDetailActivity::class.java)
        intent.putExtra("name", obj.login);
        startActivity(intent)

    }
    override fun showError(errorMsg: String, errorCode: Int) {
        Log.d("showError", "showError")
    }

    override fun showLoading() {
        Log.d("showLoading", "showLoading")
    }

    override fun dismissLoading() {
        Log.d("dismissLoading", "dismissLoading")
    }
}