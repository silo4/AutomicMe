package me.dragonz.module

import me.dragonz.log.Logger

/**
 * 类名称: InitPreBootModule
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

class InitPreBootModule(moduleName: String, callback: IModuleCallback?) : BaseModule(moduleName, callback){

    override fun init() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        Logger.i("[${this.mModuleName}] inited")
        onInit()
    }

    override fun uninit() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("[${this.mModuleName}] uninited")
        onUninit()
    }

}
