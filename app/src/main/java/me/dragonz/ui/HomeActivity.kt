package me.dragonz.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import me.dragonz.automicme.R
import me.dragonz.ui.base.BaseActivity
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt

/**
 * 类名称: HomeActivity
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/9/5
 * 修改备注:
 * @version: 1.0.0
 */

class HomeActivity: BaseActivity(){

    companion object {
        fun launchFrom(context: Context){
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}