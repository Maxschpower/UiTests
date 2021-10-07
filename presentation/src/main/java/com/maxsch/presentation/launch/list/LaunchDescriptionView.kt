package com.maxsch.presentation.launch.list

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.maxsch.presentation.R
import kotlinx.android.synthetic.main.launch_description_view.view.*

class LaunchDescriptionView(
    context: Context,
    attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

    init {
        inflate(context, R.layout.launch_description_view, this)
    }

    fun setDescription(text: CharSequence?) {
        launchDescription?.text = text
    }

    fun setTitle(text: CharSequence?) {
        launchTitle?.text = text
    }
}