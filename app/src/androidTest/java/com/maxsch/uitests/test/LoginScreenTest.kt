package com.maxsch.uitests.test

import android.content.Context
import android.content.SharedPreferences
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.R
import com.maxsch.uitests.screen.LaunchListScreen
import com.maxsch.uitests.screen.LoginScreen
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.KoinComponent

class LoginScreenTest : TestCase(), KoinComponent {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun positiveLoginTest() {
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
            step("enter mail") {
                LoginScreen {
                    loginEditText {
                        typeText("tnnbbpe@gmail.com")
                    }

                    closeSoftKeyboard()
                }
            }

            step("login") {
                LoginScreen {
                    loginButton {
                        click()
                    }
                }

                LaunchListScreen {
                    recycler {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun wrongEmailInputErrorTest() {
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
            step("enter mail") {
                LoginScreen {
                    loginEditText {
                        typeText("tnnbbpe")
                    }

                    closeSoftKeyboard()

                    loginButton {
                        click()
                    }
                }
            }

            step("check error") {
                LoginScreen {
                    loginInputLayout {
                        hasError(R.string.login_error)
                    }
                }
            }
        }
    }
}