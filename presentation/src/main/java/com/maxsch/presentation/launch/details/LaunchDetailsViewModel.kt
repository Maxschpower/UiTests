package com.maxsch.presentation.launch.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.maxsch.domain.entity.Launch
import com.maxsch.domain.repository.LaunchRepository
import com.maxsch.domain.usecase.BookTripUseCase
import com.maxsch.domain.usecase.CancelTripUseCase
import com.maxsch.presentation.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LaunchDetailsViewModel(
    private val bookTripUseCase: BookTripUseCase,
    private val cancelTripUseCase: CancelTripUseCase,
    launchId: String,
    repository: LaunchRepository
) : BaseViewModel() {

    val launch = MutableLiveData<Launch>()

    init {
        repository.getLaunch(launchId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                launch.value = it
            }, {
                Log.e("asd", it.message.toString())
            })
            .untilDestroy()
    }

    fun bookTrip() {
        bookTripUseCase(launch.value!!.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                launch.value = launch.value?.copy(isBooked = true)
            }, {})
            .untilDestroy()
    }

    fun cancelTrip() {
        cancelTripUseCase(launch.value!!.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                launch.value = launch.value?.copy(isBooked = false)
            }, {})
            .untilDestroy()
    }
}