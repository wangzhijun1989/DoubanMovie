package com.annarm.douban.moive.network

import android.util.Log
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 15:41
 * @version V1.0
 */
class RetrofitManager{

    private var retrofit:Retrofit? = null

    private constructor(){
        var builder:OkHttpClient.Builder = OkHttpClient.Builder()
        //连接 超时时间
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        //写操作 超时时间
        builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        //读操作 超时时间
        builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        //错误重连
        builder.retryOnConnectionFailure(true)
        //add common param
        builder.addInterceptor(HttpParamInterceptor())
        //add log interceptor
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logging)
        val okHttpClient = builder.build()

        retrofit = Retrofit.Builder().baseUrl(SERVER_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun <T> create(service: Class<T>): T {
        return retrofit!!.create(service)
    }

    fun <T> toSubscribe(o: Observable<T>, observer: BaseObserver<T>) {
        o.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun <T> toSubscribe(o: Observable<T>, provider: LifecycleProvider<ActivityEvent>, observer: BaseObserver<T>) {
        o.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(provider.bindUntilEvent(ActivityEvent.DESTROY))
            .subscribe(observer)
    }

    companion object {
        const val DEFAULT_TIME_OUT:Long = 3000
        const val SERVER_URL = "https://api.douban.com/v2/movie/"
        var instance:RetrofitManager? = null
        get() {
            if(field == null){
                field = RetrofitManager()
            }
            return field
        }
    }



}