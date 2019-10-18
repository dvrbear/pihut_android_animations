package com.example.pihut_android_animations.utils

import android.view.animation.Interpolator
import kotlin.math.abs

class ReverseInterpolator(private val mInterpolator: Interpolator) : Interpolator {

    override fun getInterpolation(input: Float): Float {
        return mInterpolator.getInterpolation(reverseInput(input))
    }

    /**
     * Map value so 0-0.5 = 0-1 and 0.5-1 = 1-0
     */
    private fun reverseInput(input: Float): Float {
        return if (input <= 0.5)
            input * 2
        else
            abs(input - 1) * 2
    }
}