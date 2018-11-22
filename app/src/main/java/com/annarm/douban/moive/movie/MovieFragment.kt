package com.annarm.douban.moive.movie

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.BindView
import com.annarm.douban.moive.R
import com.annarm.douban.moive.base.BaseFragment
import com.annarm.douban.moive.network.BaseObserver
import com.annarm.douban.moive.network.RetrofitManager
import com.annarm.douban.moive.network.response.MovieListModal
import com.annarm.douban.moive.network.service.MovieService

/**
 * description:
 * @author wangzhijun
 * date 2018/11/20 9:17
 * @version V1.0
 */
class MovieFragment : BaseFragment(){
    override fun layout(): Int {
        return R.layout.fragment_movie
    }

    var pageIndex:Int = 0
    private val pageSize:Int = 12

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    private var adapter: MovieListAdapter? = null

    override fun init() {
        Log.e("init function time", System.currentTimeMillis().toString())
        initList()
        loadMovies(pageIndex)
    }

    private fun initList() {
        adapter = MovieListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(activity , 3)
    }

    private fun loadMovies(pageIndex:Int) {
        val observer = RetrofitManager.instance.create(MovieService::class.java).movieList("沈阳", pageIndex*pageSize, pageSize)
        RetrofitManager.instance.toSubscribe(observer, object : BaseObserver<MovieListModal>() {
            override fun onFailed() {
                Log.e("request", "failed")
            }

            override fun onSuccess(result: MovieListModal) {
                Log.e("request", "success" + result.subjects.size)
                adapter!!.add(result.subjects)
            }
        })

    }
}