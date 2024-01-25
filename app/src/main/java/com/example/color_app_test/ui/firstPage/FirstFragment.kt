package com.example.color_app_test.ui.firstPage

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.color_app_test.common.base.BaseFragment
import com.example.color_app_test.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    private val viewModel: FirstFragmentVM by viewModels()

    private val colorsAdapter: ColorsAdapter by lazy {
        ColorsAdapter()
    } // Todo by lazy  რა განსხვავებაა lateinit-თან
    // lateinit ის გამოყენების დროს ფროფერთ უკვე ინიციალიზებული უნდა იყოს მანამ მივწვდებით,
    // ხოლო ლეიზის შემთხვევაში, პროპერთის ინიციალიზაცია ხდება მხოლოდ ერთხელ იმ მომენტში როცა პროპერთის გამოძახება მოხდება

    override fun started() {
        setUpViews()
    }

    override fun listeners() {

        colorsAdapter.onItemClicked = {
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    it
                )
            )
        }

    }

    private fun setUpViews() {
        with(binding) {
            rvColorCards.adapter = colorsAdapter
        }
    }

    override fun observer() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.getColors()

                viewModel.getColorsState.collect {
                    // Todo ეკრანის გადმოტრიალებისას შემოდის ბევრჯერ ამ ადგილას
                    val data = it.data
                    colorsAdapter.submitList(data)
                }
            }
        }

    }

}