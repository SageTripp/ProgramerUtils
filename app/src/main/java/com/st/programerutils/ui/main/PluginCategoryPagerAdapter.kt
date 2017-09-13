package com.st.programerutils.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View

/**
 * Created by sage-tripp on 17-9-7.
 * 插件类别ViewPager适配器
 */
class PluginCategoryPagerAdapter(val supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager) {
    override fun getItem(position: Int): Fragment {
        return PluginListFragment().also { it.setPlugins(ArrayList()) }
    }

    private val categorys = arrayOf("常用", "存储")


    override fun getCount(): Int {
        return categorys.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return categorys[position]
    }
}