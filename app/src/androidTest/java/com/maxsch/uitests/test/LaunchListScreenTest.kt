package com.maxsch.uitests.test

import android.content.Context
import android.content.SharedPreferences
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.scenario.OpenLaunchScreenScenario
import com.maxsch.uitests.screen.LaunchDetailsScreen
import com.maxsch.uitests.screen.LaunchListScreen
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.KoinComponent


class LaunchListScreenTest : TestCase(), KoinComponent {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun screenTest() {
        before {

        }.after {
            activityTestRule.scenario.onActivity {
                val prefs: SharedPreferences =
                    it.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.clear()
                editor.commit()
            }
        }.run {
            step("open launch list screen") {
                scenario(OpenLaunchScreenScenario())
            }

            step("check recyclerview is visible") {
                LaunchListScreen {
                    recycler {
                        childAt<LaunchListScreen.Item>(0) {
                            description {
                                hasTitle("first mission")
                                hasDescription("first site")
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
            activityTestRule.scenario.onActivity {
                val prefs: SharedPreferences =
                    it.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.clear()
                editor.commit()
            }
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