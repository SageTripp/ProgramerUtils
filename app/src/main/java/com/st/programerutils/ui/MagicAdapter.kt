package com.st.programerutils.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by sage-tripp on 17-9-12.
 * 这是一个神奇的适配器
 */
class MagicAdapter<DB : ViewDataBinding, D>(@LayoutRes val layoutRes: Int, var datas: ArrayList<D> = ArrayList(), val getvariableBR: () -> Int) :
        RecyclerView.Adapter<MagicAdapter.MagicViewHolder<DB>>() {

    override fun onBindViewHolder(holder: MagicViewHolder<DB>?, position: Int) {
        holder?.itemDB?.setVariable(getvariableBR(), datas[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MagicViewHolder<DB> {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val itemDB = DataBindingUtil.inflate<DB>(layoutInflater, layoutRes, parent, false)
        return MagicViewHolder(itemDB)
    }

    override fun getItemCount(): Int = datas.size

    class MagicViewHolder<out DB : ViewDataBinding>(val itemDB: DB) : RecyclerView.ViewHolder(itemDB.root)
}