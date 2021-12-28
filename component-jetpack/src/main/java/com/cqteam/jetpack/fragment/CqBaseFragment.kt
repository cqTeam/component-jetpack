package com.cqteam.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Name：
 *
 * Author：洪亮
 *
 * Email：1605344156@qq.com
 *
 * CreateDate：2021/12/28 4:35 下午
 *
 * UpdateDate：2021/12/28 4:35 下午
 *
 * Version：1.0
 *
 * Description：
 *
 **/
abstract class CqBaseFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onCreateViewBeforeOperation()
        return if (createView(inflater, container, savedInstanceState) == null) super.onCreateView(inflater, container, savedInstanceState)
        else createView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view,savedInstanceState)
        initData(view,savedInstanceState)
    }

    /**
     *  在 setContentView() 之前调用，可用于处理 。。。
     */
    protected abstract fun onCreateViewBeforeOperation()

    /**
     *  创建布局
     */
    protected abstract fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    /**
     *  初始化控件
     */
    abstract fun initView(view: View, savedInstanceState: Bundle?)

    /**
     *  初始化数据
     */
    abstract fun initData(view: View, savedInstanceState: Bundle?)


}