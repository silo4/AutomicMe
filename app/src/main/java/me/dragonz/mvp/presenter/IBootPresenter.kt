package me.dragonz.mvp.presenter

import me.dragonz.bean.EnmBootType

/**
 * 类名称: IBootPresenter
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/9/5
 * 修改备注:
 * @version: 1.0.0
 */
interface IBootPresenter{
    fun decideToShow(type: EnmBootType): Unit?
}