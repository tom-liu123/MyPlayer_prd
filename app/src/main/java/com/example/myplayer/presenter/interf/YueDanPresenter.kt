package com.example.myplayer.presenter.interf

interface YueDanPresenter {
    /**
     * 定义一个伴生对象
     */
    companion object{
        val TYPE_INIT_OR_REFRESH =1
        val TYPE_LOAD_MORE = 2
    }
    fun loadDatas()
    fun loadMore(offset: Int)
}
