package com.stfalcon.sample.common.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.stfalcon.sample.common.models.Demo
import com.stfalcon.sample.common.models.Poster
import com.stfalcon.sample.databinding.ViewPostersGridBinding

class PostersGridView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var imageLoader: ((ImageView, Poster?) -> Unit)? = null
    var onPosterClick: ((Int, ImageView) -> Unit)? = null
    lateinit var binding: ViewPostersGridBinding

    val imageViews by lazy {
        mapOf(
            0 to binding.postersFirstImage,
            1 to binding.postersSecondImage,
            2 to binding.postersThirdImage,
            3 to binding.postersFourthImage,
            4 to binding.postersFifthImage,
            5 to binding.postersSixthImage,
            6 to binding.postersSeventhImage,
            7 to binding.postersEighthImage,
            8 to binding.postersNinthImage)
    }

    init {
        binding = ViewPostersGridBinding.inflate(LayoutInflater.from(context), this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        imageViews.values.forEachIndexed { index, imageView ->
            imageLoader?.invoke(imageView, Demo.posters.getOrNull(index))
            imageView.setOnClickListener { onPosterClick?.invoke(index, imageView) }
        }
    }
}