package com.annarm.douban.moive.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentTransaction
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.annarm.douban.moive.R
import com.annarm.douban.moive.annotation.ContentView
import com.annarm.douban.moive.base.BaseActivity
import com.annarm.douban.moive.base.BaseFragment
import com.annarm.douban.moive.movie.MovieFragment
import com.annarm.douban.moive.reading.ReadingFragment
import com.annarm.douban.moive.tool.ToolFragment

/**
 * description:
 * @author wangzhijun
 * date 2018/11/12 13:00
 * @version V1.0
 */
@ContentView(R.layout.activity_home)
class HomeActivity : BaseActivity() {

    private var movieFragment: MovieFragment? = null
    private var readingFragment: ReadingFragment? = null
    private var toolFragment: ToolFragment? = null
    @BindView(R.id.tabLayout)
    lateinit var tabLayout: TabLayout

    override fun initialize() {
        initView()
        setTabSelected(0)
    }

    private fun initView() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.e("wangzhijun", p0?.position.toString())
                setTabSelected(p0?.position ?: 0)
            }

        })
    }

    private fun setTabSelected(position: Int) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        var currentFragment:BaseFragment? = null
        when(position){
            0-> {
                if (movieFragment == null){
                    movieFragment = MovieFragment()
                    transaction.add(R.id.container, movieFragment!!)
                }
                currentFragment = movieFragment
            }
            1->{
                if (readingFragment == null){
                    readingFragment = ReadingFragment()
                    transaction.add(R.id.container, readingFragment!!)
                }
                currentFragment = readingFragment
            }
            2->{
                if (toolFragment == null){
                    toolFragment = ToolFragment()
                    transaction.add(R.id.container, toolFragment!!)
                }
                currentFragment = toolFragment
            }
        }
        hiddenAllFragment(transaction)
        transaction.show(currentFragment!!)
        transaction.commit()
    }

    private fun hiddenAllFragment(transaction: FragmentTransaction) {
        if (movieFragment != null) transaction.hide(movieFragment!!)
        if (readingFragment != null) transaction.hide(readingFragment!!)
        if (toolFragment != null) transaction.hide(toolFragment!!)
    }

}