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
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen

/**
 * description:
 * @author wangzhijun
 * date 2018/11/20 9:17
 * @version V1.0
 */
class MovieFragment : BaseFragment() {
    override fun layout(): Int {
        return R.layout.fragment_movie
    }

    private var pageIndex: Int = 0
    private val pageSize: Int = 12
    private lateinit var skeleton: SkeletonScreen

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    private var adapter: MovieListAdapter? = null

    override fun initialize() {
        Log.e("initialize function", System.currentTimeMillis().toString())
        initList()
        initSkeleton()
        loadMovies(pageIndex)
    }

    private fun initSkeleton() {
        skeleton = Skeleton.bind(recyclerView)
            .adapter(adapter)
            .load(R.layout.skeleton_movie_list)
            .show()
    }

    private fun initList() {
        adapter = MovieListAdapter()
//        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
    }

    private fun loadMovies(pageIndex: Int) {
        skeleton.show()
        val observer =
            RetrofitManager.instance.create(MovieService::class.java).movieList("沈阳", pageIndex * pageSize, pageSize)
        RetrofitManager.instance.toSubscribe(observer, object : BaseObserver<MovieListModal>() {
            override fun onFailed() {
                Log.e("request", "failed")
            }

            override fun onSuccess(result: MovieListModal) {
                Log.e("request", "success" + result.subjects.size)
                adapter!!.add(result.subjects)
            }

            override fun onComplete() {
                super.onComplete()
                skeleton.hide()
            }
        })

    }
}