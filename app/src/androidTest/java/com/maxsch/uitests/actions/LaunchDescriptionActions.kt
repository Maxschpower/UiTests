package com.maxsch.uitests.actions

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import com.maxsch.presentation.launch.list.LaunchDescriptionView
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.hamcrest.Matcher

interface LaunchDescriptionActions : BaseActions {

    fun setDescription(text: String) {
        view.perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> =
                isAssignableFrom(LaunchDescriptionView::class.java)

            override fun getDescription(): String =
                "setting description for LaunchDescriptionView $text"

            override fun perform(uiController: UiController?, view: View?) {
                if (view is LaunchDescriptionView) view.setDescription(text)
            }
        })
    }

    fun setTitle(text: String) {
        view.perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> =
                isAssignableFrom(LaunchDescriptionView::class.java)

            override fun getDescription(): String =
                "setting title for LaunchDescriptionView $text"

            override fun perform(uiController: UiController?, view: View?) {
                if (view is LaunchDescriptionView) view.setTitle(text)
            }
        })
    }
}