package com.annarm.douban.moive.annotation

/**
 * description:
 * @author wangzhijun
 * date 2018/11/20 9:27
 * @version V1.0
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ContentView(val value: Int)