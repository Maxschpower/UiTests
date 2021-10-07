package com.maxsch.uitests.assertions

import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

interface LaunchDescriptionAssertions : BaseAssertions {

    fun hasTitle(text: String) {
        view.check(
            ViewAssertions.matches(
                ViewMatchers.hasDescendant(
                    ViewMatchers.withText(text)
                )
            )
        )
    }

    fun hasDescription(text: String) {
        view.check(
            ViewAssertions.matches(
                ViewMatchers.hasDescendant(
                    ViewMatchers.withText(text)
                )
            )
        )
    }
}