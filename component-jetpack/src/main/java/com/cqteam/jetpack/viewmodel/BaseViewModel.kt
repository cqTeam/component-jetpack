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
abstract class BaseViewModel: ViewModel() {

    val errorLiveData by lazy { MutableLiveData<Exception>() }

    /**
     *  此方法支持处理被 suspend 标记了的函数，并且统一获取和处理异常
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