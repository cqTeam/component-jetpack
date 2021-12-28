package com.cqteam.jetpack.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Name：
 *
 * Author：洪亮
 *
 * Email：1605344156@qq.com
 *
 * CreateDate：2021/12/28 3:48 下午
 *
 * UpdateDate：2021/12/28 3:48 下午
 *
 * Version：1.0
 *
 * Description： 目前就这样
 *
 **/
abstract class CqBaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetContentViewBeforeOperation(savedInstanceState)
        onSetContentView(savedInstanceState)
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    /**
     *  在 onSetContentView() 之前调用，可用于处理 。。。
     */
    protected abstract fun onSetContentViewBeforeOperation(savedInstanceState: Bundle?)

    /**
     *  设置布局
     */
    protected abstract fun onSetContentView(savedInstanceState: Bundle?)

    /**
     *  此方法中初始化控件，不进行任何数据操作，例如设置监听器
     */
    protected abstract fun initView(savedInstanceState: Bundle?)

    /**
     *  此方法中进行数据操作，例如给控件赋值，Adapter设置数据，ViewModel中获取数据等
     */
    protected abstract fun initData(savedInstanceState: Bundle?)

}