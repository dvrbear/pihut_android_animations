package com.example.pihut_android_animations.utils

import android.graphics.Canvas
import android.graphics.drawable.Drawable

internal class Snowflake(
    private val containerWidth: Int,
    private val containerHeight: Int,
    private val drawable: Drawable,
    private val maxSize: Float,
    private val maxSpeed: Float
) {

    private var size: Double = 0.0
    private var speedX: Double = 0.0
    private var speedY: Double = 0.0
    private var x: Double = 0.0
    private var y: Double = 0.0

    init {
        reset()
    }

    private fun reset() {
        size = Math.random() * maxSize / 2f + maxSize / 2f
        speedX = Math.random() * maxSpeed / 4f + maxSpeed / -4f
        speedY = Math.random() * maxSpeed / 2f + maxSpeed / 2f
        x = Math.random() * containerWidth
        y = Math.random() * maxSize * -10 - maxSize
    }

    fun update() {
        x += speedX
        y += speedY
        if (y > containerHeight) {
            reset()
        }
    }

    fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }
        drawable.alpha = 150
        drawable.setBounds(x.toInt(), y.toInt(), (x + size).toInt(), (y + size).toInt())
        drawable.draw(canvas)
    }
}