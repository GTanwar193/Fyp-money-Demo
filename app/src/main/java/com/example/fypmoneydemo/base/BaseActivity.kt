package com.example.fypmoneydemo.base

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * Created by Gaurav Kumar Tanwar on 06,June,2021
 * Noiad, U.P.
 * India
 */
abstract class BaseActivity: AppCompatActivity() {

    fun showToast(message: String)= Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun isValidMobile(phone: String?) =
        (phone.isNullOrBlank() || phone.length != 10).not() && Patterns.PHONE.matcher(
            phone
        ).matches()
}