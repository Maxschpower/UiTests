package com.maxsch.presentation.launch.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.maxsch.domain.entity.Launch
import com.maxsch.presentation.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.launch_list_item.view.*

class LaunchItemViewHolder(
    override val containerView: View,
    private val clickListener: (item: Launch) -> Unit
) : LayoutContainer, RecyclerView.ViewHolder(containerView) {

    fun bind(item: Launch) {
        with(containerView) {
            launchDescriptionView.setTitle(item.mission?.name)
            launchDescriptionView.setDescription(item.site)
            missionPatch.load(R.drawable.ic_placeholder) {
                placeholder(R.drawable.ic_placeholder)
            }
            setOnClickListener {
                clickListener(item)
            }
        }
    }
}