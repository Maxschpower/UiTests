package com.maxsch.presentation.login

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.maxsch.presentation.R
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel by viewModel<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mailInput.doOnTextChanged { text, _, _, _ ->
            viewModel.email.value = text.toString()
            mailInputLayout.error = null
        }

        loginButton.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(mailInput.text.toString()).matches())
                viewModel.login()
            else
                mailInputLayout.error = getString(R.string.login_error)
        }
    }
}