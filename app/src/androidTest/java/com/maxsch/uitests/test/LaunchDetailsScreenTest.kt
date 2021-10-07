package com.maxsch.uitests.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.BaseTestCase
import com.maxsch.uitests.scenario.OpenLaunchDetailsScreenScenario
import com.maxsch.uitests.screen.LaunchDetailsScreen
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.KoinComponent

class LaunchDetailsScreenTest : BaseTestCase(), KoinComponent {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun screenTest() {
        before {


        }.after {
            testsHelper.clearAuthToken()

        }.run {
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
        before {


        }.after {
            testsHelper.clearAuthToken()

        }.run {
            step("open launch details screen") {
                scenario(OpenLaunchDetailsScreenScenario())
            }

            step("click on book trip button") {
                LaunchDetailsScreen {
                    bookButton {
                        hasText("Записаться на полет")
                        click()
                    }
                }
            }

            step("check book button name changed to cancel") {
                LaunchDetailsScreen {
                    bookButton {
                        hasText("Отменить полет")
                    }
                }
            }
        }
    }
}