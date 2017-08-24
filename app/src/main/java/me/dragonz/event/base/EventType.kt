package me.dragonz.event.base

/**
 * 类名称: EventType
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

enum class EventType(name: String){
    //system
    SYS_MODULE_LOADED("sys_module_loaded"), //所有module 加载完成
    SYS_MODULE_UNLOADED("sys_module_unloaded"),//所有module 卸载完成
    SYS_MODULE_LOADING_ERROR("sys_module_loading_error"),//module 加载出错

}