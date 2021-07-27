package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayer.R
import com.example.myplayer.adapter.HomeAdapter
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.presenter.impl.HomePresenterImpl
import com.example.myplayer.view.HomeView
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_list.*

class HomeFragment : BaseFragment(), HomeView {
    //适配
    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list,null)
    }


    /**
     * 刷新的操作
     */
    override fun initListener() {
        //初始化recycleview
        recycleView.layoutManager = LinearLayoutManager(context)

        recycleView.adapter = adapter

        //初始化下拉控件
        refreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.GREEN)

        //刷新监听

        refreshLayout.setOnRefreshListener {
            //刷新的监听

            presenter.loadDatas()
        }
        //监听列表滑动
        recycleView.setOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                when(newState){
//                    RecyclerView.SCROLL_STATE_IDLE->{
//                        println("idel")
//                    }
//                    RecyclerView.SCROLL_STATE_DRAGGING->{
//                        println("drag")
//                    }
//                    RecyclerView.SCROLL_STATE_SETTLING->{
//                        println("setting")
//                    }
//                }
                /**
                 * 监听滑动事件，看滑动事件是否已经结束，并且判断是否是最后一条
                 */
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    //是否最后一条已经显示
                    var layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager){
                        val manager:LinearLayoutManager = layoutManager
                        var lastPosition =
                            manager.findLastCompletelyVisibleItemPosition()
                        if (lastPosition == adapter.itemCount-1){
                            //最后一条已经显示
                            presenter.loadMore(adapter.itemCount-1)

                        }
                    }

                }
            }

//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                println("onScrolled dx=$dx dy=$dy")
//            }
        })
    }


    override fun initData() {
        //初始化
//        loadDatas()

        presenter.loadDatas()
    }

    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun loadSucess(list: List<HomeItemBean>?) {
    //隐藏一下刷新控件
        refreshLayout.isRefreshing =false

        //刷新列表
        adapter.updateList(list)
    }

    override fun loadMore(list: List<HomeItemBean>?) {
        adapter.loadMore(list)
    }

}