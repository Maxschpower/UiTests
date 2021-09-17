package com.maxsch.presentation.launch.list

import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.maxsch.domain.entity.Launch
import com.maxsch.domain.entity.Launches
import com.maxsch.domain.usecase.GetLaunchesUseCase
import com.maxsch.presentation.BaseViewModel
import com.maxsch.presentation.launch.details.LaunchDetailsFragment
import com.maxsch.presentation.routing.Destinations
import com.maxsch.presentation.routing.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LaunchListViewModel(
    getLaunchesUseCase: GetLaunchesUseCase,
    private val router: Router
) : BaseViewModel() {

    val launches = MutableLiveData<Launches>()

    init {
        getLaunchesUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { launchList: Launches ->
                launches.value = launchList
            }
            .untilDestroy()
    }

    fun goToLaunchSite(launch: Launch) {
        router.navigate(
            Destinations.LaunchDetails,
            bundleOf(LaunchDetailsFragment.LAUNCH_ID_KEY to launch.id)
        )
    }
}