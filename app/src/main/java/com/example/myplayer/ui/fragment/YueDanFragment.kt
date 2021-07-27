package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplayer.R
import com.example.myplayer.adapter.YueDanAdapter
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.presenter.impl.YueDanPresenterImpl
import com.example.myplayer.view.YueDanView
import com.itheima.player.model.bean.YueDanBean
import kotlinx.android.synthetic.main.fragment_list.*

/**
 *
 */

class YueDanFragment : BaseFragment(), YueDanView {
    val adapter by lazy { YueDanAdapter() }
    val presenter by lazy { YueDanPresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list,null)
    }

    override fun initListener() {
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter
    }

    override fun initData() {

        //加载数据
        presenter.loadDatas()
    }

    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun loadSucess(response: YueDanBean?) {
        //刷新adapter
        myToast("数据加载成功")
        adapter.updateList(response?.data)
    }

    override fun loadMore(response: YueDanBean?) {
    }
}