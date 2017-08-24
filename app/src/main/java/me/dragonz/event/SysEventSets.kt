package me.dragonz.event

import me.dragonz.event.base.BaseEvent
import me.dragonz.event.base.EventType

/**
 * 类名称: SysEventSets
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */
class SysEventSets{
    class MODULES_LOADED: BaseEvent(EventType.SYS_MODULE_LOADED)
    class MODULES_UNLOADED: BaseEvent(EventType.SYS_MODULE_UNLOADED)
    class MODULE_LOADING_ERROR(error: String?): BaseEvent(EventType.SYS_MODULE_LOADING_ERROR, error)
}