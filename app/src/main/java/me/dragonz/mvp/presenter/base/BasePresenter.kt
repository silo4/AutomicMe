package me.dragonz.mvp.presenter.base

import me.dragonz.mvp.view.base.IBaseView

/**
 * 类名称: BasePresenter
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/9/5
 * 修改备注:
 * @version: 1.0.0
 */
abstract class BasePresenter{

//    private fun create() = onCreatePresenter()

    fun destroy() = onDestroyPresenter()

//    abstract fun onCreatePresenter()
    abstract fun initPresenter()
    abstract fun onDestroyPresenter()
}