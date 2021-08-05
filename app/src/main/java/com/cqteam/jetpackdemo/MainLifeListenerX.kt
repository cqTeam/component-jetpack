package com.cqteam.jetpackdemo

import android.util.Log
import androidx.lifecycle.*

/**
 * Author： 洪亮
 * Time： 2021/8/4 - 3:27 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class MainLifeListenerX: LifecycleEventObserver {

    private val logTag = "MainLifeListenerX"

    private fun onEventCreate(){
        Log.e(logTag,"ON_CREATE")
    }

    private fun onEventStart(){
        Log.e(logTag,"ON_START")

    }

    private fun onEventResume(){
        Log.e(logTag,"ON_RESUME")

    }

    private fun onEventPause(){
        Log.e(logTag,"ON_PAUSE")

    }

    private fun onEventStop(){
        Log.e(logTag,"ON_STOP")

    }

    private fun onEventDestroy(){
        Log.e(logTag,"ON_DESTROY")
    }

    private fun onEventAny(){
        Log.e(logTag,"ON_ANY")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.e(logTag,"${event.name}，${source.lifecycle.currentState.name}")
        when(event){
            Lifecycle.Event.ON_CREATE -> onEventCreate()
            Lifecycle.Event.ON_START -> onEventStart()
            Lifecycle.Event.ON_RESUME -> onEventResume()
            Lifecycle.Event.ON_PAUSE -> onEventPause()
            Lifecycle.Event.ON_STOP -> onEventStop()
            Lifecycle.Event.ON_DESTROY -> onEventDestroy()
            Lifecycle.Event.ON_ANY -> onEventAny()
        }
    }
}