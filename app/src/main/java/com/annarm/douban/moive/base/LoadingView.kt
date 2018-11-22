package com.annarm.douban.moive.base

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * description:
 * @author wangzhijun
 * date 2018/11/21 15:52
 * @version V1.0
 */
class LoadingView : LinearLayout{
    var status:Int = 0
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    init {

    }

    companion object {
        const val SUCCESS:Int = 300
        const val FAILED:Int = 301
        const val LOADING:Int = 302
        const val DEFAULT:Int = 303
    }
}
