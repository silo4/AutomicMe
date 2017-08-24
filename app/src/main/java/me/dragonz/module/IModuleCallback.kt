package me.dragonz.module

import me.dragonz.module.exception.BaseModuleException

/**
 * 类名称: IModuleCallback
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

interface IModuleCallback{
    fun onInit(moduleName: String)
    fun onUninit(moduleName: String)
    fun onException(moduleName: String, exception: BaseModuleException)
}