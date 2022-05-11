package com.tpower.cathaybk.global.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/* Created on 2022/5/10 */

abstract class BaseAdapter <T>(var mContext: Context, var mData: ArrayList<T>,
                               private var mLayoutId: Int) : RecyclerView.Adapter<ViewHolder>() {
    interface CallBackListener{
        fun onItemLongClick(obj: Any?, position: Int): Boolean
        fun onItemClick(obj: Any?, position: Int)
    }

    interface MultipleType<in T> {
        fun getLayoutId(item: T, position: Int): Int
    }

    protected var mInflater: LayoutInflater? = null
    private var mTypeSupport: MultipleType<T>? = null

    private var mCallBackListener: CallBackListener? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    //需要多布局
    constructor(context: Context, data: ArrayList<T>, typeSupport: MultipleType<T>) : this(context, data, -1) {
        this.mTypeSupport = typeSupport
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mTypeSupport != null) {
            //需要多布局
            mLayoutId = viewType
        }
        //创建view
        val view = mInflater?.inflate(mLayoutId, parent, false)
        return ViewHolder(view!!)
    }

    override fun getItemViewType(position: Int): Int {
        //多布局问题
        return mTypeSupport?.getLayoutId(mData[position], position) ?: super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindData(holder, mData[position], position)//綁定數據

        mCallBackListener?.let {
            holder.itemView.setOnClickListener { mCallBackListener!!.onItemClick(mData[position], position) }
            holder.itemView.setOnLongClickListener { mCallBackListener!!.onItemLongClick(mData[position], position) }
        }
    }

    /**
     * 将必要参数传递出去
     *
     * @param holder
     * @param data
     * @param position
     */
    protected abstract fun bindData(holder: ViewHolder, data: T, position: Int)

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setCallBackListener(callBackListener: CallBackListener) {
        this.mCallBackListener = callBackListener
    }
}