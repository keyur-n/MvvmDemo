package com.example.mvvmdemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivitySharedDemoBinding
import com.example.mvvmdemo.ui.fragments.FirstFragment

class SharedDemoActivity:AppCompatActivity() {
    private lateinit var binding: ActivitySharedDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_shared_demo)
        initClickListener()
    }

    private fun initClickListener() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flShared, FirstFragment(), "NewFragmentTag")
        ft.addToBackStack(null)
        ft.commit()
    }
}