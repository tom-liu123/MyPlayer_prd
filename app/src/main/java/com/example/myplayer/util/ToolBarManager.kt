package com.example.myplayer.util

import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myplayer.R
import com.example.myplayer.ui.activity.SettingActivity


interface ToolBarManager {
    val toolbar:Toolbar


    fun initMainToolBar(){
        toolbar.setTitle("一凡影音")
        toolbar.inflateMenu(R.menu.main)
        //如果Java接口中只有一个未实现的方法  可以省略接口对象  直接用{}表示为实现的方法
        toolbar.setOnMenuItemClickListener {
            toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
            true
        }

//        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when(item?.itemId){
//                    R.id.setting->{
//                        //跳转到设置界面
//                        toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
//                    }
//                }
//                return true
//            }
//
//        })
    }

    /**
     * 处理设置页面的呢toolbar
     */
    fun initSettingToolbar(){
        toolbar.setTitle("设置界面")
    }
}