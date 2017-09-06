package me.dragonz.ui

import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_boot.*
import me.dragonz.automicme.R
import me.dragonz.log.Logger
import me.dragonz.mvp.presenter.BootPresenterImpl
import me.dragonz.mvp.view.IBootView
import me.dragonz.ui.base.BaseActivity

class BootActivity : BaseActivity(), IBootView {

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.AppTheme_Launcher)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boot)

        initView()
    }

    override fun initView() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("init view")
        mPresenter = BootPresenterImpl(this)
    }

    override fun bootWithImageAndCountDown() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("boot with image and countdown")
        tvContent.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bottom_to_origin))
    }

    override fun bootWithVideo() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("boot with video")
    }

    override fun bootWithImagePager() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("boot with image pager")
    }

    override fun updateCountdown(countdown: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("update countdown $countdown")
    }

    override fun finishBoot() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Logger.i("finish boot")
        HomeActivity.launchFrom(this)
    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }
}
