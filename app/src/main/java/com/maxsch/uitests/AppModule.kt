package com.maxsch.uitests

import org.koin.dsl.module

val appModule = module {
    single {
        TestsHelper(get())
    }
}