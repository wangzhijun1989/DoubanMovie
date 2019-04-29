package com.annarm.douban.moive.movie

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import com.annarm.douban.moive.R
import com.annarm.douban.moive.annotation.ContentView
import com.annarm.douban.moive.base.BaseActivity
import com.annarm.douban.moive.network.BaseObserver
import com.annarm.douban.moive.network.RetrofitManager
import com.annarm.douban.moive.network.response.MovieDetailModal
import com.annarm.douban.moive.network.service.MovieService
import com.annarm.douban.moive.util.ToastUtil
import com.bumptech.glide.Glide
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import io.reactivex.Observable

/**
 * description:
 * @author wangzhijun
 * date 2019/4/28 7:11 PM
 * @version V1.0
 */
@ContentView(R.layout.activity_movie_detail)
class MovieDetailActivity : BaseActivity() {

    lateinit var id: String

    @BindView(R.id.iv_album)
    lateinit var ivAlbum: ImageView

    @BindView(R.id.tv_name)
    lateinit var tvName: TextView

    @BindView(R.id.ll_container)
    lateinit var llContainer: LinearLayout

    private lateinit var skeleton: SkeletonScreen

    override fun initialize() {
        intent.let {
            id = it.getStringExtra("id")
        }
        initSkeleton()
        loadDetail();
    }

    private fun initSkeleton() {
        skeleton = Skeleton.bind(llContainer)
            .load(R.layout.activity_movie_detail)
            .show()
    }

    private fun loadDetail() {
        val observable:Observable<MovieDetailModal> = RetrofitManager.instance.create(MovieService::class.java).movieDetail(id)
        RetrofitManager.instance.toSubscribe(observable, object : BaseObserver<MovieDetailModal>(){
            override fun onFailed() {
                ToastUtil.showToast("详情加载失败")
            }

            override fun onSuccess(result: MovieDetailModal) {
                Glide.with(ivAlbum).load(result.images.small).into(ivAlbum)
                tvName.text = result.title
            }

            override fun onComplete() {
                super.onComplete()
                skeleton.hide()
            }
        })

    }
}