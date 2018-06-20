package heven.greendaotest.databind

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

object ImageBindAdapter {

    @BindingAdapter("android:imageUrl")
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String) {
        val requestOptions = RequestOptions()
        requestOptions.transform(CenterCrop())
                .centerCrop()
        Glide.with(imageView).load(url).apply(requestOptions).into(imageView)
    }
}