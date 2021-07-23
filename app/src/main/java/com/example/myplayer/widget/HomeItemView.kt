package com.example.myplayer.widget

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.myplayer.R
import com.itheima.player.model.bean.HomeItemBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView:RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    /**
     * 初始化的方法
     */
    init {
        View.inflate(context, R.layout.item_home,this)
    }
    /*
    刷新条目view数据
     */
    fun setData(data: HomeItemBean) {
        //歌曲名称
        title.setText(data.comCode)
        //简介
        desc.setText(data.comName)
        //背景图片

//        Picasso.with(context).load("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&hs=0&pn=30&spn=0&di=5210&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2750162677%2C1057879997&os=2376425222%2C3381354115&simid=0%2C0&adpicid=0&lpn=0&ln=1847&fr=&fmq=1626923471313_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=11&oriquery=&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F13789061609%2F641%26refer%3Dhttp%3A%2F%2Finews.gtimg.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629515480%26t%3D2e916db93e4c62133f6724abb71b7fef&fromurl=ippr_z2C%24qAzdH3FAzdH3Fetjo_z%26e3Btgjof_z%26e3Bqq_z%26e3Bv54AzdH3FwAzdH3Fdad8a0daAaBd9Iaa&gsm=1f&rpstart=0&rpnum=0&islist=&querylist=&nojc=undefined").into(bg)
        Picasso.with(context).load("C:\\Users\\17439\\Desktop\\悟空.jpg").into(bg)

    }
}