package com.example.myplayer.util

import androidx.appcompat.widget.Toolbar


interface ToolBarManager {
    val toolbar:Toolbar


    fun initMainToolBar(){
        toolbar.setTitle("一凡影音")
    }
}