package com.tpower.cathaybk.git_user.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tpower.cathaybk.R
import com.tpower.cathaybk.git_user.model.bean.GitUser


/* Created on 2022/5/10 */

class GitUserListAdapter(var mContext: Context, var mData: ArrayList<GitUser>, private var mLayoutId: Int) :
    RecyclerView.Adapter<GitUserListAdapter.ContentViewHolder>() {


    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgUserIcon: ImageView?=null
        var tName: TextView?=null
        var tMark: TextView?=null
        init {
             imgUserIcon  = itemView.findViewById(R.id.imgUserIcon)
             tName = itemView.findViewById(R.id.tName)
            tMark = itemView.findViewById(R.id.tMark)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(mContext)?.inflate(mLayoutId, parent, false)
        return ContentViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.tName?.text = mData[position].login
        holder.tMark?.text = mData[position].company
        holder.imgUserIcon?.let {
            Glide.with(mContext)
                .load(mData[position].avatarUrl).transform(CircleCrop())
                .transition(DrawableTransitionOptions().crossFade())
                .into(it)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}