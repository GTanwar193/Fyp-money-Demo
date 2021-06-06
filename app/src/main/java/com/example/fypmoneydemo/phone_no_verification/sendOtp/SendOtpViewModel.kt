package com.example.fypmoneydemo.phone_no_verification.sendOtp

import androidx.lifecycle.ViewModel
import com.example.fypmoneydemo.base.SingleLiveEvent

/**
 * Created by Gaurav Kumar Tanwar on 06,June,2021
 * Noiad, U.P.
 * India
 */
class SendOtpViewModel : ViewModel() {

    val GetOtpClickEvent = SingleLiveEvent<Void>()

    fun GetOtpClicked() {
        GetOtpClickEvent.call()
    }

}