package com.cqteam.jetpackdemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Author： 洪亮
 * Time： 2021/8/4 - 3:27 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class MainLifeListener: LifecycleObserver {

    private val logTag = "MainLifeListener"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onEventCreate(){
        Log.e(logTag,"ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onEventStart(){
        Log.e(logTag,"ON_START")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onEventResume(){
        Log.e(logTag,"ON_RESUME")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onEventPause(){
        Log.e(logTag,"ON_PAUSE")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onEventStop(){
        Log.e(logTag,"ON_STOP")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onEventDestroy(){
        Log.e(logTag,"ON_DESTROY")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    private fun onEventAny(){
        Log.e(logTag,"ON_ANY")
    }
}