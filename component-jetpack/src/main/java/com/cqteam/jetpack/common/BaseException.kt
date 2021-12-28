package com.cqteam.jetpack.common

/**
 * Name：
 *
 * Author：洪亮
 *
 * Email：1605344156@qq.com
 *
 * CreateDate：2021/12/28 3:33 下午
 *
 * UpdateDate：2021/12/28 3:33 下午
 *
 * Version：1.0
 *
 * Description： 基础异常类
 *
 **/
open class BaseException(
    private var msg: String,
    private var exception: Exception? = null,
) {
    fun getMsg(): String {
        return msg
    }

    fun getException(): Exception? {
        return exception
    }
}