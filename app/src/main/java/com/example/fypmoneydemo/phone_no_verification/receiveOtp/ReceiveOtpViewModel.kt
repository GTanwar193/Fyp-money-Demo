package com.example.fypmoneydemo.phone_no_verification.receiveOtp

import androidx.lifecycle.ViewModel
import com.example.fypmoneydemo.base.SingleLiveEvent

/**
 * Created by Gaurav Kumar Tanwar on 06,June,2021
 * Noiad, U.P.
 * India
 */
class ReceiveOtpViewModel : ViewModel() {

    val VerifyOtpClickEvent = SingleLiveEvent<Void>()

    val ResendOtpClickEvent = SingleLiveEvent<Void>()

    fun VerifyOtpClicked() {
        VerifyOtpClickEvent.call()
    }

    fun ResendOtpClicked(){
        ResendOtpClickEvent.call()
    }

}