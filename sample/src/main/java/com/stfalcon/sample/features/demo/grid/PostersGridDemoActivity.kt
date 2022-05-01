package com.stfalcon.sample.features.demo.grid

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.stfalcon.imageviewer.StfalconImageViewer
import com.stfalcon.sample.R
import com.stfalcon.sample.common.extensions.getDrawableCompat
import com.stfalcon.sample.common.extensions.loadImage
import com.stfalcon.sample.common.models.Demo
import com.stfalcon.sample.common.models.Poster
import com.stfalcon.sample.databinding.ActivityDemoPostersGridBinding

class PostersGridDemoActivity : AppCompatActivity() {

    private lateinit var viewer: StfalconImageViewer<Poster>
    lateinit var binding: ActivityDemoPostersGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoPostersGridBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postersGridView.apply {
            imageLoader = ::loadPosterImage
            onPosterClick = ::openViewer
        }
    }

    private fun openViewer(startPosition: Int, target: ImageView) {
        viewer = StfalconImageViewer.Builder<Poster>(this, Demo.posters, ::loadPosterImage)
            .withStartPosition(startPosition)
            .withTransitionFrom(target)
                .withBackgroundColor(ColorUtils.setAlphaComponent(Color.BLACK, 50))
            .withImageChangeListener {
                viewer.updateTransitionImage(binding.postersGridView.imageViews[it])
            }
            .show()
    }

    private fun loadPosterImage(imageView: ImageView, poster: Poster?) {
        imageView.apply {
            background = getDrawableCompat(R.drawable.shape_placeholder)
            loadImage(poster?.url)
        }
    }
}