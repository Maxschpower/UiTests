package com.maxsch.presentation.routing

import com.maxsch.presentation.R

object Destinations {
    object LaunchList : DestinationWrapper {
        override val actionId: Int
            get() = R.id.action_loginFragment_to_launchListFragment
    }

    object LaunchDetails : DestinationWrapper {
        override val actionId: Int
            get() = R.id.action_launchListFragment_to_launchDetailsFragment
    }
}