package com.syed.schoolinfoapp.domain.usecase

import com.syed.schoolinfoapp.domain.repository.SchoolInfoRepository
import javax.inject.Inject

class GetSchoolInfoUseCase @Inject constructor(
    private val repository: SchoolInfoRepository
) {
    suspend fun getInfo() = repository.getInfo()
}