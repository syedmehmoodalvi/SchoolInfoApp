package com.syed.schoolinfoapp.data.repository

import com.syed.schoolinfoapp.data.model.ApiResponse
import com.syed.schoolinfoapp.data.remote.SchoolApiService
import com.syed.schoolinfoapp.domain.repository.SchoolInfoRepository
import com.syed.schoolinfoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SchoolInfoRepositoryImpl @Inject constructor(
    private val apiService: SchoolApiService
) : SchoolInfoRepository {
    override suspend fun getInfo(): Flow<Resource<ApiResponse>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            try {
                val response = apiService.getInfo()
                if (response.isSuccessful && response.body() != null) {
                    emit(Resource.Success(data = response.body()!!))
                } else {
                    emit(Resource.Error(message = response.message()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = e.message))
            }
        }
    }
}