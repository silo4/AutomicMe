package me.dragonz.module

import kotlin.reflect.KClass

/**
 * 类名称: ModuleConfig
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/29
 * 修改备注:
 * @version: 1.0.0
 */
object ModuleConfig{
    val mModuleList: List< KClass<BaseModule>? >
            = listOf(InitPreBootModule::class as? KClass<BaseModule>,
                     BootModule::class as? KClass<BaseModule>,
                     InitAfterBootModule::class as? KClass<BaseModule>)

    fun moduleSize(): Int = mModuleList.size
}