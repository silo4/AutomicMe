package me.dragonz.module

import me.dragonz.event.EventMgr
import me.dragonz.event.SysEventSets
import me.dragonz.log.Logger
import me.dragonz.module.exception.BaseModuleException
import java.lang.reflect.Constructor

/**
 * 类名称: ModuleManager
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */
class ModuleManager: IModuleCallback{

    private var mMapModules: HashMap<String, BaseModule> = HashMap()
    private var mInitedModuleCount = 0 //初始化过的模块数，当这个值等于mMapModule.size时，说明所有模块初始化完成

    private fun register(moduleClass: Class<BaseModule>, callback: IModuleCallback){
        try {
            val constructor: Constructor<BaseModule> = moduleClass.getConstructor(moduleClass::class.java, callback::class.java)
            val module = constructor.newInstance(moduleClass.simpleName, callback)
            if (module != null){
                mMapModules.put(module.mModuleName, module)
                module.init()
            }
        }catch (e: Exception){
            Logger.e(e.cause, e.message)
        }
    }

    private fun unregister(moduleClass: Class<BaseModule>?){
        if (moduleClass == null){
            return
        }
        val moduleName = moduleClass.simpleName
        val module: BaseModule? = mMapModules[moduleName]
        if (module == null){
            Logger.e("module to unregister is null")
            return
        }
        module.uninit()
        mMapModules.remove(moduleName)
    }

    fun loadModules(){
//        var bm: Class<BaseModule> = InitPreBootModule::class.java
//        register(bm, this)
    }

    fun unloadModules(){
//        unregister(InitAfterBootModule::class.java)
    }

    private fun getModule(className: Class<BaseModule>): BaseModule?{
        return mMapModules[className.simpleName]
    }

    override fun onInit(moduleName: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mInitedModuleCount ++
        if (mInitedModuleCount == mMapModules.size){
            Logger.i("all modules init completed")
            EventMgr.post(SysEventSets.MODULES_LOADED())
        }
    }

    override fun onUninit(moduleName: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mInitedModuleCount --
        if (mInitedModuleCount == mMapModules.size
                && mInitedModuleCount == 0){
            Logger.i("all modules uninit completed")
            EventMgr.post(SysEventSets.MODULES_UNLOADED())
        }
    }

    override fun onException(moduleName: String, exception: BaseModuleException) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.e("init module[${moduleName}] error[${exception.message}]")
        EventMgr.post(SysEventSets.MODULE_LOADING_ERROR(exception.message))
    }

}