package com.cqteam.jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.Exception

/**
 * Author： 洪亮
 * Time： 2021/8/5 - 3:16 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
abstract class JpViewModel: ViewModel() {

    val errorLiveData by lazy { MutableLiveData<Exception>() }

    /**
     *  viewModelScope.launch {} ，在主线程上开启一个协程，此协程主要用于更新UI
     *
     *  block() 为 suspend 函数
     */
    fun launchUI (block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            try {
                block()
            }catch (e: Exception) {
                errorLiveData.postValue(e)
            }
        }
    }
}