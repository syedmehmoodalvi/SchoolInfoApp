package com.syed.schoolinfoapp.domain.repository

import com.syed.schoolinfoapp.data.model.ApiResponse
import com.syed.schoolinfoapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface SchoolInfoRepository {
    suspend fun getInfo(): Flow<Resource<ApiResponse>>
}