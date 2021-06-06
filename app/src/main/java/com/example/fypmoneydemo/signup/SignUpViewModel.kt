package com.example.fypmoneydemo.signup

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.fypmoneydemo.R
import com.example.fypmoneydemo.base.SingleLiveEvent

/**
 * Created by Gaurav Kumar Tanwar on 06,June,2021
 * Noiad, U.P.
 * India
 */
class SignUpViewModel :ViewModel() {

    val CreateAccountClickEvent = SingleLiveEvent<Void>()

    val loginClickEvent= SingleLiveEvent<Void>()

    fun CreateAccountClicked() {
        CreateAccountClickEvent.call()
    }

    fun LoginClicked(){
        loginClickEvent.call()
    }
}