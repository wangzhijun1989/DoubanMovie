package com.annarm.douban.moive.view

/**
 * description:
 * @author wangzhijun
 * date 2018/11/21 16:40
 * @version V1.0
 */


import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet


/**
 * Created by lumingmin on 16/6/29.
 */

class LVGhost : LVBase {


    internal var mWidth = 0f
    internal var mHight = 0f
    lateinit var mPaint: Paint
    lateinit var mPaintHand: Paint
    lateinit var mPaintShadow: Paint
    internal var rectFGhost = RectF()
    internal var rectFGhostShadow = RectF()
    internal var mPadding = 0f
    internal var mskirtH = 0
    internal var path = Path()


    internal var wspace = 10f
    internal var hspace = 10f


    //    public void startAnim() {
    //        stopAnim();
    //        startViewAnim(0f, 1f, 2500);
    //    }

    private var mAnimatedValue = 0f


    internal var onAnimationRepeatFlag = 1

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = getMeasuredWidth().toFloat()
        mHight = getMeasuredHeight().toFloat()
        mPadding = 10f
        mskirtH = (mWidth / 40).toInt()
    }

    override fun initPaint() {
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.WHITE
        mPaintHand = Paint()
        mPaintHand.isAntiAlias = true
        mPaintHand.style = Paint.Style.FILL
        mPaintHand.color = Color.argb(220, 0, 0, 0)

        mPaintShadow = Paint()
        mPaintShadow.isAntiAlias = true
        mPaintShadow.style = Paint.Style.FILL
        mPaintShadow.color = Color.argb(60, 0, 0, 0)
    }

    fun setViewColor(color: Int) {
        mPaint.color = color
        postInvalidate()
    }

    fun setHandColor(color: Int) {
        mPaintHand.color = color
        postInvalidate()
    }


    private fun drawShadow(canvas: Canvas) {
        canvas.drawArc(rectFGhostShadow, 0f, 360f, false, mPaintShadow)

    }


    private fun drawHead(canvas: Canvas) {
        canvas.drawCircle(
            rectFGhost.left + rectFGhost.width() / 2,
            rectFGhost.width() / 2 + rectFGhost.top,
            rectFGhost.width() / 2 - 15,
            mPaint
        )
    }

    private fun drawHand(canvas: Canvas) {

        canvas.drawCircle(
            rectFGhost.left + rectFGhost.width() / 2 - mskirtH * 3 / 2 + mskirtH * onAnimationRepeatFlag,
            rectFGhost.width() / 2 + mskirtH.toFloat() + rectFGhost.top,
            mskirtH * 0.9f,
            mPaintHand
        )
        canvas.drawCircle(
            rectFGhost.left + rectFGhost.width() / 2 + (mskirtH * 3 / 2).toFloat() + (mskirtH * onAnimationRepeatFlag).toFloat(),
            rectFGhost.width() / 2 + mskirtH.toFloat() + rectFGhost.top,
            mskirtH * 0.9f,
            mPaintHand
        )


    }

    private fun drawBody(canvas: Canvas) {
        path.reset()

        val x = ((rectFGhost.width() / 2 - 15) * Math.cos(5 * Math.PI / 180f)).toFloat()
        val y = ((rectFGhost.width() / 2 - 15) * Math.sin(5 * Math.PI / 180f)).toFloat()

        val x2 = ((rectFGhost.width() / 2 - 15) * Math.cos(175 * Math.PI / 180f)).toFloat()
        val y2 = ((rectFGhost.width() / 2 - 15) * Math.sin(175 * Math.PI / 180f)).toFloat()


        path.moveTo(rectFGhost.left + rectFGhost.width() / 2 - x, rectFGhost.width() / 2 - y + rectFGhost.top)
        path.lineTo(rectFGhost.left + rectFGhost.width() / 2 - x2, rectFGhost.width() / 2 - y2 + rectFGhost.top)
        path.quadTo(
            rectFGhost.right + wspace / 2,
            rectFGhost.bottom,
            rectFGhost.right - wspace,
            rectFGhost.bottom - hspace
        )


        val a = mskirtH.toFloat()//(mskirtH/2);

        val m = (rectFGhost.width() - 2 * wspace) / 7f

        for (i in 0..6) {
            if (i % 2 == 0) {
                path.quadTo(
                    rectFGhost.right - wspace - m * i - m / 2,
                    rectFGhost.bottom - hspace - a,
                    rectFGhost.right - wspace - m * (i + 1),
                    rectFGhost.bottom - hspace
                )
            } else {
                path.quadTo(
                    rectFGhost.right - wspace - m * i - m / 2,
                    rectFGhost.bottom - hspace + a,
                    rectFGhost.right - wspace - m * (i + 1),
                    rectFGhost.bottom - hspace
                )

            }
        }

        path.quadTo(
            rectFGhost.left - 5,
            rectFGhost.bottom,
            rectFGhost.left + rectFGhost.width() / 2 - x,
            rectFGhost.width() / 2 - y + rectFGhost.top
        )


        path.close()
        canvas.drawPath(path, mPaint)


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()

        val distance = (mWidth - 2 * mPadding) / 3 * 2f * mAnimatedValue

        rectFGhost.left = mPadding + distance
        rectFGhost.right = (mWidth - 2 * mPadding) / 3 + distance
        var moveY = 0f
        val moveYMax = mHight / 4f / 2f
        val shadowHighMax = 5f
        var shadowHigh = 0f

        if (mAnimatedValue <= 0.25) {
            moveY = (moveYMax / 0.25 * mAnimatedValue).toFloat()
            rectFGhost.top = moveY

            rectFGhost.bottom = mHight / 4 * 3 + moveY

            shadowHigh = shadowHighMax / 0.25f * mAnimatedValue


        } else if (mAnimatedValue > 0.25 && mAnimatedValue <= 0.5f) {

            moveY = (moveYMax / 0.25 * (mAnimatedValue - 0.25f)).toFloat()
            rectFGhost.top = moveYMax - moveY
            rectFGhost.bottom = mHight / 4 * 3 + moveYMax - moveY

            shadowHigh = shadowHighMax - shadowHighMax / 0.25f * (mAnimatedValue - 0.25f)

        } else if (mAnimatedValue > 0.5 && mAnimatedValue <= 0.75f) {
            moveY = (moveYMax / 0.25 * (mAnimatedValue - 0.5f)).toFloat()
            rectFGhost.top = moveY
            rectFGhost.bottom = mHight / 4 * 3 + moveY
            shadowHigh = shadowHighMax / 0.25f * (mAnimatedValue - 0.5f)


        } else if (mAnimatedValue > 0.75 && mAnimatedValue <= 1f) {
            moveY = (moveYMax / 0.25 * (mAnimatedValue - 0.75f)).toFloat()
            rectFGhost.top = moveYMax - moveY
            rectFGhost.bottom = mHight / 4 * 3 + moveYMax - moveY
            shadowHigh = shadowHighMax - shadowHighMax / 0.25f * (mAnimatedValue - 0.75f)

        }


        rectFGhostShadow.top = mHight - 25 + shadowHigh
        rectFGhostShadow.bottom = mHight - 5f - shadowHigh
        rectFGhostShadow.left = rectFGhost.left + 5f + shadowHigh * 3
        rectFGhostShadow.right = rectFGhost.right - 5f - shadowHigh * 3
        drawShadow(canvas)
        drawHead(canvas)
        drawBody(canvas)
        drawHand(canvas)
        canvas.restore()

    }

    override fun OnAnimationUpdate(valueAnimator: ValueAnimator) {
        mAnimatedValue = valueAnimator.animatedValue as Float
        invalidate()
    }

    override fun SetAnimRepeatCount(): Int {
        return ValueAnimator.INFINITE
    }

    override fun OnAnimationRepeat(animation: Animator) {
        onAnimationRepeatFlag = onAnimationRepeatFlag * -1

        if (onAnimationRepeatFlag == -1) {
            wspace = 22f
        } else {
            wspace = -2f
        }
    }

    override fun OnStopAnim(): Int {
        mAnimatedValue = 0f
        wspace = 10f
        onAnimationRepeatFlag = 1
        postInvalidate()
        return 1
    }

    override fun SetAnimRepeatMode(): Int {
        return ValueAnimator.REVERSE
    }

    override fun AinmIsRunning() {
        wspace = -2f
    }
}