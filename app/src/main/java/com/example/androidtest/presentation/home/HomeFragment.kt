package com.example.androidtest.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.androidtest.data.objects.UserLogged
import com.example.androidtest.databinding.FragmentHomeBinding
import com.example.androidtest.domain.PhotosViewModel
import com.example.androidtest.presentation.adapters.PhotoAdapter
import com.example.androidtest.presentation.base.BaseFragment
import com.example.androidtest.presentation.utils.getUnsplashPhotoList
import kotlinx.android.synthetic.main.user_data.view.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment() {


    private lateinit var mAdapter: PhotoAdapter
    val viewModel: PhotosViewModel by sharedViewModel()
    private val binding:FragmentHomeBinding by lazy {
        FragmentHomeBinding
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
        //binding.welcomeText.text=getString(R.string.welcome_text, user?.name, user?.email)
        //Glide.with(view).load(user?.photoUrl).into(binding.profileImage)
        //binding.animationView.playAnimation()
        //showProgressBar()

        Glide.with(view).load(user?.photoUrl).into(binding.data.profile_image)
        binding.data.name_user.text = user?.name
        binding.data.description.text = user?.email
        setupRecyclerView()
        /*if(!requireActivity().getUnsplashPhotoList().isNullOrEmpty()){
            setupRecyclerView()
            mAdapter.setListOfPhotos(requireActivity().getUnsplashPhotoList())
        }*/
        viewModel.photoList.observe(viewLifecycleOwner, Observer {
            mAdapter.setListOfPhotos(it)
        })

    }

    private fun setupRecyclerView(){

        binding.homeRecyclerView.setHasFixedSize(true)
        binding.homeRecyclerView.itemAnimator = null
        binding.homeRecyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        mAdapter = PhotoAdapter(requireContext())
        binding.homeRecyclerView.adapter = mAdapter
    }




}