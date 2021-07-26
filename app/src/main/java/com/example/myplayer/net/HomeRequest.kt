package com.example.myplayer.net

import com.example.myplayer.util.URLProviderUtils
import com.itheima.player.model.bean.HomeItemBean

/**
 * 首页请求
 */
class HomeRequest(offset:Int,handler:ResponseHandler<List<HomeItemBean>>)
    :MRequest<List<HomeItemBean>>(URLProviderUtils.getHomeUrl(offset,20),handler) {

}