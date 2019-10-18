package com.example.pihut_android_animations.fragments

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pihut_android_animations.R
import kotlinx.android.synthetic.main.property_fragment.ivRobot
import kotlinx.android.synthetic.main.sequence_fragment.tvControl

class XMLAnimatorFragment : Fragment() {

    private var isPlaying = false
    private lateinit var set: AnimatorSet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.xml_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivRobot.scaleX = 0.5f
        ivRobot.scaleY = 0.5f

        set = AnimatorInflater.loadAnimator(context, R.animator.animation) as AnimatorSet
        set.setTarget(ivRobot)
//        set.interpolator = ReverseInterpolator(DecelerateInterpolator())
//        set.doOnEnd {
//            if (isPlaying) {
//                set.start()
//            }
//        }

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