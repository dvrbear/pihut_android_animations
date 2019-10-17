package com.example.pihut_android_animations.sequence

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pihut_android_animations.R
import kotlinx.android.synthetic.main.sequence_fragment.*

class SequenceFragment: Fragment(){

    private var isPlaying = false
    private lateinit var animation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sequence_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animation = ivFrog.drawable as AnimationDrawable

        tvControl.setOnClickListener {
            switchState()
        }
    }

    private fun switchState(){
        isPlaying = !isPlaying
        if(isPlaying){
            tvControl.text = getString(R.string.stop)
            animation.start()
        }
        else{
            tvControl.text = getString(R.string.start)
            animation.stop()
        }
    }

}