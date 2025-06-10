package com.example.firestoreproject.core.models

sealed interface Loadable<T> {
    class Loading<T>: Loadable<T>
    data class Success<T>(val data: T?): Loadable<T>
    data class Error<T>(val error: String): Loadable<T>
}