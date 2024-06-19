package com.syed.schoolinfoapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syed.schoolinfoapp.data.model.ApiResponse
import com.syed.schoolinfoapp.domain.usecase.GetSchoolInfoUseCase
import com.syed.schoolinfoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolInfoViewModel @Inject constructor(
    private val useCase: GetSchoolInfoUseCase
) : ViewModel() {
    private var _schoolInfo: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()
    val schoolInfo: LiveData<Resource<ApiResponse>> = _schoolInfo

    init {
        getInfo()
    }

    private fun getInfo() = viewModelScope.launch {
        useCase.getInfo().collect() {
            _schoolInfo.postValue(it)
        }
    }
}