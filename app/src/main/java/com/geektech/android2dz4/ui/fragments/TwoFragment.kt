package com.geektech.android2dz4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.android2dz4.R
import com.geektech.android2dz4.databinding.FragmentTwoBinding
import com.geektech.android2dz4.model.NoteModel
import com.geektech.android2dz4.utils.App

class TwoFragment : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private var backgroundColor = "#1E1E1E"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendData()
        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        btnImage.setOnClickListener {
            findNavController().navigate(R.id.action_twoFragment_to_oneFragment)
        }
        btnBlack2.setOnClickListener {
            backgroundColor = "#1E1E1E"
        }
        btnFashionable.setOnClickListener {
            backgroundColor = "#EBE4C9"
        }
        btnBurgundy.setOnClickListener {
            backgroundColor = "#571818"
        }
    }

    private fun sendData() = with(binding) {
        btnMaterialOk.setOnClickListener {

            val line = etLine.text.toString()
            val number = tvNumber.text.toString()
            val time = etTime.text.toString()

            App.appDataBase?.noteDao()
                ?.insert(NoteModel(line, number, time, color = backgroundColor))


            findNavController().navigateUp()
        }
    }
}