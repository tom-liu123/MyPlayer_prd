package com.example.myplayer.view

import com.itheima.player.model.bean.HomeItemBean

/**
 * home页面和presenter交互
 */
interface HomeView {
    /**
     * 获取数据失败
     */
     fun onError(message: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
     fun loadSucess(list: List<HomeItemBean>?)

    /**
     * 加载更多成功
     */
     fun loadMore(list: List<HomeItemBean>?)
}