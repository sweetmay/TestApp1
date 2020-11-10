package com.sweetmay.testapp.view.ui.fragments

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.sweetmay.testapp.R
import com.sweetmay.testapp.model.retrofit.Employee
import com.sweetmay.testapp.utils.DateFormatter
import com.sweetmay.testapp.utils.formatName
import kotlinx.android.synthetic.main.person_fragment.*

class PersonFragment() : BaseFragment() {

    override val layoutRes: Int?
        get() = R.layout.person_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = viewModel.personData.value
        fillData(person)
    }

    private fun fillData(person: Employee?) {
        name_person.text = person?.f_name?.let { formatName(it) + " " + formatName(person.l_name) }
        Glide.with(this).load(person?.avatr_url).error(R.drawable.ic_launcher_foreground).into(
                picture_person
        )
        if(!person?.birthday.isNullOrEmpty()){
            age_person.text = person?.birthday?.let { DateFormatter.getAgeByBirthday(it) }
            birthday_person.text = person?.birthday?.let { DateFormatter.getFormattedDate(it) }
            }else{
            age_person.text = "««"
            birthday_person.text = "««"
        }
        specialty_person.text = person?.specialtiesToString()
    }
}
