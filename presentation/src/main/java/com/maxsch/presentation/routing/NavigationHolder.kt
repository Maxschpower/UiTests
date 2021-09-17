package com.maxsch.presentation.routing

import androidx.navigation.NavController

class NavigationHolder {

    var navController: NavController? = null

    fun clearNavController() {
        navController = null
    }
}