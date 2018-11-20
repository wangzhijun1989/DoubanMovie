package com.annarm.douban.moive.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder


/**
 * description:
 * @author wangzhijun
 * date 2018/11/20 9:16
 * @version V1.0
 */
open class BaseFragment : Fragment(){
    var unBinder: Unbinder? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView(inflater, container)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unBinder?.unbind()
    }

    private fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        val layout = layout()
        var view:View? = null
        if (layout != NO_LAYOUT){
            view = inflater.inflate(layout, container, false)
            unBinder = ButterKnife.bind(this, view)
        }
        init()
        return view
    }

    open fun layout():Int{
        return NO_LAYOUT
    }

    open fun init(){

    }

    companion object {
        private const val NO_LAYOUT = -1
    }
}