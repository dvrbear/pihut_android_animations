package com.example.pihut_android_animations.fragments

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pihut_android_animations.R
import kotlinx.android.synthetic.main.layout_changes_fragment.llRoot
import kotlinx.android.synthetic.main.layout_changes_fragment.tvText
import kotlinx.android.synthetic.main.sequence_fragment.tvControl

class LayoutChangesFragment : Fragment() {

    private var isShort = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_changes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llRoot.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        tvControl.setOnClickListener {
            switchState()
        }
    }

    private fun switchState() {
        isShort = !isShort
        if (isShort) {
            tvText.text = getString(R.string.text_1)
        } else {
            tvText.text = getString(R.string.text_2)
        }
    }

}