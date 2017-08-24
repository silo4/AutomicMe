package me.dragonz.module

import me.dragonz.module.exception.BaseModuleException
import me.dragonz.module.exception.EmptyModuleNameException

/**
 * 类名称: BaseModule
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

abstract class BaseModule{
    internal var mModuleName: String = ""
    internal var mCallback: IModuleCallback? = null

    constructor(moduleName: String){
        if (moduleName.isEmpty()){
            throw EmptyModuleNameException("module name is empty")
        }
        mModuleName = moduleName
    }

    constructor(moduleName: String, callback: IModuleCallback){
        if (moduleName.isEmpty()){
            throw EmptyModuleNameException("module name is empty")
        }
        mModuleName = moduleName
        mCallback = callback
    }

    abstract fun init()
    abstract fun uninit()

    fun onInit(){
        mCallback?.onInit(mModuleName)
    }

    fun onUninit(){
        mCallback?.onUninit(mModuleName)
    }

    fun onException(moduleName: String, exception: BaseModuleException){
        mCallback?.onException(moduleName, exception)
    }
}