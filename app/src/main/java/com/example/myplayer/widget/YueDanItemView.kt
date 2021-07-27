package com.example.myplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.myplayer.R
import com.itheima.player.model.bean.YueDanBean
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * 悦单界面每个条目的自定义view
 */
class YueDanItemView :RelativeLayout{


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        View.inflate(context, R.layout.item_yuedan,this)
    }

    /**
     * 条目view控件的初始化
     */
    fun setData(data1: YueDanBean.PlayListsBean) {
        //歌曲名称
        title1.text = data1.comCode
        //歌手名称
        auto_name.text = data1.comName
        //歌曲个数
        count.text = data1.realTask.toString()
    }
}