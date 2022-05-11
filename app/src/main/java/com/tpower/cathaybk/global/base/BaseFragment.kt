package com.tpower.cathaybk.global.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/* Created on 2022/5/10 */

abstract class BaseFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),null)
    }

    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId():Int
}