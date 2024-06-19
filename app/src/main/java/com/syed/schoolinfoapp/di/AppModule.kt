package com.syed.schoolinfoapp.di

import com.syed.schoolinfoapp.data.remote.SchoolApiService
import com.syed.schoolinfoapp.data.repository.SchoolInfoRepositoryImpl
import com.syed.schoolinfoapp.domain.repository.SchoolInfoRepository
import com.syed.schoolinfoapp.domain.usecase.GetSchoolInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSchoolApiService(): SchoolApiService {
        return Retrofit.Builder()
            .baseUrl(SchoolApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideUseCase(schoolInfoRepository: SchoolInfoRepository): GetSchoolInfoUseCase {
        return GetSchoolInfoUseCase(schoolInfoRepository)
    }
}