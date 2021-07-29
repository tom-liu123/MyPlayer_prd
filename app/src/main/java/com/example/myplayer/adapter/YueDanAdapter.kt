package com.example.myplayer.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayer.widget.LoadMoreView
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

            println("list==============================>"+list)
            this.list.clear()
            this.list.addAll(list)

            println("list==============================>"+list)
            /**
             * 把当前列表刷新一下
             */
            notifyDataSetChanged()
        }

    }
    fun loadMore(list:List<YueDanBean.PlayListsBean>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 获取不同条目的view样式
     */
    override fun getItemViewType(position: Int): Int {
        if (position==list.size)
            //最后一条
            return 1
        else{
            //普通条目控件
            return 0
        }
        return super.getItemViewType(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        if(viewType ==1){
            //刷新控件
            return YueDanHolder(LoadMoreView(parent?.context))
        }else{
            //普通条目
            return YueDanHolder(YueDanItemView(parent?.context))
        }
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
        if (position == list.size)
            return//最后一条加载更多条目就不做处理了

        var data1 = list.get(position)
        //view
        var itemView = holder?.itemView as YueDanItemView
        //view+data
        itemView.setData(data1)
    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    class YueDanHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}