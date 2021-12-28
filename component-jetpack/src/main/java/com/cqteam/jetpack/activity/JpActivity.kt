package com.cqteam.jetpack.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Author： 洪亮
 * Time： 2020/10/22 - 9:56 AM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
@Deprecated("使用 CqBaseActivity")
abstract class JpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewBeforeOperation()
        if (setLayoutId() == -1) {
            setContentView(setBindingView())
        } else {
            setContentView(setLayoutId())
        }
        initView()
        initData()
    }

    /**
     *  在 setContentView() 之前调用，可用于处理 。。。
     */
    protected abstract fun setContentViewBeforeOperation()

    /**
     *  重写此方法，viewBinding 将无效
     *  @return 布局Id
     */
    open fun setLayoutId(): Int = -1

    /**
     *  设置 ViewBinding
     *  @return view；如果重写了{@link setLayoutId}，就返回null
     */
    protected abstract fun setBindingView(): View?

    /**
     *  此方法中初始化控件，不进行任何数据操作，例如设置监听器
     */
    protected abstract fun initView()

    /**
     *  此方法中进行数据操作，例如给控件赋值，Adapter设置数据，ViewModel中获取数据等
     */
    protected abstract fun initData()

}