package com.maxsch.uitests.scenario

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.maxsch.uitests.screen.LaunchListScreen

class OpenLaunchDetailsScreenScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
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
    }
}