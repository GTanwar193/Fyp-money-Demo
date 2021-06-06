package com.example.fypmoneydemo.phone_no_verification.receiveOtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.fypmoneydemo.R
import com.example.fypmoneydemo.base.BaseActivity
import com.example.fypmoneydemo.databinding.ActivityPhoneNoVerificationActivityBinding
import com.example.fypmoneydemo.databinding.ActivityReceiveOtpBinding
import com.example.fypmoneydemo.phone_no_verification.sendOtp.SendOtpViewModel
import com.example.fypmoneydemo.phone_no_verification.verification_success.VerificationSuccessActivity

class ReceiveOtpActivity : BaseActivity() {

    var binding: ActivityReceiveOtpBinding? = null

    var receiveOtpViewModel: ReceiveOtpViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_otp)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_receive_otp)
        receiveOtpViewModel = ViewModelProviders.of(this).get(ReceiveOtpViewModel::class.java)
        binding?.recivedOtpViewModel = receiveOtpViewModel

        onEvenetClcik()


    }

    fun onEvenetClcik(){

        receiveOtpViewModel!!.VerifyOtpClickEvent.observe(this, {
            showToast("OTP Verified successfully")
            startActivity(Intent(this, VerificationSuccessActivity::class.java))
            overridePendingTransition(R.anim.slide_down_from, R.anim.fade_out)
        })

        receiveOtpViewModel!!.ResendOtpClickEvent.observe(this,{
            showToast("Clicked"+getString(R.string.resent))
        })

    }


}