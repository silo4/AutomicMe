package me.dragonz.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import me.dragonz.utility.ActivityStackMgr

/**
 * 类名称: BaseActivity
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/23
 * 修改备注:

 * @version: 1.0.0
 */

abstract class BaseActivity : AppCompatActivity(){

    private val mShowTitleBar: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityStackMgr.instance.putActivity(this)
    }

    /**
     * 一些公共样式可以这里定制，比如有无标题栏
     */
    override fun setContentView(layoutResID: Int) {
        if (!mShowTitleBar){
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        }
        super.setContentView(layoutResID)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun finish() {
        ActivityStackMgr.instance.removeActivity(this)
        super.finish()
    }


}
