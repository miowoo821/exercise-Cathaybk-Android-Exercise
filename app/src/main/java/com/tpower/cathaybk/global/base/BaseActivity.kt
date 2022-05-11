package com.tpower.cathaybk.global.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/* Created on 2022/5/10 */

abstract class BaseActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())


    }

    override fun onStart() {
        super.onStart()
    }
    abstract fun layoutId(): Int

}