package me.dragonz.automicme.base

import android.app.Application

/**
 * 类名称: BaseApplication
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

open class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
