package com.sweetmay.testapp.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sweetmay.testapp.R
import com.sweetmay.testapp.view.ui.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.requestData()

        observeLiveData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun observeLiveData() {
        viewModel.specialtyData.observe(this, {
            navController.navigate(R.id.branchFragment)
        })
        viewModel.employeesData.observe(this, {
            navController.navigate(R.id.employeesFragment)
        })
        viewModel.personData.observe(this, {
            navController.navigate(R.id.personFragment)
        })
    }
}