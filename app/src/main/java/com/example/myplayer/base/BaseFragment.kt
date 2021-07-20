package com.example.myplayer.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread

/**
 * 所有fragment的基类
 */
abstract class BaseFragment:Fragment() ,AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //子类方法中不一定使用到，所以创建private方法
        init()
    }

    /**
     * 初始化fragment
     */
    protected fun init() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView()
    }

    /**
     * 获取布局id
     */
    abstract fun initView(): View?


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initListener()
        initData()

    }

    /**
     * 数据的初始化
     */
    protected fun initData() {
    }

    /**
     * adapter和listener的操作
     */
    protected fun initListener() {
    }

    fun myToast(msg:String){
        context?.runOnUiThread { myToast(msg) }
    }

}