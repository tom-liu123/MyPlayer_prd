package com.example.myplayer.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplayer.R
import com.example.myplayer.adapter.HomeAdapter
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.util.URLProviderUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home,null)
    }

    override fun initListener() {
        //初始化recycleview
        recycleView.layoutManager = LinearLayoutManager(context)
        //适配
        val adapter=HomeAdapter()
        recycleView.adapter = adapter

    }

    override fun initData() {
        //初始化
        loadDatas()
    }

    private fun loadDatas() {
        val  path = URLProviderUtils.getHomeUrl(0,20)

       val client= OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object :Callback{
            /**
             * 在子线程中调用
             */
            override fun onFailure(call: Call, e: IOException) {
                myToast("获取数据失败")
            }

            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                val result = response.body?.string()

                val goson = Gson()
               val list=goson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)

                println("数据操作成功："+list.size)

            }
        })

    }

}