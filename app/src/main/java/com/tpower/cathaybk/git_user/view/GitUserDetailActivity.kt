package com.tpower.cathaybk.git_user.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tpower.cathaybk.R
import com.tpower.cathaybk.git_user.contract.GitUserDetailContract
import com.tpower.cathaybk.git_user.model.bean.GitUser
import com.tpower.cathaybk.git_user.presenter.GitUserDetailPresent
import com.tpower.cathaybk.global.base.BaseActivity
import org.w3c.dom.Text


/* Created on 2022/5/10 */

class GitUserDetailActivity() : BaseActivity(), GitUserDetailContract.View {
    lateinit var imgCancel: ImageView
    lateinit var imgAvatar: ImageView
    lateinit var tBadge: TextView
    lateinit var tName: TextView
    lateinit var tMan: TextView
    lateinit var tLocation: TextView
    lateinit var tUrl: TextView

    override fun layoutId(): Int {
        return R.layout.activity_git_user_detail
    }

    private val mPresenter by lazy { GitUserDetailPresent() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        imgCancel = findViewById(R.id.imgCancel)
        imgCancel.setOnClickListener { finish() }
        imgAvatar = findViewById(R.id.imgAvatar)
        tBadge = findViewById(R.id.tBadge)
        tName = findViewById(R.id.tName)
        tMan = findViewById(R.id.tMan)
        tLocation = findViewById(R.id.tLocation)
        tUrl = findViewById(R.id.tUrl)

        val extraData = intent.getStringExtra("name")
        mPresenter.attachView(this)
        extraData?.let { mPresenter.getGitUserDetail(it) }
    }
    fun initDetail(gitUser: GitUser){
        Glide.with(this)
            .load(gitUser.avatarUrl).transform(CircleCrop())
            .transition(DrawableTransitionOptions().crossFade())
            .into(imgAvatar)
        tBadge.text = gitUser.bio
        tName.text = gitUser.login
        tMan.text = gitUser.twitterUsername
        tLocation.text = gitUser.location
        tUrl.text = gitUser.url
    }
    override fun setGitUserDetail(gitUser: GitUser) {
        initDetail(gitUser)
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