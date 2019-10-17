package com.example.pihut_android_animations.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import com.example.pihut_android_animations.R
import com.example.pihut_android_animations.utils.ReverseInterpolator
import kotlinx.android.synthetic.main.property_fragment.ivLogo
import kotlinx.android.synthetic.main.sequence_fragment.tvControl

class PropertyAnimatorFragment : Fragment() {

    private var isPlaying = false
    private lateinit var set: AnimatorSet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.property_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivLogo.scaleX = 0.5f
        ivLogo.scaleY = 0.5f

        val animationX = ObjectAnimator.ofFloat(ivLogo, "scaleX", 1f)
        val animationY = ObjectAnimator.ofFloat(ivLogo, "scaleY", 1f)

        set = AnimatorSet()
        set.play(animationX)
            .with(animationY)
        set.duration = 2000
        set.interpolator = ReverseInterpolator(DecelerateInterpolator())
        set.doOnEnd {
            if (isPlaying) {
                set.start()
            }
        }

        tvControl.setOnClickListener {
            switchState()
        }
    }

    private fun switchState() {
        isPlaying = !isPlaying
        if (isPlaying) {
            tvControl.text = getString(R.string.stop)
            set.start()
        } else {
            tvControl.text = getString(R.string.start)
            set.cancel()
        }
    }

}