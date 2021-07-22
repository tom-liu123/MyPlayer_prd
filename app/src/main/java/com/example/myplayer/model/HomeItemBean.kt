package com.itheima.player.model.bean

import java.math.BigDecimal

/**
 * ClassName:HomeItemBean
 * Description:home界面每个条目的bean
 */
//data class HomeItemBean(var type: String, var id: Int,
//                        var title: String, var description: String?,
//                        var posterPic: String?,var thumbnailPic: String?,
//                        var url: String,var hdUrl: String?,var videoSize: Int,
//                        var hdVideoSize: Int,var uhdVideoSize: Int,var status: Int,
//                        var traceUrl: String?,var clickUrl: String?,var uhdUrl: String?)


data class HomeItemBean(var comCode: String, var comName: String,
                        var realTask: BigDecimal, var zcTask: BigDecimal?,
                        var sgTask: BigDecimal?, var sjTask: BigDecimal?,
                        var zcbTask:BigDecimal?,var presetTask:BigDecimal?,
                        var rate:String?,var KL:String?,
                        var DJ:String?,var lastRealTask:BigDecimal?,
                        var lastsgTask:BigDecimal?,var lastsjTask:BigDecimal?,
                        var lastzcbTask:BigDecimal?,var lastPresetTask:BigDecimal?,
                        var lastRate:String?,var lastKL:String?,
                        var lastDJ:String?,
                        )
