package com.syed.schoolinfoapp.di

import com.syed.schoolinfoapp.data.repository.SchoolInfoRepositoryImpl
import com.syed.schoolinfoapp.domain.repository.SchoolInfoRepository
import com.syed.schoolinfoapp.domain.usecase.GetSchoolInfoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindSchoolRepository(
        schoolInfoRepositoryImpl: SchoolInfoRepositoryImpl
    ): SchoolInfoRepository
}