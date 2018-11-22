package com.annarm.douban.moive.view

/**
 * description:
 * @author wangzhijun
 * date 2018/11/21 16:41
 * @version V1.0
 */

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

open abstract class LVBase @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    var valueAnimator: ValueAnimator? = null

    init {
        initPaint()
    }

    fun startAnim() {
        stopAnim()
        startViewAnim(0f, 1f, 500)
    }

    fun startAnim(time: Int) {
        stopAnim()
        startViewAnim(0f, 1f, time.toLong())
    }


    fun stopAnim() {
        if (valueAnimator != null) {
            clearAnimation()

            valueAnimator!!.repeatCount = 0
            valueAnimator!!.cancel()
            valueAnimator!!.end()
            if (OnStopAnim() == 0) {
                valueAnimator!!.repeatCount = 0
                valueAnimator!!.cancel()
                valueAnimator!!.end()
            }

        }
    }

    private fun startViewAnim(startF: Float, endF: Float, time: Long): ValueAnimator {
        valueAnimator = ValueAnimator.ofFloat(startF, endF)
        valueAnimator!!.duration = time
        valueAnimator!!.interpolator = LinearInterpolator()


        valueAnimator!!.repeatCount = SetAnimRepeatCount()



        if (ValueAnimator.RESTART == SetAnimRepeatMode()) {
            valueAnimator!!.repeatMode = ValueAnimator.RESTART

        } else if (ValueAnimator.REVERSE == SetAnimRepeatMode()) {
            valueAnimator!!.repeatMode = ValueAnimator.REVERSE

        }

        valueAnimator!!.addUpdateListener { valueAnimator -> OnAnimationUpdate(valueAnimator) }
        valueAnimator!!.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)

            }

            override fun onAnimationStart(animation: Animator) {

                super.onAnimationStart(animation)
            }

            override fun onAnimationRepeat(animation: Animator) {
                super.onAnimationRepeat(animation)
                OnAnimationRepeat(animation)
            }
        })
        if (!valueAnimator!!.isRunning) {
            AinmIsRunning()
            valueAnimator!!.start()

        }

        return valueAnimator!!
    }


    protected abstract fun initPaint()

    protected abstract fun OnAnimationUpdate(valueAnimator: ValueAnimator)

    protected abstract fun OnAnimationRepeat(animation: Animator)

    protected abstract fun OnStopAnim(): Int

    protected abstract fun SetAnimRepeatMode(): Int

    protected abstract fun SetAnimRepeatCount(): Int

    protected abstract fun AinmIsRunning()


    fun dip2px(dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun getFontlength(paint: Paint, str: String): Float {
        val rect = Rect()
        paint.getTextBounds(str, 0, str.length, rect)
        return rect.width().toFloat()
    }

    fun getFontHeight(paint: Paint, str: String): Float {
        val rect = Rect()
        paint.getTextBounds(str, 0, str.length, rect)
        return rect.height().toFloat()

    }

    fun getFontHeight(paint: Paint): Float {
        val fm = paint.fontMetrics
        return fm.descent - fm.ascent
    }
}
