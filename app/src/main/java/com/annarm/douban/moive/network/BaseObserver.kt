package com.annarm.douban.moive.network

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 16:08
 * @version V1.0
 */
abstract class BaseObserver<T> : Observer<T> {
    override fun onComplete() {
        Log.e("Retrofit", "onComplete")
    }

    override fun onSubscribe(d: Disposable) {
        Log.e("Retrofit", "onSubscribe")
    }

    override fun onNext(t: T) {
       onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFailed()
    }

    abstract fun onFailed()

    abstract fun onSuccess(result:T)
}