package com.example.app_rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class GenderFilterBottomSheet : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.gender_filter_fragment, container, false)

    companion object {

        /**
         * Create a new instance of the status filter bottom sheet.
         * @return The new instance.
         */
        fun newInstance() = GenderFilterBottomSheet()
    }
}