package com.example.myplayer.ui.activity

import android.preference.PreferenceManager
import androidx.appcompat.widget.Toolbar
import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.util.ToolBarManager
import org.jetbrains.anko.find

class SettingActivity:BaseActivity(),ToolBarManager{
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_setting

    }

    override fun initData() {
        initSettingToolbar()
        //获取推送通知有没有选中
        var sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push",false)
        println("push=$push")
    }
}