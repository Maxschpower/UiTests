package com.maxsch.uitests.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.maxsch.presentation.launch.details.LaunchDetailsFragment
import com.maxsch.uitests.R
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object LaunchDetailsScreen : KScreen<LaunchDetailsScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_launch_details
    override val viewClass: Class<*>
        get() = LaunchDetailsFragment::class.java

    val missionPatch = KImageView {
        withId(R.id.missionPatch)
    }

    val site = KTextView {
        withId(R.id.site)
    }

    val missionName = KTextView {
        withId(R.id.missionName)
    }

    val rocketName = KTextView {
        withId(R.id.rocketName)
    }

    val bookButton = KButton {
        withId(R.id.bookButton)
    }
}