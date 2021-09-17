package com.maxsch.presentation.launch.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.maxsch.presentation.R
import kotlinx.android.synthetic.main.fragment_launch_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchListFragment : Fragment(R.layout.fragment_launch_list) {

    private val viewModel by viewModel<LaunchListViewModel>()
    private val adapter = LaunchListAdapter {
        viewModel.goToLaunchSite(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchList.adapter = adapter
        viewModel.launches.observe(viewLifecycleOwner) {
            adapter.bindItems(it.launches)
        }
    }
}