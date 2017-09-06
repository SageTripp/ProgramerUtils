package com.st.programerutils

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.st.programerutils.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainBinding.appTitle = "程序员工具"
        loadView()
    }

    private fun loadView() {
        setSupportActionBar(tb_title_main)
        supportActionBar?.also {
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        val drawerListener = object : ActionBarDrawerToggle(this, dl_menu, tb_title_main, R.string.open, R.string.close) {
            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }
        drawerListener.syncState()
        dl_menu.addDrawerListener(drawerListener)

    }

    override fun onBackPressed() {
        if (dl_menu.isDrawerOpen(nav_left)) {
            dl_menu.closeDrawer(nav_left)
        } else {
            super.onBackPressed()
        }
    }
}
