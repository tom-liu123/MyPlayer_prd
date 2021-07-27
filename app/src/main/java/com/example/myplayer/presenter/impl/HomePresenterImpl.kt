package com.example.myplayer.presenter.impl

import com.example.myplayer.net.HomeRequest
import com.example.myplayer.net.ResponseHandler
import com.example.myplayer.presenter.interf.HomePresenter
import com.example.myplayer.view.HomeView
import com.itheima.player.model.bean.HomeItemBean

class HomePresenterImpl(var homeView:HomeView?):HomePresenter, ResponseHandler<List<HomeItemBean>> {
    /**
     * 解绑view和presenter层的操作
     */
    fun destoryView(){
        if(homeView!=null){
            homeView =null
        }

    }

    /**
     * 初始化数据或者刷新数据
     */
    override fun loadDatas() {
        //定义一个request
        //.excute()发送request
        HomeRequest(HomePresenter.TYPE_INIT_OR_REFRESH,0,this).excute()

        //发送request
//        NetManager.manager.sendRequest(request)

//        val  path = URLProviderUtils.getHomeUrl(0,2)
//        val client= OkHttpClient()
//        val request = Request.Builder()
//            .url(path)
//            .get()
//            .build()
//        /**
//         * 添加到队列中
//         */
//        client.newCall(request).enqueue(object : Callback {
//            /**
//             * 在子线程中调用
//             */
//            override fun onFailure(call: Call, e: IOException) {
//                //隐藏刷新控件
//                //回调到view层处理
//                homeView.onError(e?.message)
//
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//
//                val result = response.body?.string()
//                println("result===================="+result)
//
//                val goson = Gson()
//                val list=goson.fromJson<List<HomeItemBean>>(result,object :
//                    TypeToken<List<HomeItemBean>>(){}.type)
//
//                println("list=================="+list)
//                //刷新列表
//
//                ThreadUtil.runOnMainThread(object :Runnable{
//                    override fun run() {
//                        //将正确的结果返回给view层
//                        homeView.loadSucess(list)
//                    }
//                })
//
//            }
//        })
    }

    override fun loadMore(offset: Int) {

        //发送request
        HomeRequest(HomePresenter.TYPE_LOAD_MORE,offset,this).excute()

        //发送request
//        NetManager.manager.sendRequest(request)
//        val  path = URLProviderUtils.getHomeUrl(offset,2)
//
//        println("path=================="+path)
//
//        val client= OkHttpClient()
//        val request = Request.Builder()
//            .url(path)
//            .get()
//            .build()
//
//        println("request==============="+request)
//        /**
//         * 添加到队列中
//         */
//        client.newCall(request).enqueue(object :Callback{
//            /**
//             * 在子线程中调用
//             */
//            override fun onFailure(call: Call, e: IOException) {
//                //隐藏刷新控件
//                homeView.onError(e?.message)
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//
//
//
//                val result = response.body?.string()
//                println("result===================="+result)
//
//                val goson = Gson()
//                val list=goson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)
//
//                println("list=================="+list)
//                //刷新列表
//
//                ThreadUtil.runOnMainThread(object :Runnable{
//                    override fun run() {
//                        //将结果回调给view层
//                        homeView.loadMore(list)
//                    }
//                })
//
//            }
//        })
    }

    override fun onError(type:Int,msg: String?) {

        homeView?.onError(msg)
    }

    override fun onSucess(type:Int,result: List<HomeItemBean>) {
        //区分初始化数据和加载更多数据

        when(type){
            HomePresenter.TYPE_INIT_OR_REFRESH ->homeView?.loadSucess(result)
            HomePresenter.TYPE_LOAD_MORE ->homeView?.loadMore(result)
        }

    }

}