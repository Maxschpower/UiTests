package com.maxsch.uitests

import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseTestCase : TestCase(), KoinComponent {

    val testsHelper: TestsHelper by inject()
}