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
import kotlinx.android.synthetic.main.transition_fragment.ivEmpty
import kotlinx.android.synthetic.main.transition_fragment.placeholder

class TransitionFragment : Fragment() {

    private var current = 0
    private var empty = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.transition_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv1.setOnClickListener { swapView(iv1.id) }
        iv2.setOnClickListener { swapView(iv2.id) }
        iv3.setOnClickListener { swapView(iv3.id) }
        iv4.setOnClickListener { swapView(iv4.id) }
        iv5.setOnClickListener { swapView(iv5.id) }

        empty = ivEmpty.id
        swapView(empty)
    }

    private fun swapView(clicked: Int) {
        TransitionManager.beginDelayedTransition(ccRoot)

        current = when{
            clicked != current && clicked != empty -> clicked
            else -> empty
        }
        placeholder.setContentId(current)
    }

}