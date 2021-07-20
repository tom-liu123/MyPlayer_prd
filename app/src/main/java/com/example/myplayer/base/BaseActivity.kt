package com.example.myplayer.base

import android.os.Bundle
import android.view.AbsSavedState
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.toast

/**
 * 所有activity的基类
 */
abstract class BaseActivity :AppCompatActivity(),AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 初始化数据
     */

    private fun initData() {

    }

    /**
     * adapter和listener操作
     */
    protected fun initListener() {

    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int

    /**
     * 在子线程中toast避免了线程不安全的问题
     */
    protected fun myToast(msg:String){
        runOnUiThread {
            toast(msg)
        }
    }
}