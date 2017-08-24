package me.dragonz.automicme

import me.dragonz.automicme.base.BaseApplication
import me.dragonz.event.EventMgr
import me.dragonz.event.SysEventSets
import me.dragonz.log.Logger
import me.dragonz.module.ModuleManager
import me.dragonz.utility.ActivityStackMgr
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 类名称: TheApp
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

class TheApp : BaseApplication(){

    private val mModuleMgr: ModuleManager = ModuleManager()

    companion object{
        lateinit var instance: TheApp
        private set  //This is used so that a value can’t be assigned from an external class.
    }

    override fun onCreate() {
        super.onCreate()
        Logger.i("app on create========================")
        instance = this
        EventMgr.register(this)
        mModuleMgr.loadModules()
    }

    override fun onTerminate() {
        super.onTerminate()
        Logger.i("app on terminate==========================")
        mModuleMgr.unloadModules()
        EventMgr.unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    fun onModuleLoadingErrorEvent(event: SysEventSets.MODULE_LOADING_ERROR){
        Logger.e("module loading failed [${event.obj}]")
        ActivityStackMgr.instance.exit()
    }
}