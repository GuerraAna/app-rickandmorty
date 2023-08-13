package com.example.app_rickandmorty.ui.characteresList.gender

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_rickandmorty.databinding.GenderFilterBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class GenderFilterBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: GenderFilterBottomSheetBinding

    private val list: List<String> by lazy {
        arguments?.getStringArrayList(EXTRA_LIST)?.toList() ?: emptyList()
    }

    private val secondList: List<String> by lazy {
        arguments?.getStringArrayList(EXTRA_SECOND_LIST)?.toList() ?: emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GenderFilterBottomSheetBinding.inflate(inflater, container, false)
        binding.apply {
            genderFilterList.layoutManager = LinearLayoutManager(context)
            genderFilterList.adapter = GenderFilterAdapter(list, secondList)
        }

        return binding.root
    }

    companion object {
        private const val EXTRA_LIST = "EXTRA_LIST"
        private const val EXTRA_SECOND_LIST = "EXTRA_SECOND_LIST"

        /**
         * Create a new instance of the status filter bottom sheet.
         * @return The new instance.
         */
        fun newInstance(
            listOfGender: List<String>,
            listOfGenderDescription: List<String>
        ) : GenderFilterBottomSheet =
            GenderFilterBottomSheet().apply {
                arguments = Bundle().apply {
                    putStringArrayList(EXTRA_LIST, ArrayList(listOfGender))
                    putStringArrayList(EXTRA_SECOND_LIST, ArrayList(listOfGenderDescription))
                }
            }
    }
}