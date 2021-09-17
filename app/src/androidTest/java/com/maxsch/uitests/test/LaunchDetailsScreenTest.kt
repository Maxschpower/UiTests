package com.maxsch.uitests.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.scenario.OpenLaunchDetailsScreenScenario
import com.maxsch.uitests.screen.LaunchDetailsScreen
import org.junit.Rule
import org.junit.Test

class LaunchDetailsScreenTest : TestCase() {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun screenTest() {
        run {
            step("open launch details screen") {
                scenario(OpenLaunchDetailsScreenScenario())
            }

            step("check screen elements is visible") {
                LaunchDetailsScreen {
                    missionPatch {
                        isVisible()
                    }

                    missionName {
                        isVisible()
                    }

                    rocketName {
                        isVisible()
                    }

                    site {
                        isVisible()
                    }

                    bookButton {
                        isVisible()
                    }
                }
            }
        }
    }

    @Test
    fun bookButtonTextTest() {
        run {
            step("open launch details screen") {
                scenario(OpenLaunchDetailsScreenScenario())
            }

            step("click on book trip button") {
                LaunchDetailsScreen {
                    bookButton {
                        hasText(R.string.book_now)
                        click()
                    }
                }
            }

            step("check book button name changed to cancel") {
                LaunchDetailsScreen {
                    bookButton {
                        hasText(R.string.cancel_booking)
                    }
                }
            }
        }
    }
}