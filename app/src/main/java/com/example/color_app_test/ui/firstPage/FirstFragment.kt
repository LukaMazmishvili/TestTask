package com.example.color_app_test.ui.firstPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.color_app_test.R
import com.example.color_app_test.common.base.BaseFragment
import com.example.color_app_test.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    private val viewModel: FirstFragmentVM by viewModels()

    private val colorsAdapter: ColorsAdapter by lazy {
        ColorsAdapter()
    }

    override fun started() {
        setUpViews()
    }

    override fun listeners() {

        colorsAdapter.onItemClicked = {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it))
        }

    }

    private fun setUpViews() {
        with(binding) {
            rvColorCards.adapter = colorsAdapter
        }
    }

    override fun observer() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getColors()

                viewModel.getColorsState.collect {
                    val data = it.data
                    colorsAdapter.submitList(data)
                }
            }
        }

    }

}