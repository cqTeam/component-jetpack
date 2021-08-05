package com.cqteam.jetpackdemo

import android.content.Context
import android.content.Intent
import android.view.View
import com.cqteam.jetpack.activity.JpActivity
import com.cqteam.jetpackdemo.databinding.ActivitySecondBinding

class SecondActivity : JpActivity() {

    companion object {
        fun start(context: Context){
            val intent = Intent(context,SecondActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var mViewBinding: ActivitySecondBinding

    override fun setContentViewBeforeOperation() {

    }

    override fun setBindingView(): View {
        mViewBinding = ActivitySecondBinding.inflate(layoutInflater)
        return mViewBinding.root
    }

    override fun initView() {
    }

    override fun initData() {
    }

}