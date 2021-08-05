package com.cqteam.jetpack.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cqteam.jetpack.viewmodel.JpViewModel

/**
 * Author： 洪亮
 * Time： 2020/10/22 - 2:32 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
abstract class JpMVVMDialogFragment<VM: JpViewModel>: JpDialogFragment() {
    val mViewModel by lazy {
        ViewModelProvider(this).get(viewModelClass())
    }
    protected abstract fun viewModelClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleError()
    }

    /**
     *  全局处理 BaseViewModel 出现的问题
     */
    private fun handleError(){
        mViewModel.errorLiveData.observe(this,{ exception ->
            exception.printStackTrace()
            handleUI()
        })
    }

    /**
     *  主要用于View层重写此方法，处理界面使用
     */
    open fun handleUI() {

    }
}