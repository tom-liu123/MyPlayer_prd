package com.example.myplayer.net

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import java.lang.reflect.ParameterizedType

/**
 * 所有请求的基类
 */
open class MRequest<RESPONSE>(val type:Int,val url:String,val handler:ResponseHandler<RESPONSE>) {
    /**
     * 解析网络请求的结果
     */
    fun parseResult(result: String?): RESPONSE {
        val goson = Gson()
        //获取泛型类型

        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val list=goson.fromJson<RESPONSE>(result,type)
        return list

    }

    /**
     * 发送网络请求
     */
    fun excute(){
        NetManager.manager.sendRequest(this)
    }


}