package me.dragonz.module.exception

/**
 * 类名称: BaseModuleException
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/24
 * 修改备注:
 * @version: 1.0.0
 */

open class BaseModuleException: Exception{

    constructor(message: String): super(message)

    constructor(throwable: Throwable): super(throwable)

    constructor(message: String, throwable: Throwable): super(message, throwable)
}