package com.maxsch.presentation.di

import com.maxsch.presentation.launch.details.LaunchDetailsViewModel
import com.maxsch.presentation.launch.list.LaunchListViewModel
import com.maxsch.presentation.login.LoginViewModel
import com.maxsch.presentation.main.MainViewModel
import com.maxsch.presentation.routing.NavigationHolder
import com.maxsch.presentation.routing.Router
import com.maxsch.presentation.routing.RouterImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

val presentationModule = module {
    single<NavigationHolder>()
    single<Router> {
        RouterImpl(get())
    }
    viewModel<LoginViewModel>()
    viewModel<MainViewModel>()
    viewModel<LaunchListViewModel>()
    viewModel { parameters ->
        LaunchDetailsViewModel(get(), get(), parameters.get(), get())
    }
}