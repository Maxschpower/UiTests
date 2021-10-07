package com.maxsch.uitests.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.maxsch.presentation.MainActivity
import com.maxsch.uitests.BaseTestCase
import com.maxsch.uitests.R
import com.maxsch.uitests.screen.LaunchListScreen
import com.maxsch.uitests.screen.LoginScreen
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.KoinComponent

class LoginScreenTest : BaseTestCase(), KoinComponent {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun positiveLoginTest() {
        before {


        }.after {
            testsHelper.clearAuthToken()

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
            testsHelper.clearAuthToken()

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