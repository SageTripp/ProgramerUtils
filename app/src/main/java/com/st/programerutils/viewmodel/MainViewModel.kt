package com.st.programerutils.viewmodel

import com.st.programerutils.model.Model

/**
 * Created by sage-tripp on 17-9-7.
 * 主页面ViewModel
 */
object MainViewModel {
    /**
     * 加载插件
     * @param category 要加载的插件类别
     * @param pre 加载前
     * @param finish 加载完成
     */
    fun loadPlugins(category: Int, pre: () -> Unit, finish: (success: Boolean, plugins: ArrayList<Model.Plugin>) -> Unit) {
        pre()
        //TODO 执行加载插件
        finish(true, arrayListOf())
    }
}