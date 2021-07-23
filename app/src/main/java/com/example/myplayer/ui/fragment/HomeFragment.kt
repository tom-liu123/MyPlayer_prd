package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplayer.R
import com.example.myplayer.adapter.HomeAdapter
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.util.ThreadUtil
import com.example.myplayer.util.URLProviderUtils
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment : BaseFragment() {
    //适配
    val adapter by lazy { HomeAdapter() }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home,null)
    }

    override fun initListener() {
        //初始化recycleview
        recycleView.layoutManager = LinearLayoutManager(context)

        recycleView.adapter = adapter

        //初始化下拉控件
        refreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.GREEN)

        //刷新监听

        refreshLayout.setOnRefreshListener {
            //刷新的监听

            loadDatas()
        }
    }


    override fun initData() {
        //初始化
        loadDatas()
    }

    private fun loadDatas() {
        val  path = URLProviderUtils.getHomeUrl(0,2)

        println("path=================="+path)

       val client= OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()

        println("request==============="+request)
        /**
         * 添加到队列中
         */
        client.newCall(request).enqueue(object :Callback{
            /**
             * 在子线程中调用
             */
            override fun onFailure(call: Call, e: IOException) {
                //隐藏刷新控件
                refreshLayout.isRefreshing = false
                myToast("获取数据失败")
            }

            override fun onResponse(call: Call, response: Response) {
                refreshLayout.isRefreshing = false

                myToast("获取数据成功")
                val result = response.body?.string()
                println("result===================="+result)

                val goson = Gson()
               val list=goson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)

                println("list=================="+list)
                //刷新列表

                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        adapter.updateList(list)
                    }
                })

            }
        })

    }

}