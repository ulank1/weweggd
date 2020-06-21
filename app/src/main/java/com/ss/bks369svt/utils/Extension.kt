package com.ss.bks369svt.utils

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.CropCircleTransformation


fun setRoundedImage(imageView: ImageView, url: String, context: Context) {

    Glide.with(context).load(url)
        .apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(16)))
        .into(imageView)

}
fun setRoundedImageFromAssets(imageView: ImageView, url: String, context: Context) {

    Glide.with(context).load(Uri.parse(url))
        .apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(16)))
        .into(imageView)

}