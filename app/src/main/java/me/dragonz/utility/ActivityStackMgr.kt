package me.dragonz.utility

import android.app.Activity
import me.dragonz.log.Logger
import java.lang.ref.SoftReference

/**
 * 类名称: ActivityStackMgr
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/23
 * 修改备注:

 * @version: 1.0.0
 */

class ActivityStackMgr private constructor(){

    init {
        Logger.v("init ActivityStackMgr in singleton pattern")
    }

    private object Holder{
        val INSTANCE = ActivityStackMgr()
    }

    companion object{
        val instance: ActivityStackMgr by lazy { Holder.INSTANCE }
    }

    private var mMapTask: HashMap<String, SoftReference<Activity>> = HashMap()

    fun putActivity(act: Activity){
        mMapTask.put(act.toString(), SoftReference<Activity>(act))
    }

    fun removeActivity(act: Activity){
        mMapTask.remove(act.toString())
    }

    fun exit(){
        Logger.i("===========>>exit this application<<=============")
        for ((_, softRefAct) in mMapTask){
            val act: Activity? = softRefAct.get()
            act?.finish()
        }

        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }


}
