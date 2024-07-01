package com.example.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.task2.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding : FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding?.run {
            button.setOnClickListener{
                var text = inputText.text.toString().trim()
                when{
                    text.length == 0 -> {
                        Snackbar.make(root,  "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
                    }
                    else -> findNavController().navigate(resId = R.id.action_mainFragment_to_textOutputFragment,
                        args = TextOutputFragment.bundle(text))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}