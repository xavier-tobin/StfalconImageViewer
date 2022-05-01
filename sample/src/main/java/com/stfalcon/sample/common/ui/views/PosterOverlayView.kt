package com.stfalcon.sample.common.ui.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.stfalcon.sample.R
import com.stfalcon.sample.common.extensions.sendShareIntent
import com.stfalcon.sample.common.models.Poster
import com.stfalcon.sample.databinding.ViewPosterOverlayBinding

class PosterOverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onDeleteClick: (Poster) -> Unit = {}
    lateinit var binding: ViewPosterOverlayBinding

    init {
        binding = ViewPosterOverlayBinding.inflate(LayoutInflater.from(context), this)
        setBackgroundColor(Color.TRANSPARENT)
    }

    fun update(poster: Poster) {
        binding.posterOverlayDescriptionText.text = poster.description
        binding.posterOverlayShareButton.setOnClickListener { context.sendShareIntent(poster.url) }
        binding.posterOverlayDeleteButton.setOnClickListener { onDeleteClick(poster) }
    }
}