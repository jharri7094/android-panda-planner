package edu.towson.cosc435.maddox.pandaplanner.ui.screens.login

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(app : Application, private val repo : EventsRepository) : AndroidViewModel(app) {

    private val _validating : MutableState<Boolean> = mutableStateOf(false)

    private val _username = mutableStateOf("")
    val username = _username

    private val _password = mutableStateOf("")
    val password = _password

    private val _userId : MutableState<Long?> = mutableStateOf(null)
    val userId = _userId

    private val _navigate = mutableStateOf(false)
    val navigate = _navigate

    private val _showValidationText = mutableStateOf(false)
    val showValidationText = _showValidationText

    fun toggleNavigate(){
        _navigate.value = !_navigate.value
    }

    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    fun setShowValidationText(b : Boolean){
        _showValidationText.value = b
    }

    fun validate(){
        _validating.value = true

        viewModelScope.launch(Dispatchers.Main){
            fetchUserId()
            if (_userId.value != null) {
                _validating.value = false
                _showValidationText.value = false
                _navigate.value = true
            } else {
                _validating.value = false
                _showValidationText.value = true
            }
        }
    }

    private suspend fun fetchUserId(){
        _userId.value =
            withContext(viewModelScope.coroutineContext + Dispatchers.IO)
            {
                repo.getUserId(
                    username = username.value,
                    password = password.value
                )
            }
    }
}