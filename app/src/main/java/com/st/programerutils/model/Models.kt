package com.st.programerutils.model

import android.net.Uri

/**
 * Created by sage-tripp on 17-9-7.
 * 所有的model
 */
object Model {

    /**
     * @property name 插件名称
     * @property desc 插件描述
     * @property category 插件类别
     * @property info 插件信息
     */
    data class Plugin(val name: String,
                      val desc: String,
                      var category: Int,
                      var info: PluginInfo)


    /**
     * @property versionName 插件版本
     * @property versionCode 插件版本号
     * @property url 插件网络地址
     * @property localUrl 插件本地保存路径
     */
    data class PluginInfo(var versionName: String = "",
                          var versionCode: Int = 1,
                          var url: String,
                          var localUrl: String,
                          var author: String,
                          var starts: Int)

    data class User(var name: String, var nickName: String, var thumb: Uri)
}