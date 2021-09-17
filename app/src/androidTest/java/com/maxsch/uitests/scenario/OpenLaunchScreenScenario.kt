package com.maxsch.uitests.scenario

import androidx.test.espresso.action.CloseKeyboardAction
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.maxsch.uitests.screen.LoginScreen

class OpenLaunchScreenScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
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
        }
    }
}