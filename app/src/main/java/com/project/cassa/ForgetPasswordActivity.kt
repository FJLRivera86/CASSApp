package com.project.cassa

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.project.cassa.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : BaseActivity() {
    private var binding: ActivityForgetPasswordBinding? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

        binding?.btnForgotPasswordSubmit?.setOnClickListener { resetPassword() }


        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración a Firebase")
        analytics.logEvent("RecuperarContrasena", bundle)
    }

    private fun validateForm(email: String): Boolean {
        return when {
            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches()->{
                binding?.tilEmailForgetPassword?.error = "Ingresa un correo valido"
                false
            } else -> true
        }
    }

    private fun resetPassword(){
        val email = binding?.etForgotPasswordEmail?.text.toString()
        if(validateForm(email)){
            showProgressBar()
            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    hideProgressBar()
                    binding?.tilEmailForgetPassword?.visibility = View.GONE
                    binding?.tvSubmitMsg?.visibility = View.VISIBLE
                    binding?.btnForgotPasswordSubmit?.visibility = View.GONE
                } else {
                    hideProgressBar()
                    showToast(this, "No fue posible hacer el reseteo. Intenta más tarde")
                }
            }
        }
    }

    override fun onBackPressed(){
        super.onBackPressed()
        finish()
    }
}