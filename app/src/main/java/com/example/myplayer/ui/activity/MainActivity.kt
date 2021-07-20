package com.example.myplayer.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.util.FragmentUtil
import com.example.myplayer.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*

import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolBarManager {
    /**
     * by lazy { find<Toolbar>(R.id.toolbar) }
     * 惰性加载，用的时候才会加载，不用的时候不加载
     * by lazy是线程安全的
     *
     */
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        //设置tab的监听事件
        bottomBar.setOnTabSelectListener {
            var transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it)!!,it.toString())
            transaction.commit()
        }
    }

}