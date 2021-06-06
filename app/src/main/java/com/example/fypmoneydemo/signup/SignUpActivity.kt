package com.example.fypmoneydemo.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.fypmoneydemo.R
import com.example.fypmoneydemo.base.BaseActivity
import com.example.fypmoneydemo.databinding.ActivitySignUpBinding
import com.example.fypmoneydemo.phone_no_verification.sendOtp.SendOtpActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior


class SignUpActivity : BaseActivity() {

    var signUpViewModel: SignUpViewModel? = null
    var binding: ActivitySignUpBinding? = null
    var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>? = null
    var isLoginClick: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        binding?.signUpViewModel = signUpViewModel

        EventObserver()


    }

    override fun onResume() {
        super.onResume()
        isLoginClick = false
        initComponent()
        fadeInAnim()
    }

    private fun initComponent() {
        // get the bottom sheet view
        var llBottomSheet: FrameLayout = binding!!.sheet

        // init the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet).apply {
            peekHeight = 300
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        // set callback for changes
        bottomSheetBehavior?.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        if (isLoginClick == false)
                            fadeInAnim()
                        else {
                        }
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        fadeOutAnim()
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    else -> {
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    private fun EventObserver() {

        signUpViewModel!!.CreateAccountClickEvent.observe(this, {
            isLoginClick = true
            bottomSheetBehavior?.apply {
                peekHeight = 20
                this.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            startActivity(Intent(this, SendOtpActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.slide_out_bottom)
        })

        signUpViewModel!!.loginClickEvent.observe(this,{
            showToast("Clicked"+getString(R.string.login))
        })

    }

    fun fadeOutAnim() {
        binding?.infoText?.text = getString(R.string.welcome_to)
        val animFadeIn: Animation =
            AnimationUtils.loadAnimation(applicationContext, R.anim.fade_out)
        binding?.constLayout?.startAnimation(animFadeIn)
        binding?.constLayout?.visibility = View.GONE
    }

    fun fadeInAnim() {
        binding?.infoText?.text = getString(R.string.slide_up_to_cont)
        val animFadeIn: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        binding?.constLayout?.startAnimation(animFadeIn)
        binding?.constLayout?.visibility = View.VISIBLE
    }



}