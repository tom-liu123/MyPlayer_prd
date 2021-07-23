package com.example.myplayer.presenter.impl

import com.example.myplayer.presenter.interf.HomePresenter
import com.example.myplayer.util.ThreadUtil
import com.example.myplayer.util.URLProviderUtils
import com.example.myplayer.view.HomeView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomePresenterImpl(var homeView:HomeView):HomePresenter {
    /**
     * 初始化数据或者刷新数据
     */
    override fun loadDatas() {
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
        client.newCall(request).enqueue(object : Callback {
            /**
             * 在子线程中调用
             */
            override fun onFailure(call: Call, e: IOException) {
                //隐藏刷新控件
                //回调到view层处理
                homeView.onError(e?.message)

            }

            override fun onResponse(call: Call, response: Response) {

                val result = response.body?.string()
                println("result===================="+result)

                val goson = Gson()
                val list=goson.fromJson<List<HomeItemBean>>(result,object :
                    TypeToken<List<HomeItemBean>>(){}.type)

                println("list=================="+list)
                //刷新列表

                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        //将正确的结果返回给view层
                        homeView.loadSucess(list)
                    }
                })

            }
        })
    }

    override fun loadMore(offset: Int) {
        val  path = URLProviderUtils.getHomeUrl(offset,2)

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
                homeView.onError(e?.message)
            }

            override fun onResponse(call: Call, response: Response) {



                val result = response.body?.string()
                println("result===================="+result)

                val goson = Gson()
                val list=goson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)

                println("list=================="+list)
                //刷新列表

                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        homeView.loadMore(list)
                    }
                })

            }
        })
    }

}