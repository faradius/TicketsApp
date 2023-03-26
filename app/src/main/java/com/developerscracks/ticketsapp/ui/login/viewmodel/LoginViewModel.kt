package com.developerscracks.ticketsapp.ui.login.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.domain.use_cases.userAuth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {


    private var _loginResponse = MutableLiveData<Response<FirebaseUser>?>(null)
    val loginResponse: LiveData<Response<FirebaseUser>?> = _loginResponse

    private val currentUser = authUseCases.getCurrentUser()

    init {
        if (currentUser != null){
            _loginResponse.postValue(Response.Success(currentUser))
        }
    }


    fun login(email: String, password: String) = liveData(viewModelScope.coroutineContext) {

        val result = authUseCases.login(email, password)

        when (result) {
            Response.Loading -> {
                _loginResponse.value = Response.Loading
                emit(_loginResponse.value)
            }

            is Response.Success -> {
                _loginResponse.value = result
                emit(_loginResponse.value)
                Log.d("TAG", "login: Inicio Sesión correctamente")
            }

            is Response.Failure -> {
                emit(Response.Failure(result.exception))
                Log.e("TAG", result.exception?.message ?: "Error desconocido")
            }
        }
    }
}