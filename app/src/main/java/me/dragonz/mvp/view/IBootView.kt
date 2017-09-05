package me.dragonz.mvp.view

import me.dragonz.mvp.view.base.IBaseView

/**
 * 类名称: IBootView
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/9/5
 * 修改备注:
 * @version: 1.0.0
 */
interface IBootView: IBaseView {
    fun bootWithImageAndCountDown() //显示单张图片，并显示倒计时
    fun bootWithVideo() //显示视频
    fun bootWithImagePager() //显示翻页
    fun updateCountdown(countdown: String) //倒计时

    fun finishBoot() //结束启动页
}