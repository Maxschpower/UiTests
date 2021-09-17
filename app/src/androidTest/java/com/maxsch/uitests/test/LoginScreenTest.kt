package com.maxsch.uitests.test

import androidx.test.espresso.action.CloseKeyboardAction
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.R
import com.maxsch.uitests.screen.LaunchListScreen
import com.maxsch.uitests.screen.LoginScreen
import org.junit.Rule
import org.junit.Test

class LoginScreenTest : TestCase() {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun positiveLoginTest() {
        run {
            step("enter mail") {
                LoginScreen {
                    loginEditText {
                        typeText("tnnbbpe@gmail.com")
                        act {
                            CloseKeyboardAction()
                        }
                    }
                }
            }

            step("login") {
                LoginScreen {
                    loginButton {
                        scrollTo()
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

        }.run {
            step("enter mail") {
                LoginScreen {
                    loginEditText {
                        typeText("tnnbbpe")
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