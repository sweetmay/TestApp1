package com.sweetmay.testapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sweetmay.testapp.view.ui.viewmodel.SharedViewModel

abstract class BaseFragment() : Fragment() {

    abstract val layoutRes: Int?

    val viewModel: SharedViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutRes?.let { inflater.inflate(it, container, false) }
    }
}