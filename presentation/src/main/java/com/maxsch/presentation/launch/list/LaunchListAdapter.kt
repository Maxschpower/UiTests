package com.maxsch.presentation.launch.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxsch.domain.entity.Launch
import com.maxsch.presentation.R

class LaunchListAdapter(
    private val clickListener: (item: Launch) -> Unit
) : RecyclerView.Adapter<LaunchItemViewHolder>() {

    private val items = mutableListOf<Launch?>()

    fun bindItems(launches: List<Launch?>) {
        items.clear()
        items.addAll(launches)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchItemViewHolder =
        LaunchItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.launch_list_item, parent, false),
            clickListener
        )

    override fun onBindViewHolder(holder: LaunchItemViewHolder, position: Int) {
        val item = items[position]
        item?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = items.size
}