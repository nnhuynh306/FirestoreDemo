package com.example.firestoreproject.features.home

import androidx.lifecycle.ViewModel
import com.example.firestoreproject.core.models.Loadable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(): ViewModel() {

}

data class HomeScreenState(
    val listFilter: Loadable<List<String>> = Loadable.Loading(),
    val listVideo: Loadable<List<String>> = Loadable.Loading()
)
