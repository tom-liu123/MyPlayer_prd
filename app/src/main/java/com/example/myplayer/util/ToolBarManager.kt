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

        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.setting->{
                        //跳转到设置界面
                        toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
                    }
                }
                return true
            }

        })
    }
}