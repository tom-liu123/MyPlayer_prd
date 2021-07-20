package com.example.myplayer.base

import android.os.Bundle
import android.view.AbsSavedState
import androidx.appcompat.app.AppCompatActivity
import com.example.myplayer.ui.activity.MainActivity
import com.example.myplayer.util.ToolBarManager
import org.jetbrains.anko.*

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
//kontlin中前面加上open关键字才能够在子类中复写
    open protected fun initData() {

    }

    /**
     * adapter和listener操作
     */
    open protected fun initListener() {

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

    /**
     * 开启activity并且finish当前界面
     */
    //传入一个泛型T，activity可以发生变化
    inline fun <reified T:BaseActivity>startActivityAndFinish(){
        startActivity<T>()
        finish()

    }
}