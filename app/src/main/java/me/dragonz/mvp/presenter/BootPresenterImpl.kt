package me.dragonz.mvp.presenter

import android.os.CountDownTimer
import me.dragonz.bean.EnmBootType
import me.dragonz.log.Logger
import me.dragonz.mvp.presenter.base.BasePresenter
import me.dragonz.mvp.view.IBootView

/**
 * 类名称: BootPresenterImpl
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/9/5
 * 修改备注:
 * @version: 1.0.0
 */
class BootPresenterImpl: BasePresenter, IBootPresenter{
    private val COUNTDOWN_TIME: Long = 4000 //in million seconds
    private val PERIOD_TIME: Long = 1000
    private val DELAY_TIME: Long = 1000

    private var mBootView: IBootView? = null
    private val mBootType: EnmBootType = EnmBootType.PICTURE
//    private val mCountdownTimer = Timer("boot countdown", true)
    private val mCountdownTimer = object: CountDownTimer(COUNTDOWN_TIME, PERIOD_TIME){
        override fun onFinish() {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            mBootView?.finishBoot()
        }

        override fun onTick(millisUntilFinished: Long) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val seconds = (millisUntilFinished / 1000 + 1).toInt()
            mBootView?.updateCountdown(seconds.toString())
        }

    }

    constructor(view: IBootView){
        mBootView = view
        initPresenter()
    }

    override fun initPresenter() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        decideToShow(mBootType)
    }

    override fun onDestroyPresenter() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("on destroy boot presenter")
        stopTimer()
    }

    override fun decideToShow(type: EnmBootType) = when(type){
        EnmBootType.PICTURE -> {
            mBootView?.bootWithImageAndCountDown()
            startTimer()
        }
        EnmBootType.PAGER_PICTURE -> mBootView?.bootWithImagePager()
        EnmBootType.VIDEO -> mBootView?.bootWithVideo()

        else -> {
            Logger.w("unsupported boot type $type")
        }
    }

    private fun startTimer(){
        mCountdownTimer.start()
    }

    private fun stopTimer(){
        mCountdownTimer.cancel()
    }

}

