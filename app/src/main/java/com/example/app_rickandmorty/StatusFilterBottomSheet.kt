package com.example.app_rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.app_rickandmorty.databinding.StatusFilterFragmentBinding

class StatusFilterBottomSheet : DialogFragment() {

    private lateinit var _binding: StatusFilterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.status_filter_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: KEEP GOING HERE
        _binding = StatusFilterFragmentBinding.inflate(layoutInflater)
        val view = _binding.root


        setupGenderFilter()
    }

    private fun setupGenderFilter() {
//        private fun setupViewBinding() {
//            _binding = ActivityCharactersBinding.inflate(layoutInflater)
//            val view = _binding.root
//            setContentView(view)
//        }
    }

    companion object {

        /**
         * Create a new instance of the status filter bottom sheet.
         * @return The new instance.
         */
        fun newInstance() = StatusFilterBottomSheet()
    }
}