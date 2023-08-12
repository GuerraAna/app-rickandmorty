package com.example.app_rickandmorty.ui.sheets.gender

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_rickandmorty.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class GenderFilterBottomSheet : BottomSheetDialogFragment() {

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