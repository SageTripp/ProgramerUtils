package com.st.programerutils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.annotation.DrawableRes
import android.widget.ImageView
import org.jetbrains.anko.imageURI

/**
 * Created by sage-tripp on 17-9-13.
 * 绑定
 */
object DataBindingAdapters {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUri(imageView: ImageView, imageUri: String?) {
        imageView.imageURI = if (null == imageUri) null else Uri.parse(imageUri)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUri(imageView: ImageView, imageUri: Uri?) {
        imageView.imageURI = imageUri
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageDrawable(imageView: ImageView, drawable: Drawable) {
        imageView.setImageDrawable(drawable)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, @DrawableRes drawableRes: Int) {
        imageView.setImageResource(drawableRes)
    }

}