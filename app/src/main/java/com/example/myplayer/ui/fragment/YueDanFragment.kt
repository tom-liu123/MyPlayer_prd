package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplayer.R
import com.example.myplayer.adapter.YueDanAdapter
import com.example.myplayer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*

/**
 *
 */

class YueDanFragment : BaseFragment() {
    val adapter by lazy { YueDanAdapter() }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list,null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
    }
}