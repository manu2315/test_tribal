package com.example.androidtest.presentation.addCollaborator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidtest.R
import com.example.androidtest.databinding.FragmentAddCollaboratorBinding


class AddCollaboratorFragment : Fragment() {

    private val binding:FragmentAddCollaboratorBinding by lazy {
        FragmentAddCollaboratorBinding
            .inflate(LayoutInflater.from(context),null,false)
            //.apply {  }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

}