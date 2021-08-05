package com.cqteam.jetpack.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cqteam.jetpack.viewmodel.BaseViewModel

/**
 * Author：      小小亮
 * CreateTime：  2020/10/24 11:38 AM
 * Email：       281332545@qq.com
 * Introduce：：
 **/
abstract class JpMVVMActivity<VM: BaseViewModel>: JpActivity() {
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