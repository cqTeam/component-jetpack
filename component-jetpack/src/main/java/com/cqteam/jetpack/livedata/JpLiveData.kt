package com.cqteam.jetpack.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Author： 洪亮
 * Time： 2021/7/15 - 11:47 AM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
@Deprecated("太过繁重，已经弃用")
abstract class JpLiveData<T>: LiveData<T>() {
    /**
     *  业务级错误
     */
    var mBusinessFailCallback: ((Int,String?) -> Unit?)? = null

    /**
     *  业务级成功
     */
    var mBusinessSuccessCallback: ((Int,String?) -> Unit?)? = null


    /**
     *  关闭加载动画
     */
    var mFinishCallback:(() -> Unit)? = null

    /**
     *  @param owner
     *  @param observer 真正承载数据
     *  @param businessFailCallback 业务级错误，返回了 errorCode，errorMsg
     *  @param finishCallback 无论业务级成功还是失败，都会被调用
     *  @param businessSuccessCallback 业务级成功，返回 code，successMsg
     */
    fun observe(owner: LifecycleOwner, observer: Observer<in T>,
                businessSuccessCallback: ((Int,String?) -> Unit?)? = null,
                businessFailCallback: ((Int,String?) -> Unit?)? = null,
                finishCallback: (() -> Unit)? = null) {
        super.observe(owner,observer)
        mBusinessSuccessCallback = businessSuccessCallback
        mFinishCallback = finishCallback
        mBusinessFailCallback = businessFailCallback
    }


    public override fun setValue(value: T) {
        super.setValue(value)
    }

    public override fun postValue(value: T) {
        super.postValue(value)
    }
}