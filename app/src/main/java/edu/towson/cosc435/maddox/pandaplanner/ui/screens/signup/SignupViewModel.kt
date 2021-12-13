package edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupViewModel(app : Application,private val repo : EventsRepository) : AndroidViewModel(app){

    private val _username = mutableStateOf("")
    val username = _username

    private val _password = mutableStateOf("")
    val password = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword = _confirmPassword

    private val _showMatchValidationText = mutableStateOf(false)
    val showMatchValidationText = _showMatchValidationText

    private val _showCopyValidationText = mutableStateOf(false)
    val showCopyValidationText = _showCopyValidationText

    private val _showEmptyFieldsValidationText = mutableStateOf(false)
    val showEmptyFieldsValidationText = _showCopyValidationText

    private val _valid = mutableStateOf(false)
    val valid = _valid

    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    fun setConfirmPassword(s : String){
        _confirmPassword.value = s
    }

    fun validate(){
        checkForPasswordMatch()
        checkForEmptyFields()
        viewModelScope.launch{
            checkForExistingUsers()
            if (!_showCopyValidationText.value && !_showMatchValidationText.value && !_showEmptyFieldsValidationText.value)
            {
                viewModelScope.launch(Dispatchers.Main ) {
                    _valid.value = true
                }
                repo.insertNewUser(User(username = _username.value, password = _password.value))
            }
            else
            {
                viewModelScope.launch(Dispatchers.Main)
                {
                    _valid.value = false
                }
            }
        }
    }

    private fun checkForEmptyFields() {
        _showEmptyFieldsValidationText.value = _confirmPassword.value == "" || _password.value == "" || _username.value == ""
    }

    fun checkForPasswordMatch(){
        _showMatchValidationText.value = _confirmPassword.value != _password.value
    }

    fun clearErrors(){
        _showMatchValidationText.value = false
        _showCopyValidationText.value = false
        _showEmptyFieldsValidationText.value = false
    }

    private suspend fun checkForExistingUsers(){
        val userId : Long?
        withContext(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            userId = repo.getUserId(username = _username.value, password = _password.value)
            _showCopyValidationText.value = userId != null
        }
    }

    fun toggleValid()
    {
        _valid.value = !_valid.value
    }

    fun clearFields()
    {
        _username.value = ""
        _password.value = ""
        _confirmPassword.value = ""
    }
}