package com.cqteam.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment

/**
 * Author： 洪亮
 * Time： 2020/10/22 - 9:56 AM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
abstract class JpDialogFragment: AppCompatDialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (setLayoutId() == -1) {
            setBindingView(inflater,container)
        } else {
            inflater.inflate(setLayoutId(),container,false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    /**
     *  重写此方法，viewBinding 将无效
     *  @return 布局Id
     */
    open fun setLayoutId(): Int = -1

    /**
     *  设置 ViewBinding
     *  @return view；如果重写了{@link setLayoutId}，就返回null
     */
    abstract fun setBindingView(inflater: LayoutInflater, container: ViewGroup?): View?

    /**
     *  此方法中初始化控件，不进行任何数据操作，例如设置监听器
     */
    abstract fun initView()

    /**
     *  此方法中进行数据操作，例如给控件赋值，Adapter设置数据，ViewModel中获取数据等
     */
    abstract fun initData()


}