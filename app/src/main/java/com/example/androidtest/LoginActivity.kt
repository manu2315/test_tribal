package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidtest.databinding.ActivityLoginBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityLoginBinding
    private lateinit var mAuth: FirebaseAuth
    private val RC_SIGN_IN=1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       mBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        click()
    }

    private fun click(){
        mBinding.singIn.setOnClickListener{
            val providers = arrayListOf(
                AuthUI.IdpConfig.GoogleBuilder().build())
            // Create and launch sign-in intent
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN)

        }
    }

}