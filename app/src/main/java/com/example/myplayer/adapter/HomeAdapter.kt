package com.example.myplayer.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayer.widget.HomeItemView
import com.itheima.player.model.bean.HomeItemBean

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
        private val list = ArrayList<HomeItemBean>()

    /**
     * 更新数据
    */
    fun updateList(list:List<HomeItemBean>){
    this.list.clear()
    this.list.addAll(list)
        //notifyDataSetChanged方法强制listview调用getView来刷新每个Item的内容
    notifyDataSetChanged()

    }






    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        //条目数据
        val data = list.get(position)
        //条目view
        val itemView =holder.itemView as HomeItemView
        //条目刷新
        itemView.setData(data)

    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent?.context))
    }
    class HomeHolder(itmeView:View):RecyclerView.ViewHolder(itmeView){

    }
}