package com.maxsch.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.maxsch.domain.usecase.GetAuthTokenUseCase
import com.maxsch.presentation.routing.Destinations
import com.maxsch.presentation.routing.Router

class MainViewModel(
    private val router: Router,
    private val getAuthTokenUseCase: GetAuthTokenUseCase
) : ViewModel() {

    fun checkToken() {
        if (getAuthTokenUseCase() != null) {
            Log.e("asdf", "token != null")
            router.navigate(Destinations.LaunchList)
        }
    }
}