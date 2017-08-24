package me.dragonz.event.base


/**
 * 类名称: BaseEvent
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */
open class BaseEvent{
    var eventType: EventType? = null
    var src: String? = null
    var dst: String? = null
    var obj: Any? = null
    var arg: Long? = null

    constructor(eventType: EventType?) {
        this.eventType = eventType
    }

    constructor(eventType: EventType?, obj: Any?) {
        this.eventType = eventType
        this.obj = obj
    }

    constructor(eventType: EventType?, obj: Any?, arg: Long?) {
        this.eventType = eventType
        this.obj = obj
        this.arg = arg
    }


}
