package com.st.programerutils.ui

import android.support.v4.app.Fragment
import java.util.*

/**
 * Created by sage-tripp on 17-9-9.
 * 列表Fragment基类
 */
abstract class ListBastFragment<T : Any>(val datas: ArrayList<T> = ArrayList()) : Fragment() {

}