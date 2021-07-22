package com.example.myplayer.adapter

import kotlin.jvm.JvmStatic
import com.example.myplayer.adapter.test.demo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import java.util.ArrayList

object test {
    @JvmStatic
    fun main(args: Array<String>) {
        val demo = demo()
        //        demo()
        println(demo)
    }

    internal class demo {
        var result =
            "[{\"id\":1,\"departmentId\":null,\"name\":\"威震天\",\"mobile\":\"13011111111\",\"telephone\":\"80000000\",\"gender\":1,\"email\":\"578514363@qq.com\",\"position\":\"产品\",\"enable\":1},{\"id\":2,\"departmentId\":null,\"name\":\"测试\",\"mobile\":\"13000000000\",\"telephone\":\"811111111\",\"gender\":2,\"email\":\"555555555@qq.com\",\"position\":\"前端工程师\",\"enable\":1}]"
        var gson = Gson()
        var type = object : TypeToken<ArrayList<HomeItemBean?>?>() {}.type
        var list = gson.fromJson<List<HomeItemBean>>(result, type)
    }
}