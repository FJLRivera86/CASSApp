package com.project.cassa

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.project.cassa.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private var binding: ActivitySignUpBinding? = null
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

        
        binding?.tvLoginPage?.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
        binding?.btnSignUp?.setOnClickListener { registerUser() }

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración a Firebase")
        analytics.logEvent("Pago_Tardio_Membresia", bundle)
    }

    private fun registerUser() {
        val name = binding?.etSinUpName?.text.toString()
        val email = binding?.etSinUpEmail?.text.toString()
        val password = binding?.etSinUpPassword?.text.toString()
        if (validateForm(name, email, password)){
            showProgressBar()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        showToast(this, "Usuario creado exitosamente")
                        hideProgressBar()
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    } else {
                        showToast(this, "Usuario no creado. Intenta después")
                        hideProgressBar()
                    }
                }
        }
    }

    private fun validateForm(name:String, email:String, password:String):Boolean
    {
        return when {
            TextUtils.isEmpty(name)->{
                binding?.tilName?.error = "Ingresa un nombre"
                false
            }
            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches()->{
                binding?.tilEmail?.error = "Ingresa un correo valido"
                false
            }
            TextUtils.isEmpty(password)->{
                binding?.tilPassword?.error = "Ingresa un password"
                false
            }
            else -> { true }
        }
    }
}