package me.dragonz.module

import me.dragonz.event.EventMgr
import me.dragonz.event.SysEventSets
import me.dragonz.log.Logger
import me.dragonz.module.exception.BaseModuleException
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

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

    private fun register(moduleClass: KClass<BaseModule>?, callback: IModuleCallback){
        try {
            val module = moduleClass?.primaryConstructor?.call(moduleClass.simpleName, callback)
            if (module != null){
                mMapModules.put(module.mModuleName, module)
                module.init()
            }else{
                Logger.i("module to register is null ")
            }
        }catch (e: Exception){
            Logger.e(e.cause, e.message)
        }
    }

    private fun unregister(moduleClass: KClass<BaseModule>?){
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
        val moduleList: List< KClass<BaseModule>? >  = ModuleConfig.mModuleList
        for ( moduleClass in moduleList){
            register(moduleClass, this)
        }
    }

    fun unloadModules(){
        val moduleList: List< KClass<BaseModule>? >  = ModuleConfig.mModuleList.reversed()
        for ( moduleClass in moduleList){
            unregister(moduleClass)
        }
    }

    private fun getModule(className: Class<BaseModule>): BaseModule?{
        return mMapModules[className.simpleName]
    }

    override fun onInit(moduleName: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mInitedModuleCount ++
        if (mInitedModuleCount == ModuleConfig.moduleSize()){
            Logger.i("all modules init completed")
            EventMgr.post(SysEventSets.MODULES_LOADED())
        }
    }

    override fun onUninit(moduleName: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mInitedModuleCount --
        if (mInitedModuleCount == ModuleConfig.moduleSize()
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