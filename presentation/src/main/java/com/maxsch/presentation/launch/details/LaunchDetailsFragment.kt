package com.maxsch.presentation.launch.details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import coil.load
import com.maxsch.presentation.R
import kotlinx.android.synthetic.main.fragment_launch_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class LaunchDetailsFragment : Fragment(R.layout.fragment_launch_details) {

    companion object {
        const val LAUNCH_ID_KEY = "launch_list_key"
    }

    private val viewModel: LaunchDetailsViewModel by viewModel {
        parametersOf(arguments?.get(LAUNCH_ID_KEY))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.launch.observe(viewLifecycleOwner) {
            site.text = it.site
            missionName.text = it.mission?.name
            rocketName.text = "\uD83D\uDE80 ${it.rocket?.name} ${it.rocket?.type}"
            missionPatch.load(it.mission?.missionPatch) {
                placeholder(R.drawable.ic_placeholder)
            }
            progressBar.isVisible = false
            content.isVisible = true
            if (it.isBooked) {
                bookButton.setOnClickListener { viewModel.cancelTrip() }
                bookButton.text = getString(R.string.cancel_booking)
                Toast.makeText(context, "You've booked the flight!", Toast.LENGTH_SHORT).show()
            } else {
                bookButton.setOnClickListener { viewModel.bookTrip() }
                bookButton.text = getString(R.string.book_now)
            }
        }
    }
}