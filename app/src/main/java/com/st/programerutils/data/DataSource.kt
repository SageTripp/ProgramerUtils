package com.st.programerutils.data

import com.st.programerutils.data.local.PluginLocalSource
import com.st.programerutils.data.mock.PluginMockSource
import com.st.programerutils.data.net.PluginNetSource
import com.st.programerutils.model.Model
import io.reactivex.Flowable

/**
 * Created by sage-tripp on 17-9-12.
 * 数据源
 */
object DataSource {
    /**
     * 是否模拟数据
     */
    var isMock = false

    fun getPlugins(): Flowable<ArrayList<Model.Plugin>> {
        val pluginsFromMock = PluginMockSource.getPlugins()
        val pluginsFromLocal = PluginLocalSource.getPlugins()
        val pluginsFromNet = PluginNetSource.getPlugins()
        return if (isMock)
            Flowable.concat(pluginsFromMock, pluginsFromLocal, pluginsFromNet)
                    .first(ArrayList())
                    .toFlowable()
        else
            Flowable.concat(pluginsFromLocal, pluginsFromNet)
                    .first(ArrayList())
                    .toFlowable()
    }


}