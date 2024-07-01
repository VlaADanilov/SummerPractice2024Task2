package com.example.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.task2.databinding.FragmentMainBinding
import com.example.task2.databinding.FragmentTextOutputBinding
import com.google.android.material.snackbar.Snackbar


class TextOutputFragment : Fragment(R.layout.fragment_text_output) {
    private var binding : FragmentTextOutputBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTextOutputBinding.bind(view)

        binding?.run {
            this.resultText.text = arguments?.getString(ARG_Text) ?: "Error"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_Text = "ARG_TEXT"

        fun bundle(text: String): Bundle = Bundle().apply {
            putString(ARG_Text, text)
        }
    }
}