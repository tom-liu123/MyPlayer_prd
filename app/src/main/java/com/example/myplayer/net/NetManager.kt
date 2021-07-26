package com.example.myplayer.net

import com.example.myplayer.util.ThreadUtil
import com.example.myplayer.util.URLProviderUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import okhttp3.*
import java.io.IOException

/**
 *
 *发送网络请求类
 */
class NetManager private constructor(){
    val client by lazy { OkHttpClient() }

    companion object{
        val manager by lazy { NetManager }
    }

    /**
     * 发送网络请求
     */
    fun <RESPONSE>sendRequest(req:MRequest<RESPONSE>) {


        val request = Request.Builder()
            .url(req.url)
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
               req.handler.onError(e?.message)
            }

            override fun onResponse(call: Call, response: Response) {

                val result = response.body?.string()

                val parseResult=req.parseResult(result)
                //刷新列表

                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                       req.handler.onSucess(parseResult)
                    }
                })

            }
        })
    }
}