package com.example.myplayer.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayer.widget.HomeItemView
import com.example.myplayer.widget.LoadMoreView
import com.itheima.player.model.bean.HomeItemBean

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
        private val list = ArrayList<HomeItemBean>()

    /**
     * 更新数据
    */
    fun updateList(list:List<HomeItemBean>?){
//        if (list==null)return
        /**
         * let  扩展函数
         */
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            //notifyDataSetChanged方法强制listview调用getView来刷新每个Item的内容
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多
     */
    fun loadMore(list:List<HomeItemBean>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }

    }





    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        //如果是最后一条
        if (position==list.size)
            return

        //条目数据
        val data = list.get(position)
        //条目view
        val itemView =holder.itemView as HomeItemView
        //条目刷新
        itemView.setData(data)

    }

    override fun getItemViewType(position: Int): Int {
        if (position==list.size){
            //最后一条
            return 1
        }else{
            //普通条目
            return 0
        }
    }

    override fun getItemCount(): Int {
        return list.size+1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if (viewType==1){
            //最后一条
            return HomeHolder(LoadMoreView(parent?.context))
        }else{
            //普通条目
            return HomeHolder(HomeItemView(parent?.context))
        }

    }
    class HomeHolder(itmeView:View):RecyclerView.ViewHolder(itmeView){

    }
}