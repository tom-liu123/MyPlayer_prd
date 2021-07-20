package com.example.myplayer.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity:BaseActivity(), ViewPropertyAnimatorListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        /**
         * 对动画做缩小的处理
         * 从1.5倍缩小到1.0倍，持续时间2000ms
         */
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).setDuration(2000)
    }

    /**
     * 动画开始
     */
    override fun onAnimationStart(view: View?) {
    }
    /**
     * 动画结束
     */
    override fun onAnimationEnd(view: View?) {
        //进入到主界面
        startActivityAndFinish<MainActivity>()
    }

    /**
     * 动画取消
     */
    override fun onAnimationCancel(view: View?) {
    }
}