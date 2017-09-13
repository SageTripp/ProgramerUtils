package com.st.programerutils.data.net

import com.st.programerutils.model.Model
import io.reactivex.Flowable

/**
 * Created by sage-tripp on 17-9-12.
 * 从网络获取插件
 */
object PluginNetSource {
    fun getPlugins(): Flowable<ArrayList<Model.Plugin>> {
        return Flowable.just(ArrayList())
    }
}