package com.sweetmay.testapp.view.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sweetmay.testapp.R
import com.sweetmay.testapp.model.retrofit.Specialty
import com.sweetmay.testapp.view.ui.fragments.adapters.EmployeeAdapter
import com.sweetmay.testapp.view.ui.fragments.adapters.SpecialtiesAdapter
import com.sweetmay.testapp.view.ui.fragments.adapters.callbacks.OnSpecialtyClick
import kotlinx.android.synthetic.main.branch_fragment.*
import kotlinx.android.synthetic.main.employees_fragment.*

class BranchFragment() : BaseFragment(), OnSpecialtyClick {

    lateinit var adapterRV: SpecialtiesAdapter

    override val layoutRes: Int?
        get() = R.layout.branch_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterRV = SpecialtiesAdapter(R.layout.item_specialties, this)
        specilties_rv.layoutManager = LinearLayoutManager(context)
        specilties_rv.adapter = adapterRV
        viewModel.specialtyData.value?.let { adapterRV.data = it }
    }

    override fun onClick(specialty: Specialty) {
        viewModel.chooseSpecialty(specialty)
    }
}