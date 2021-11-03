package com.cqteam.jetpackdemo

import android.util.Log
import com.cqteam.jetpack.viewmodel.JpViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Author： 洪亮
 * Time： 2021/8/5 - 2:19 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class MainViewModel: JpViewModel() {

    private val logTag = "MainViewModel"

    fun test() {
        Log.e(logTag,"test === ${Thread.currentThread().toString()}")
        launchUI {
            Log.e(logTag,"launchUI === ${Thread.currentThread().toString()}")
            ioTread()
            defaultTread()
            mainTread()
        }
    }

    /**
     *  在IO线程上开启了一个协程，并获取该线程的信息
     */
    private suspend fun ioTread(){
        withContext(Dispatchers.IO){
            Log.e(logTag,"ioTread === ${Thread.currentThread().toString()}")
            unconfinedTread()
        }
    }
    /**
     *  在IO线程上开启了一个协程，并获取该线程的信息
     */
    private suspend fun defaultTread(){
        withContext(Dispatchers.Default){
            Log.e(logTag,"defaultTread === ${Thread.currentThread().toString()}")
        }
    }
    /**
     *  在IO线程上开启了一个协程，并获取该线程的信息
     */
    private suspend fun mainTread(){
        withContext(Dispatchers.Main){
            Log.e(logTag,"mainTread === ${Thread.currentThread().toString()}")
        }
    }

    /**
     *  在IO线程上开启了一个协程，并获取该线程的信息
     */
    private suspend fun unconfinedTread(){
        withContext(Dispatchers.Unconfined){
            Log.e(logTag,"unconfinedTread === ${Thread.currentThread().toString()}")
        }
    }
}