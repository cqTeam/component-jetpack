package com.cqteam.jetpackdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cqteam.jetpack.activity.JpMVVMActivity
import com.cqteam.jetpackdemo.databinding.ActivityMainBinding

class MainActivity : JpMVVMActivity<MainViewModel>() {

    private lateinit var mViewBinding: ActivityMainBinding
    private val logTag = "MainActivity"

    override fun setContentViewBeforeOperation() {
        // 添加生命周期观察者
        lifecycle.addObserver(MainLifeListener())
        lifecycle.addObserver(MainLifeListenerX())
    }

    override fun setBindingView(): View {
        mViewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        return mViewBinding.root
    }

    override fun viewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initView() {
        mViewBinding.tvTitle.let {
            it.text = "测试"
            it.setOnClickListener {
                SecondActivity.start(this)
            }
        }

        mViewBinding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        }
    }

    override fun initData() {
        mViewModel.test()
    }

    override fun onStart() {
        super.onStart()
        Log.e(logTag,"onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.e(logTag,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.e(logTag,"onPause")

    }

    override fun onRestart() {
        super.onRestart()
        Log.e(logTag,"onRestart")

    }

    override fun onStop() {
        super.onStop()
        Log.e(logTag,"onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(logTag,"onDestroy")
    }

    override fun handleUI() {
        super.handleUI()
        Log.e(logTag,"handleUI")
    }
}