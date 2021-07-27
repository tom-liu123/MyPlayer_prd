package com.example.myplayer.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayer.widget.YueDanItemView

/**
 *
 * 悦单界面的adapter
 */
class YueDanAdapter: RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(parent?.context))
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 20
    }

    class YueDanHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}