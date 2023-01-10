package com.sabekur2017.androidtddexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.sabekur2017.androidtddexample.R
import com.sabekur2017.androidtddexample.base.BaseFragment
import com.sabekur2017.androidtddexample.databinding.FragmentAddSpendBinding
import com.sabekur2017.androidtddexample.utils.Validator
import com.sabekur2017.androidtddexample.utils.enabled


class AddSpendFragment : BaseFragment(R.layout.fragment_add_spend) {
    private lateinit var binding: FragmentAddSpendBinding
    private var amount: Int = 0
    private var description: String = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddSpendBinding.bind(view)
        setupListener()

    }

    private fun setupListener() {
        binding.etAmount.addTextChangedListener {
            amount = it?.toString()?.trim()?.toIntOrNull() ?: 0
            binding.btnAddAmount.enabled(Validator.validateInput(amount, description))
        }
        binding.etDescripton.addTextChangedListener {
            description = it?.toString()?.trim() ?: ""
            binding.btnAddAmount.enabled(Validator.validateInput(amount, description))
        }

        binding.btnAddAmount.setOnClickListener {
            addSpend()
        }
    }

    private fun addSpend() {
        viewModel.addSpend(amount, description)
        findNavController().navigateUp()
    }
}