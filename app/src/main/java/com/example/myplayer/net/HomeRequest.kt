package com.example.myplayer.net

import com.example.myplayer.util.URLProviderUtils
import com.itheima.player.model.bean.HomeItemBean

/**
 * 首页请求
 * 首页数据请求类
 */
class HomeRequest(type:Int,offset:Int,handler:ResponseHandler<List<HomeItemBean>>)
    :MRequest<List<HomeItemBean>>(type,URLProviderUtils.getHomeUrl(offset,20),handler) {

}