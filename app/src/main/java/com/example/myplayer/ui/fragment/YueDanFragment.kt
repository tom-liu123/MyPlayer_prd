package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.AbsListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        //初始化刷新的控件
        refreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.GREEN)

        //监听刷新控件
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
        //监听列表滑动
        recycleView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    //空闲状态  判断最后可见条目  是否是列表的最后一条
                    var layoutManager = recyclerView.layoutManager

                    if (!(layoutManager is LinearLayoutManager))
                        return
                    //显示列表  智能类型转换
                    var lastPos = layoutManager.findLastVisibleItemPosition()
                    if (lastPos==adapter.itemCount -1 ){
                        //加载更多已经显示
                        presenter.loadMore(adapter.itemCount -1)
                    }

                }
            }

//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//            }
        })
    }

    override fun initData() {

        //加载数据
        presenter.loadDatas()
    }

    override fun onError(message: String?) {
        //隐藏刷新控件
        refreshLayout.isRefreshing =false
        myToast("加载数据失败")
    }

    override fun loadSucess(response: YueDanBean?) {
        //隐藏刷新控件
        refreshLayout.isRefreshing =false
        //刷新adapter
        myToast("数据加载成功")
        adapter.updateList(response?.data)
    }

    override fun loadMore(response: YueDanBean?) {
        //刷新列表
        adapter.loadMore(response?.data)

    }
}