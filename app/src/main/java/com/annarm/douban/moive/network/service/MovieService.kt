package com.annarm.douban.moive.network.service

import com.annarm.douban.moive.network.response.MovieListModal
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 16:31
 * @version V1.0
 */
interface MovieService{
    @GET("in_theaters")
    fun movieList(@Query("city")city:String, @Query("start" )start:Int, @Query("count" )count:Int): Observable<MovieListModal>
}