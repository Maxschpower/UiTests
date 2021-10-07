package com.maxsch.uitests.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.BaseTestCase
import com.maxsch.uitests.scenario.OpenLaunchScreenScenario
import com.maxsch.uitests.screen.LaunchDetailsScreen
import com.maxsch.uitests.screen.LaunchListScreen
import org.junit.Rule
import org.junit.Test


class LaunchListScreenTest : BaseTestCase() {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun screenTest() {
        before {


        }.after {
            testsHelper.clearAuthToken()

        }.run {
            step("open launch list screen") {
                scenario(OpenLaunchScreenScenario())
            }

            step("check recyclerview is visible") {
                LaunchListScreen {
                    recycler {
                        childAt<LaunchListScreen.Item>(0) {
                            description {
                                hasTitle("Starlink-15 (v1.0)")
                                hasDescription("CCAFS SLC 40")
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun recyclerItemsIsClickableTest() {
        before {


        }.after {
            testsHelper.clearAuthToken()

        }.run {
            step("open launch list screen") {
                scenario(OpenLaunchScreenScenario())
            }

            step("click on recyclerview item") {
                LaunchListScreen {
                    recycler {
                        childAt<LaunchListScreen.Item>(1) {
                            click()
                        }
                    }
                }
            }

            step("launch details opened") {
                LaunchDetailsScreen {
                    bookButton {
                        isVisible()
                    }
                }
            }
        }
    }
}