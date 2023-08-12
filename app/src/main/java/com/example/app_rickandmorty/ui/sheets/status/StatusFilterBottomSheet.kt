package com.example.app_rickandmorty.ui.sheets.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_rickandmorty.databinding.StatusFilterFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StatusFilterBottomSheet : BottomSheetDialogFragment() {

    private lateinit var _binding: StatusFilterFragmentBinding

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
        _binding = StatusFilterFragmentBinding.inflate(inflater, container, false)
        _binding.apply {
            statusFilterList.layoutManager = LinearLayoutManager(context)
            statusFilterList.adapter = StatusFilterAdapter(list, secondList)
        }

        return _binding.root
    }

    companion object {
        private const val EXTRA_LIST = "EXTRA_LIST"
        private const val EXTRA_SECOND_LIST = "EXTRA_SECOND_LIST"

        /**
         * Create a new instance of the status filter bottom sheet.
         * @return The new instance.
         */
        fun newInstance(
            listOfStatus: List<String>,
            listOfStatusDescription: List<String>
        ) : StatusFilterBottomSheet =
            StatusFilterBottomSheet().apply {
                arguments = Bundle().apply {
                   putStringArrayList(EXTRA_LIST, ArrayList(listOfStatus))
                   putStringArrayList(EXTRA_SECOND_LIST, ArrayList(listOfStatusDescription))
                }
            }
    }
}
