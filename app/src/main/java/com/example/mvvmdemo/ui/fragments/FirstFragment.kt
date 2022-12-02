package com.example.mvvmdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.FragmentSharedFirstBinding
import com.example.mvvmdemo.viewmodel.SharedDemoViewModel

class FirstFragment : Fragment() {
    private lateinit var binding:FragmentSharedFirstBinding
    private val viewModel by viewModels<SharedDemoViewModel>()
//    val viewModel by lazy { ViewModelProvider(this)[SharedDemoViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentSharedFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
    }

    private fun initClickListener() {
        binding.btNext.setOnClickListener {
            val userName=binding.etNext.text.toString()
            viewModel.userName.value=userName


            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(R.id.flShared, SecondFragment(), "NewFragmentTag")
            ft.addToBackStack(null)
            ft.commit()
        }
    }
}