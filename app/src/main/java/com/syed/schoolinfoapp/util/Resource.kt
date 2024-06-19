package com.syed.schoolinfoapp.util

sealed class Resource<T>(val data: T?, val message: String?) {
    class Success<T>(data: T?, message: String? = null) : Resource<T>(data, null)
    class Error<T>(data: T? = null, message: String?) : Resource<T>(null, message)
    class Loading<T>(val isLoading: Boolean) : Resource<T>(null, null)
}