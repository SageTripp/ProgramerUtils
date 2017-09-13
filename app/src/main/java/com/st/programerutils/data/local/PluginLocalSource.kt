package com.st.programerutils.data.local

import com.st.programerutils.model.Model
import io.reactivex.Flowable
import io.reactivex.rxkotlin.toSingle

/**
 * Created by sage-tripp on 17-9-12.
 * 本地获取插件
 */
object PluginLocalSource {
    fun getPlugins(): Flowable<ArrayList<Model.Plugin>>? {
        val plugin = Model.Plugin("ADB无线调试",
                "无线调试工具_mock",
                1,
                Model.PluginInfo("1.0",
                        url = "",
                        localUrl = "",
                        author = "SageTripp",
                        starts = 3))
        return arrayListOf(plugin, plugin.copy(name = "另外一个"))
                .toSingle()
                .toFlowable()
    }
}
