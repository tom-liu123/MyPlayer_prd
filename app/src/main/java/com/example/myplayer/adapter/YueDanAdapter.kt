package com.example.myplayer.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayer.widget.YueDanItemView
import com.itheima.player.model.bean.YueDanBean

/**
 *
 * 悦单界面的adapter
 */
class YueDanAdapter: RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {

    private var list = ArrayList<YueDanBean.PlayListsBean>()

    //更新的方法
    fun updateList(list:List<YueDanBean.PlayListsBean>?){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            /**
             * 把当前列表刷新一下
             */
            notifyDataSetChanged()
        }

    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(parent?.context))
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class YueDanHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}