package com.stfalcon.sample.features.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stfalcon.sample.R
import com.stfalcon.sample.databinding.ActivityMainBinding
import com.stfalcon.sample.features.demo.grid.PostersGridDemoActivity
import com.stfalcon.sample.features.demo.rotation.RotationDemoActivity
import com.stfalcon.sample.features.demo.scroll.ScrollingImagesDemoActivity
import com.stfalcon.sample.features.demo.styled.StylingDemoActivity
import com.stfalcon.sample.features.main.adapter.MainActivityPagerAdapter
import com.stfalcon.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_IMAGES_GRID
import com.stfalcon.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_ROTATION
import com.stfalcon.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_SCROLL
import com.stfalcon.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_STYLING
import com.stfalcon.sample.features.main.card.DemoCardFragment

class MainActivity : AppCompatActivity(),
    DemoCardFragment.OnCardActionListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainCardsViewPager.apply {
            adapter = MainActivityPagerAdapter(this@MainActivity, supportFragmentManager)
            pageMargin = resources.getDimension(R.dimen.card_padding).toInt() / 4
            offscreenPageLimit = 3
        }
    }

    override fun onCardAction(actionId: Int) {
        when (actionId) {
            ID_IMAGES_GRID -> {
                startActivity(Intent(this, PostersGridDemoActivity::class.java))
            }
            ID_SCROLL -> {
                startActivity(Intent(this, ScrollingImagesDemoActivity::class.java))
            }
            ID_STYLING -> {
                startActivity(Intent(this, StylingDemoActivity::class.java))
            }
            ID_ROTATION -> {
                startActivity(Intent(this, RotationDemoActivity::class.java))
            }
        }
    }
}
