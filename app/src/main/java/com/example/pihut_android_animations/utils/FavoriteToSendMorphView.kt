package com.example.pihut_android_animations.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.pihut_android_animations.R

class FavoriteToSendMorphView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var sendToFavorite: AnimatedVectorDrawableCompat? = null
    private var favoriteToSend: AnimatedVectorDrawableCompat? = null
    private var showingFavorite: Boolean = false

    init {
        showingFavorite = true
        favoriteToSend = AnimatedVectorDrawableCompat.create(context, R.drawable.avd_favorite_to_send)
        sendToFavorite = AnimatedVectorDrawableCompat.create(context, R.drawable.avd_send_to_favorite)
        setImageDrawable(favoriteToSend)
        showSend()
    }

    fun showFavorite() {
        if (!showingFavorite) {
            morph()
        }
    }

    fun showSend() {
        if (showingFavorite) {
            morph()
        }
    }

    fun morph() {
        val drawable = if (showingFavorite) favoriteToSend else sendToFavorite
        setImageDrawable(drawable)
        drawable?.start()
        showingFavorite = !showingFavorite
    }
}