package com.example.myplayer.net

/**
 * 请求的回调
 */
interface ResponseHandler<RESPONSE> {
    fun onError(msg:String?)
    fun onSucess(result:RESPONSE)
}