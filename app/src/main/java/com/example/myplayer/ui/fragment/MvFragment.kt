package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.myplayer.base.BaseFragment

class MvFragment : BaseFragment() {
    override fun initView(): View? {
        val tv = TextView(context)
        tv.gravity= Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text = javaClass.simpleName
        return tv
    }
}