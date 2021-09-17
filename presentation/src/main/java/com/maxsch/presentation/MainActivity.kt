package com.maxsch.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.maxsch.presentation.main.MainViewModel
import com.maxsch.presentation.routing.NavigationHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val navigationHolder: NavigationHolder by inject()
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.navController = findNavController(R.id.nav_host_fragment_container)
        viewModel.checkToken()
    }

    override fun onDestroy() {
        navigationHolder.clearNavController()
        super.onDestroy()
    }
}