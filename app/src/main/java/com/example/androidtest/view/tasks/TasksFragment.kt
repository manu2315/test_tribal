package com.example.androidtest.view.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidtest.R
import com.example.androidtest.data.UserLogged
import com.example.androidtest.databinding.FragmentTasksBinding


class TasksFragment : Fragment() {

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
        val user=UserLogged.getUser()
        binding.welcomeText.text=getString(R.string.welcome_text,user?.name,user?.email)

    }


}