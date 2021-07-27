package com.example.myplayer.net

import com.example.myplayer.util.URLProviderUtils
import com.itheima.player.model.bean.YueDanBean

/**
 * 悦单界面网络请求
 */
class YueDanRequest(type:Int,offset:Int,handler: ResponseHandler<YueDanBean>)
    :MRequest<YueDanBean>(type,URLProviderUtils.getYueDanUrl(offset,20),handler) {
}