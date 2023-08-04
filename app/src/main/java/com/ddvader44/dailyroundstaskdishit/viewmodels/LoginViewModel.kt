package com.ddvader44.dailyroundstaskdishit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.ddvader44.dailyroundstaskdishit.data.LoginRepository
import com.ddvader44.dailyroundstaskdishit.data.Result

import com.ddvader44.dailyroundstaskdishit.R
import com.ddvader44.dailyroundstaskdishit.ui.login.LoggedInUserView
import com.ddvader44.dailyroundstaskdishit.ui.login.LoginFormState
import com.ddvader44.dailyroundstaskdishit.ui.login.LoginResult

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun logout() {
        loginRepository.logout()
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean {
        // Name should not be empty and should contain only letters and spaces
        val regex = Regex("^[a-zA-Z ]+\$")
        return username.matches(regex)
    }

    private fun isPasswordValid(password: String): Boolean {
        // Password should have at least 8 characters with at least one number, one special character, one lowercase letter, and one uppercase letter.
        val regex = Regex("^(?=.*[0-9])(?=.*[!@#\$%&()])(?=.*[a-z])(?=.*[A-Z]).{8,}\$")
        return password.matches(regex)
    }
}