package com.maxsch.uitests.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.maxsch.presentation.login.LoginFragment
import com.maxsch.uitests.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.text.KButton

object LoginScreen : KScreen<LoginScreen>() {

    override val layoutId: Int
        get() = R.layout.fragment_login

    override val viewClass: Class<*>
        get() = LoginFragment::class.java

    val loginEditText = KEditText {
        withId(R.id.mailInput)
    }

    val loginInputLayout = KTextInputLayout {
        withId(R.id.mailInputLayout)
    }

    val loginButton = KButton {
        withId(R.id.loginButton)
    }
}