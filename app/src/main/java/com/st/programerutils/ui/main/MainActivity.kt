package com.st.programerutils.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.st.programerutils.R
import com.st.programerutils.data.DataSource
import com.st.programerutils.databinding.ActivityMainBinding
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.appTitle = "程序员工具"
        loadView()
    }

    /**
     * 加载布局
     */
    private fun loadView() {
        /*
        titleBar
         */
        setSupportActionBar(tb_title_main)
        supportActionBar?.also {
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        /*
        侧滑菜单
         */
        val drawerListener = object : ActionBarDrawerToggle(this, dl_menu, tb_title_main, R.string.open, R.string.close) {}
        drawerListener.syncState()
        dl_menu.addDrawerListener(drawerListener)
        nav_left.setNavigationItemSelectedListener { item ->
            navigateTo(item.title.toString())
            return@setNavigationItemSelectedListener true
        }

        tl_tab_main.setupWithViewPager(vp_content, true)
        vp_content.adapter = PluginCategoryPagerAdapter(supportFragmentManager)
    }

    /**
     * 导航到目标位置
     */
    private fun navigateTo(target: String) {
        toast(target)
        when (target) {
            getString(R.string.main_page) -> {//首页
            }
            getString(R.string.theme) -> {//主题
            }
            getString(R.string.feedback) -> {//反馈
            }
            getString(R.string.share) -> {//分享
            }
            getString(R.string.order) -> {//打赏
            }
            getString(R.string.about) -> {//关于
            }
        }
    }

    override fun onBackPressed() {
        if (dl_menu.isDrawerOpen(nav_left)) {
            dl_menu.closeDrawer(nav_left)
        } else {
            super.onBackPressed()
        }
    }

}
