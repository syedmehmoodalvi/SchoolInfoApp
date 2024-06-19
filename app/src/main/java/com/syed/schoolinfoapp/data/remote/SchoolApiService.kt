package com.syed.schoolinfoapp.data.remote

import com.syed.schoolinfoapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface SchoolApiService {
    @GET(END_POINT)
    suspend fun getInfo(): Response<ApiResponse>
    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/"
        const val END_POINT = "resource/s3k6-pzi2.json"
    }
}