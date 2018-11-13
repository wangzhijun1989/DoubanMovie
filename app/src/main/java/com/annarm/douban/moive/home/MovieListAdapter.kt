package com.annarm.douban.moive.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.annarm.douban.moive.R
import com.annarm.douban.moive.network.response.MovieListModal
import com.bumptech.glide.Glide

/**
 * description:
 * @author wangzhijun
 * date 2018/11/13 16:10
 * @version V1.0
 */
class MovieListAdapter() : RecyclerView.Adapter<MovieListHolder>() {

    var data: MutableList<MovieListModal.SubjectsBean> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieListHolder {
        return MovieListHolder(LayoutInflater.from(p0.context).inflate(R.layout.adapter_movie_list, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: MovieListHolder, p1: Int) {
        p0.refresh(data[p1])
    }

    fun add(arr:List<MovieListModal.SubjectsBean>){
        data.addAll(arr)
        notifyDataSetChanged()
    }

    fun clear(){
        data.clear()
        notifyDataSetChanged()
    }

}

class MovieListHolder : RecyclerView.ViewHolder {
    @BindView(R.id.iv_album)
    lateinit var ivAlbum: ImageView

    @BindView(R.id.tv_name)
    lateinit var tvName: TextView

    @BindView(R.id.tv_score)
    lateinit var tvScore: TextView

    fun refresh(subjectsBean: MovieListModal.SubjectsBean) {
        tvName.text = subjectsBean.title
        tvScore.text = subjectsBean.rating.average.toString()
        Glide.with(ivAlbum).load(subjectsBean.images.small).into(ivAlbum)
    }

    constructor(view: View) : super(view) {
        ButterKnife.bind(this, view)
    }
}