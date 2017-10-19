package me.dragonz.log

import android.util.Log
import me.dragonz.automicme.BuildConfig

/**
 * 类名称: Logger
 * 类描述:
 * 创建人: zhonglz
 * 修改人: zhonglz
 * 修改时间: 2017/8/23
 * 修改备注:
 * @version: 1.0.0
 */

class Logger {
    companion object {
        private val mIsDebug = BuildConfig.DEBUG
        private val mPrefixTag: String = "<Kotlin>"
        private val mSuffixTag: String = "--->"
        private var mClassName: String = ""
        private var mMethodName: String = ""
        private var mLineNumber: Int = 0

        private val mLogV: Boolean = mIsDebug
        private val mLogD: Boolean = mIsDebug
        private val mLogI: Boolean = mIsDebug
        private val mLogW: Boolean = mIsDebug
        private val mLogE: Boolean = mIsDebug

        fun v(content: String){
            if (!mLogV) {
                return
            }
            buildStackTraceInfo(Throwable().stackTrace)
            v(mClassName, content, false)
        }

        fun v(tag: String, content: String, shouldBuildStackTraceInfo: Boolean = true) {
            if (!mLogV){
                return
            }
            if (shouldBuildStackTraceInfo){
                buildStackTraceInfo(Throwable().stackTrace)
            }
            Log.v(buildTag(tag), buildMessage(content))
        }

        fun d(content: String){
            if (!mLogD) {
                return
            }
            buildStackTraceInfo(Throwable().stackTrace)
            d(mClassName, content, false)
        }

        fun d(tag: String, content: String, shouldBuildStackTraceInfo: Boolean = true) {
            if (!mLogD){
                return
            }
            if (shouldBuildStackTraceInfo){
                buildStackTraceInfo(Throwable().stackTrace)
            }
            Log.d(buildTag(tag), buildMessage(content))
        }

        fun i(content: String){
            if (!mLogI) {
                return
            }
            buildStackTraceInfo(Throwable().stackTrace)
            i(mClassName, content, false)
        }

        fun i(tag: String, content: String, shouldBuildStackTraceInfo: Boolean = true) {
            if (!mLogI){
                return
            }
            if (shouldBuildStackTraceInfo){
                buildStackTraceInfo(Throwable().stackTrace)
            }
            Log.i(buildTag(tag), buildMessage(content))
        }

        fun w(content: String){
            if (!mLogW) {
                return
            }
            buildStackTraceInfo(Throwable().stackTrace)
            w(mClassName, content, false)
        }

        fun w(tag: String, content: String, shouldBuildStackTraceInfo: Boolean = true) {
            if (!mLogW){
                return
            }
            if (shouldBuildStackTraceInfo){
                buildStackTraceInfo(Throwable().stackTrace)
            }
            Log.w(buildTag(tag), buildMessage(content))
        }

        fun e(content: String){
            if (!mLogE) {
                return
            }
            buildStackTraceInfo(Throwable().stackTrace)
            e(mClassName, content, false)
        }

        fun e(throwable: Throwable?, content: String?){
            if (!mLogE){
                return
            }
            buildStackTraceInfo(Throwable().stackTrace)
            e(mClassName, content, throwable, false)
        }

        fun e(tag: String, content: String, shouldBuildStackTraceInfo: Boolean = true) {
            if (!mLogE){
                return
            }
            if (shouldBuildStackTraceInfo){
                buildStackTraceInfo(Throwable().stackTrace)
            }
            Log.e(buildTag(tag), buildMessage(content))
        }

        fun e(tag: String, content: String?, throwable: Throwable?, shouldBuildStackTraceInfo: Boolean = true) {
            if (!mLogE){
                return
            }
            if (shouldBuildStackTraceInfo){
                buildStackTraceInfo(Throwable().stackTrace)
            }
            Log.e(buildTag(tag), buildMessage(content), throwable)
        }

        private fun buildTag(tag: String): String {
            //todo sth
            return mPrefixTag + tag + mSuffixTag
        }

        private fun buildMessage(content: String?): String{
            //todo sth
            val msg = "[$mMethodName:$mLineNumber]$content"
            return msg
        }

        private fun buildStackTraceInfo(sElements: Array<StackTraceElement>) {
            mClassName = sElements[1].fileName
            mMethodName = sElements[1].methodName
            mLineNumber = sElements[1].lineNumber
        }
    }


}