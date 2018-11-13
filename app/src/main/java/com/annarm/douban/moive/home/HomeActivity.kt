package com.annarm.douban.moive.home

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.annarm.douban.moive.R
import com.annarm.douban.moive.base.BaseActivity
import com.annarm.douban.moive.network.BaseObserver
import com.annarm.douban.moive.network.RetrofitManager
import com.annarm.douban.moive.network.response.MovieListModal
import com.annarm.douban.moive.network.service.MovieService

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 13:00
 * @version V1.0
 */
class HomeActivity : BaseActivity() {
    var unBinder: Unbinder? = null
    var pageIndex:Int = 0
    private val pageSize:Int = 12

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    private var adapter: MovieListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        unBinder = ButterKnife.bind(this)
        initView()
        loadMovies(pageIndex)
    }

    private fun initView() {
        adapter = MovieListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this , 3)
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

    override fun onDestroy() {
        super.onDestroy()
        unBinder!!.unbind()
    }

}