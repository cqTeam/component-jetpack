package com.cqteam.jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cqteam.jetpack.common.BaseException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.Exception

/**
 * Author： 洪亮
 * Time： 2021/8/5 - 3:16 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：基础 ViewModel
 */
abstract class BaseViewModel: ViewModel() {

    val error by lazy { MutableLiveData<BaseException>() }

    val showLoading = MutableLiveData<Any>()

    val hideLoading = MutableLiveData<Any>()

    /**
     *  viewModelScope.launch {} ，在主线程上开启一个协程，此协程主要用于更新UI
     *
     *  block() 为 suspend 函数
     */
    protected fun launchUI (block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            try {
                block()
            }catch (e: Exception) {
                handleError(e)
            }
        }
    }

    /**
     *  Model层处理异常
     *  可重写此方法实现自己的异常处理
     */
    protected open fun handleError(e: Exception) {
        error.postValue(BaseException("",e))
    }
}