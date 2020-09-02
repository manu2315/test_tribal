package com.example.androidtest.presentation

import android.content.Intent
import android.os.BaseBundle
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.androidtest.R
import com.example.androidtest.data.objects.UserLogged
import com.example.androidtest.databinding.FragmentSettingsBinding
import com.example.androidtest.presentation.base.BaseFragment
import com.example.androidtest.presentation.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.squareup.picasso.Picasso


class SettingsFragment : BaseFragment() {


    private val binding:FragmentSettingsBinding by lazy {
        FragmentSettingsBinding.inflate(
            LayoutInflater.from(context),null,false
        )
            //.apply {  }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner=this.viewLifecycleOwner
        setupSettings()

    }


    private fun setupSettings(){
        val user= UserLogged
        binding.user=user.getUser()
        Picasso.get().load(user.getUser()?.photoUrl!!).into(binding.profileImage)
    }


}