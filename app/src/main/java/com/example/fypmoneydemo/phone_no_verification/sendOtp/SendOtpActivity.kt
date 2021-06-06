package com.example.fypmoneydemo.phone_no_verification.sendOtp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.fypmoneydemo.R
import com.example.fypmoneydemo.base.BaseActivity
import com.example.fypmoneydemo.databinding.ActivityPhoneNoVerificationActivityBinding
import com.example.fypmoneydemo.phone_no_verification.receiveOtp.ReceiveOtpActivity

class SendOtpActivity : BaseActivity() {

    var binding: ActivityPhoneNoVerificationActivityBinding? = null

    var sendOtpViewModel: SendOtpViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_phone_no_verification_activity)
        sendOtpViewModel = ViewModelProviders.of(this).get(SendOtpViewModel::class.java)
        binding?.sendOtpViewModel = sendOtpViewModel

        EventObserver()

    }

    private fun validateDataOtp(): Boolean {
        return when {
            TextUtils.isEmpty(binding?.etMobile?.text.toString()) -> {
                showToast("Please enter mobile number")
                binding?.etMobile?.setError("Please enter mobile number")
                false
            }
            !isValidMobile(binding?.etMobile?.text.toString())!! -> {
                showToast("Enter valid mobile number")
                binding?.etMobile?.setError("Enter valid mobile number")
                false
            }
            else -> true
        }
    }

    private fun EventObserver(){

        sendOtpViewModel!!.GetOtpClickEvent.observe(this, {
            if (validateDataOtp()) {
                showToast("OTP Genrated")
                startActivity(Intent(this, ReceiveOtpActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.slide_up_from)
            }
        })

    }


}