package com.maxsch.uitests.view

import android.view.View
import androidx.test.espresso.DataInteraction
import com.maxsch.presentation.launch.list.LaunchDescriptionView
import com.maxsch.uitests.actions.LaunchDescriptionActions
import com.maxsch.uitests.assertions.LaunchDescriptionAssertions
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher

class KLaunchDescriptionView : KBaseView<KLaunchDescriptionView>, LaunchDescriptionAssertions {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(parent: Matcher<View>, function: ViewBuilder.() -> Unit) : super(parent, function)
    constructor(parent: DataInteraction, function: ViewBuilder.() -> Unit) : super(parent, function)
}