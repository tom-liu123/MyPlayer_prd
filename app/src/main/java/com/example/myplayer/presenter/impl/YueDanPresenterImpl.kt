package com.example.myplayer.presenter.impl

import android.service.autofill.FillEventHistory
import com.example.myplayer.net.ResponseHandler
import com.example.myplayer.net.YueDanRequest
import com.example.myplayer.presenter.interf.YueDanPresenter
import com.example.myplayer.view.YueDanView
import com.itheima.player.model.bean.YueDanBean

class YueDanPresenterImpl(var yuedanView:YueDanView):YueDanPresenter, ResponseHandler<YueDanBean> {
    override fun loadDatas() {
YueDanRequest(YueDanPresenter.TYPE_INIT_OR_REFRESH,0,this).excute()
    }

    override fun loadMore(offset: Int) {
        YueDanRequest(YueDanPresenter.TYPE_LOAD_MORE,offset,this).excute()

    }

    override fun onError(type: Int, msg: String?) {
        yuedanView.onError(msg)
    }

    override fun onSucess(type: Int, result: YueDanBean) {
        if (type==YueDanPresenter.TYPE_INIT_OR_REFRESH){
            yuedanView.loadSucess(result)
        }else if (type == YueDanPresenter.TYPE_LOAD_MORE){
            yuedanView.loadMore(result)
        }

    }

}