package com.example.pihut_android_animations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pihut_android_animations.R
import kotlinx.android.synthetic.main.menu_fragment.tvProperty
import kotlinx.android.synthetic.main.menu_fragment.tvSequence

class MenuFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSequence.setOnClickListener {
            goto(SequenceFragment())
        }

        tvProperty.setOnClickListener {
            goto(PropertyAnimatorFragment())
        }
    }

    private fun goto(fragment: Fragment){
        fragmentManager?.beginTransaction()!!
            .replace(R.id.flContainer, fragment)
            .addToBackStack(fragment::javaClass.name)
            .commitAllowingStateLoss()
    }
}