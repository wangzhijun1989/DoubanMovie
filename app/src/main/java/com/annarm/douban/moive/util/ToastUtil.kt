package com.annarm.douban.moive.util

import android.content.Context
import android.widget.Toast
import com.annarm.douban.moive.app.DMApplication

/**
 * description:
 * @author wangzhijun
 * date 2019/4/28 7:36 PM
 * @version V1.0
 */

class ToastUtil {

    companion object {
        private var oldMsg: String? = null
        /** Toast对象  */
        private var toast: Toast? = null
        /** 第一次时间  */
        private var oneTime: Long = 0
        /** 第二次时间  */
        private var twoTime: Long = 0
        /**
         *
         * @param message
         */
        fun showToast(message: String) {
            showToast(DMApplication.instance, message)
        }

        /**
         *
         * @param res
         */
        fun showToast(res: Int) {
            showToast(DMApplication.instance, DMApplication.instance.getString(res))
        }

        /**
         * 显示Toast
         * @param context
         * @param message
         */
        fun showToast(context: Context, message: String) {
            if (toast == null) {
                toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
                toast!!.show()
                oneTime = System.currentTimeMillis()
            } else {
                twoTime = System.currentTimeMillis()
                if (message == oldMsg) {
                    if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                        toast!!.show()
                    }
                } else {
                    oldMsg = message
                    toast!!.setText(message)
                    toast!!.show()
                }
            }
            oneTime = twoTime
        }
    }
}