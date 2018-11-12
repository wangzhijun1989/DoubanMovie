 package com.annarm.douban.moive.app

import android.app.Application
import kotlin.properties.Delegates

 /**
 * description:
 * @author wangzhijun
 * date 2018/11/12 13:05
 * @version V1.0
 */
class DMApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance:DMApplication by Delegates.notNull()
    }
}