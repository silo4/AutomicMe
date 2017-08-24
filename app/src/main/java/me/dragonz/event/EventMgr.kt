package me.dragonz.event

import me.dragonz.event.base.BaseEvent
import org.greenrobot.eventbus.EventBus

/**
 * 类名称: EventMgr
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */
class EventMgr{
    companion object{
        private val mEventBus: EventBus = EventBus()

        fun register(subscriber: Any){
            if (!mEventBus.isRegistered(subscriber)){
                mEventBus.register(subscriber)
            }
        }

        fun unregister(subscriber: Any){
            if (mEventBus.isRegistered(subscriber)){
                mEventBus.unregister(subscriber)
            }
        }

        fun post(event: BaseEvent){
            mEventBus.post(event)
        }
    }
}