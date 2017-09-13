package com.st.programerutils.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.st.programerutils.BR
import com.st.programerutils.R
import com.st.programerutils.data.DataSource
import com.st.programerutils.databinding.ItemPluginBinding
import com.st.programerutils.databinding.PluginListFragmentDB
import com.st.programerutils.model.Model
import com.st.programerutils.ui.MagicAdapter
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_plugin_list.*

/**
 * Created by sage-tripp on 17-9-9.
 * 插件列表页面
 */

class PluginListFragment : Fragment() {
    private var canLoadData: Boolean = true

    private var pluginListDB: PluginListFragmentDB? = null
    private lateinit var magicAdapter: MagicAdapter<ItemPluginBinding, Model.Plugin>

    private var plugins: ArrayList<Model.Plugin> = ArrayList()

    fun setPlugins(plugins: ArrayList<Model.Plugin>) {
        this.plugins = plugins
        pluginListDB?.datas = plugins
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        pluginListDB = DataBindingUtil.inflate(inflater, R.layout.fragment_plugin_list, container, false)
        return pluginListDB?.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        magicAdapter = MagicAdapter(R.layout.item_plugin, ArrayList()) {
            return@MagicAdapter BR.plugin
        }
        rv_plugins.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_plugins.adapter = magicAdapter
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && canLoadData)
            loadData()
    }

    private fun loadData() {
        DataSource.getPlugins()
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe {
                    magicAdapter.datas.clear()
                    println("开始")
                }
                .subscribe({ plugins ->
                    magicAdapter.datas = plugins
                    pluginListDB?.datas = plugins
                    println("plugin = [$plugins]")
                }, Throwable::printStackTrace, {
                    rv_plugins.adapter.notifyDataSetChanged()
                    println("结束")
                    canLoadData = false
                })
    }

}
