package com.maxsch.uitests.view

import android.view.View
import com.maxsch.uitests.assertions.LaunchDescriptionAssertions
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher

class KLaunchDescriptionView(
    parent: Matcher<View>,
    function: ViewBuilder.() -> Unit
) : KBaseView<KLaunchDescriptionView>(parent, function), LaunchDescriptionAssertions