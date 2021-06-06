package com.example.fypmoneydemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.fypmoneydemo.databinding.ActivityMainBinding
import com.example.fypmoneydemo.signup.SignUpActivity


class SplashScreen : AppCompatActivity() {

    var splashViewModel: SplashViewModel? = null
    var binding : ActivityMainBinding ?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        binding?.spashViewModel = splashViewModel


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SignUpActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }, 3000)

    }

}