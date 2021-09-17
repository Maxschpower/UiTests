package com.maxsch.presentation.routing

import android.os.Bundle

class RouterImpl(
    private val navigationHolder: NavigationHolder
) : Router {

    override fun navigate(destination: DestinationWrapper, arguments: Bundle?) {
        navigationHolder.navController?.navigate(destination.actionId, arguments)
    }
}