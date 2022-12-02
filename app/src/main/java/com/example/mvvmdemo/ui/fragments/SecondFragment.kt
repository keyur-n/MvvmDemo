package com.example.mvvmdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.databinding.FragmentSharedSecondBinding
import com.example.mvvmdemo.viewmodel.SharedDemoViewModel

class SecondFragment : Fragment() {
    private lateinit var binding:FragmentSharedSecondBinding
    private val viewModel by viewModels<SharedDemoViewModel>()
//    val viewModel by lazy { ViewModelProvider(this)[SharedDemoViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentSharedSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.userName.observe(viewLifecycleOwner) {
            binding.tvUserName.text = it
        }

    }
}
