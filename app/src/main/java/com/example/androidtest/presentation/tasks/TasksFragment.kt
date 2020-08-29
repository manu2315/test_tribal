package com.example.androidtest.presentation.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.androidtest.R
import com.example.androidtest.data.objects.UserLogged
import com.example.androidtest.databinding.FragmentTasksBinding
import com.example.androidtest.domain.CollaboratorViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


class TasksFragment : Fragment() {

    val viewModel:CollaboratorViewModel by viewModel()
    private val binding:FragmentTasksBinding by lazy {
        FragmentTasksBinding
            .inflate(LayoutInflater.from(context),null,false)
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
        val user= UserLogged.getUser()
        binding.welcomeText.text=getString(R.string.welcome_text,user?.name,user?.email)

    }


}