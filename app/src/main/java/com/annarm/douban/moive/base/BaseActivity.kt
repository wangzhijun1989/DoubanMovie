package com.annarm.douban.moive.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import com.annarm.douban.moive.annotation.ContentView

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 13:00
 * @version V1.0
 */

open abstract class BaseActivity : AppCompatActivity(){

    open var unBinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initialize()
    }

    override fun onDestroy() {
        unBinder?.unbind()
        super.onDestroy()
    }

    private fun initView() {
        val contentView:ContentView? = this.javaClass.getAnnotation(ContentView::class.java)
        when {
            contentView != null -> setContentView(contentView.value)
            layout() != NO_LAYOUT -> setContentView(layout())
            else -> throw IllegalStateException("provide an layout res")
        }
        unBinder = ButterKnife.bind(this)
    }

    open fun layout():Int{
        return NO_LAYOUT
    }

    open abstract fun initialize()

    companion object {
        private const val NO_LAYOUT = -1
    }

    open fun needLoading():Boolean{
        return false
    }
}