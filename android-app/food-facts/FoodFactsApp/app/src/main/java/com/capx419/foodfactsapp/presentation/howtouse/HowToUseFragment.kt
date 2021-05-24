package com.capx419.foodfactsapp.presentation.howtouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.capx419.foodfactsapp.databinding.DialogHowToFragmentBinding

class HowToUseFragment: DialogFragment() {

    private lateinit var howToFragmentBinding: DialogHowToFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        howToFragmentBinding = DialogHowToFragmentBinding.inflate(inflater, container, false)
        return howToFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        howToFragmentBinding.btnBack.setOnClickListener {
            dismiss()
        }
    }
}