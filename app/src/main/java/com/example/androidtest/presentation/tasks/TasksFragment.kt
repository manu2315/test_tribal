package com.example.androidtest.presentation.tasks

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.androidtest.R
import com.example.androidtest.data.objects.UserLogged
import com.example.androidtest.databinding.FragmentTasksBinding
import com.example.androidtest.domain.CollaboratorViewModel
import com.example.androidtest.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class TasksFragment : BaseFragment() {

    val viewModel:CollaboratorViewModel by viewModel()
    private val binding:FragmentTasksBinding by lazy {
        FragmentTasksBinding
            .inflate(LayoutInflater.from(context), null, false)
            //.apply {  }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner=this.viewLifecycleOwner
        val user= UserLogged.getUser()
        binding.welcomeText.text=getString(R.string.welcome_text, user?.name, user?.email)
        //binding.animationView.playAnimation()
        //showProgressBar()
    }


}