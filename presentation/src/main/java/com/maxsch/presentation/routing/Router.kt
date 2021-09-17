package com.maxsch.presentation.routing

import android.os.Bundle

interface Router {
    fun navigate(destination: DestinationWrapper, arguments: Bundle? = null)
}