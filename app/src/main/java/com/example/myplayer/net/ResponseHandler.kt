package com.example.myplayer.net

/**
 * 请求的回调
 */
interface ResponseHandler<RESPONSE> {
    fun onError(type:Int,msg:String?)
    fun onSucess(type:Int,result:RESPONSE)
}