package me.dragonz.module

/**
 * 类名称: InitPreBootModule
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

class InitPreBootModule : BaseModule{

    constructor(moduleName: String): super(moduleName)

    constructor(moduleName: String, callback: IModuleCallback): super(moduleName, callback)

    override fun init() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        onInit()
    }

    override fun uninit() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        onUninit()
    }


}
