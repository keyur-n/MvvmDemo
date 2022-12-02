package com.example.mvvmdemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.newtwork.ApiState
import com.example.mvvmdemo.viewmodel.MainViewModel
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.ui.adapter.MyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel>()
    //    val viewModel2 = ViewModelProvider(this)[MainViewModel::class.java]
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()
        initClickListener()
        initObserver()
    }
    private fun initUI() {
        binding.rvList.layoutManager= LinearLayoutManager(this)
    }
    private fun initClickListener() {
        binding.btLoadList.setOnClickListener {
            viewModel.callApiEntry()
        }
    }
    private fun initObserver() {
        viewModel.listEntry.observe(this) {
            binding.pbLoader.visibility = View.GONE
            when (it) {
                ApiState.Empty -> {

                }
                is ApiState.Failure -> {
                    Toast.makeText(this,it.message, Toast.LENGTH_LONG).show()
                }
                ApiState.Loading -> {
                    binding.pbLoader.visibility = View.VISIBLE
                }
                is ApiState.Success -> {
                    binding.rvList.adapter = MyRecyclerViewAdapter(it.list)
                }
            }
        }
    }
}