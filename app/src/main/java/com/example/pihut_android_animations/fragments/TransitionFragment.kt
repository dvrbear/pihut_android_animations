package com.example.pihut_android_animations.fragments

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pihut_android_animations.R
import kotlinx.android.synthetic.main.transition_fragment.ccRoot
import kotlinx.android.synthetic.main.transition_fragment.iv1
import kotlinx.android.synthetic.main.transition_fragment.iv2
import kotlinx.android.synthetic.main.transition_fragment.iv3
import kotlinx.android.synthetic.main.transition_fragment.iv4
import kotlinx.android.synthetic.main.transition_fragment.iv5
import kotlinx.android.synthetic.main.transition_fragment.placeholder

class TransitionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.transition_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv1.setOnClickListener { swapView(iv1) }
        iv2.setOnClickListener { swapView(iv2) }
        iv3.setOnClickListener { swapView(iv3) }
        iv4.setOnClickListener { swapView(iv4) }
        iv5.setOnClickListener { swapView(iv5) }
    }

    private fun swapView(view: View) {
        TransitionManager.beginDelayedTransition(ccRoot)
        placeholder.setContentId(view.id)
    }

}