package com.maxsch.presentation.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.maxsch.domain.scenario.LoginScenario
import com.maxsch.presentation.BaseViewModel
import com.maxsch.presentation.routing.Destinations
import com.maxsch.presentation.routing.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginViewModel(
    private val loginScenario: LoginScenario,
    private val router: Router
) : BaseViewModel() {

    val email = MutableLiveData<String>()

    fun login() {
        loginScenario(email.value.orEmpty())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                openLaunchList()
            }, {
                Log.e("asd", it.message.toString())
            })
            .untilDestroy()
    }

    private fun openLaunchList() {
        router.navigate(Destinations.LaunchList)
    }

}