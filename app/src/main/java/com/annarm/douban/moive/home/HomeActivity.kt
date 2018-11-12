package com.annarm.douban.moive.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.annarm.douban.moive.R
import com.annarm.douban.moive.base.BaseActivity

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 13:00
 * @version V1.0
 */
class HomeActivity : BaseActivity(){
    var unBinder:Unbinder? = null

    @BindView(R.id.tv) lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        unBinder = ButterKnife.bind(this)
        tv.text = "learn Kotlin"
    }

    @OnClick(R.id.tv)
    fun onClick(view: View){
        when (view.id){
            R.id.tv -> Toast.makeText(this, "lla", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unBinder!!.unbind()
    }

}