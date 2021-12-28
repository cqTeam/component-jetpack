package com.cqteam.jetpack.activity

import android.os.Bundle
import com.cqteam.jetpack.common.BaseException
import com.cqteam.jetpack.viewmodel.BaseViewModel

/**
 * Name：
 *
 * Author：洪亮
 *
 * Email：1605344156@qq.com
 *
 * CreateDate：2021/12/28 4:01 下午
 *
 * UpdateDate：2021/12/28 4:01 下午
 *
 * Version：1.0
 *
 * Description：Lifecycles 、 ViewModel 封装
 *
 **/
abstract class CqMvvmActivity<out VM: BaseViewModel>: CqBaseActivity() {

    protected abstract val viewModel: VM

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.showLoading.observe(this,{
            showLoading(it)
        })

        viewModel.hideLoading.observe(this,{
            hideLoading(it)
        })

        viewModel.error.observe(this,{
            handleError(it)
        })
        initViewX(savedInstanceState)
    }

    /**
     *  展示数据加载动画
     */
    protected abstract fun showLoading(any: Any)

    /**
     *  隐藏数据加载动画
     */
    protected abstract fun hideLoading(it: Any?)

    /**
     *  View层处异常信息
     */
    protected abstract fun handleError(it: BaseException?)

    /**
     *  初始化布局
     */
    protected abstract fun initViewX(savedInstanceState: Bundle?)
}