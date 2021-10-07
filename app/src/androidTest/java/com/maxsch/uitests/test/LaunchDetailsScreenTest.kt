package com.maxsch.uitests.test

import android.content.Context
import android.content.SharedPreferences
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.maxsch.data.datasource.AuthTokenDataSource
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.scenario.OpenLaunchDetailsScreenScenario
import com.maxsch.uitests.screen.LaunchDetailsScreen
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchDetailsScreenTest : TestCase(), KoinComponent {

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
            activityTestRule.scenario.onActivity {
                val prefs: SharedPreferences =
                    it.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.clear()
                editor.commit()
            }
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