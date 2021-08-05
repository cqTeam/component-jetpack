package com.cqteam.jetpackdemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cqteam.jetpack.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Author： 洪亮
 * Time： 2021/8/5 - 2:19 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class MainViewModel: BaseViewModel() {

    private val logTag = "MainViewModel"

    fun test() {
        Log.e(logTag,"测试数据")
      launchUI {
          val list = arrayListOf<String>()
          list.add("1")
          list.add("2")
          list.add("3")
          Log.e(logTag,list[-1])
      }
    }
}