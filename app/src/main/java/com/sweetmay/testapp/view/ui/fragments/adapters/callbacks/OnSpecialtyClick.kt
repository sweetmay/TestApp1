package com.sweetmay.testapp.view.ui.fragments.adapters.callbacks

import com.sweetmay.testapp.model.retrofit.Specialty

interface OnSpecialtyClick {
    fun onClick(specialty: Specialty)
}