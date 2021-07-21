package com.example.myplayer.util

import android.os.Handler
import android.os.Looper


object ThreadUtil {
    val handler = Handler(Looper.getMainLooper())
    /**
     * 运行在子线程中
     */
    fun runOnMainThread(runnable: Runnable){
        handler.post(runnable)
    }

}