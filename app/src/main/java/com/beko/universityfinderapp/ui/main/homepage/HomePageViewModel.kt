package com.beko.universityfinderapp.ui.main.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beko.universityfinderapp.model.University
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val homepageRepository: HomepageRepository
) : ViewModel(){
    private var _universityList = MutableLiveData<MutableList<University>>()
    val universityList : LiveData<MutableList<University>>
        get() = _universityList

    fun getUniversities(){
        CoroutineScope(Dispatchers.IO).launch {
            _universityList.postValue(homepageRepository.getUniversity())
        }
    }

}