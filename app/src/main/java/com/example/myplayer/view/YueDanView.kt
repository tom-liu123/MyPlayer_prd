package com.example.myplayer.view

import com.itheima.player.model.bean.HomeItemBean
import com.itheima.player.model.bean.YueDanBean

interface YueDanView {
    /**
     * 获取数据失败
     */
    fun onError(message: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
    fun loadSucess(response: YueDanBean?)

    /**
     * 加载更多成功
     */
    fun loadMore(response: YueDanBean?)
}