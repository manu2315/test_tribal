package com.example.androidtest.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidtest.R
import com.example.androidtest.databinding.ActivityMainBinding
import com.example.androidtest.domain.PhotosViewModel
import com.example.androidtest.presentation.base.BaseActivity
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {
    private lateinit var mBinding:ActivityMainBinding
    private val REQUEST_CODE=1
    var mPhotos: ArrayList<UnsplashPhoto>?=null
    val viewModel: PhotosViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()
        //mBinding.bottomNav.setupWithNavController(Navigation.findNavController(this,R.id.nav_host_fragment))
        //val navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        setUpNavigation()
        setupBottomNavigationView()

        startActivityForResult(
            UnsplashPickerActivity.getStartingIntent(
                this,
                true
            ), REQUEST_CODE
        )

    }

    override fun onStart() {
        super.onStart()

    }

    // here we are receiving the result from the picker activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            // getting the photos
            val photos: ArrayList<UnsplashPhoto>? = data?.getParcelableArrayListExtra(UnsplashPickerActivity.EXTRA_PHOTOS)
            mPhotos = photos
            // showing the preview
            // telling the user how many have been selected
            if(!mPhotos.isNullOrEmpty()){
                viewModel.setUnsplashPhotoList(mPhotos!!)
            }

            Toast.makeText(this, "number of selected photos: " + photos?.size, Toast.LENGTH_SHORT).show()
        }
    }
    private fun moveToHome(){
        if (Navigation.findNavController(this,mBinding.navHostFragment.id).currentDestination?.id != R.id.tasksFragment) {
            Navigation.findNavController(this,mBinding.navHostFragment.id).popBackStack()
        }
    }

    private fun moveToAddCollaborator(){
        if (Navigation.findNavController(this,mBinding.navHostFragment.id).currentDestination?.id != R.id.tasksFragment) {
            Navigation.findNavController(this,mBinding.navHostFragment.id).popBackStack()
        }
        Navigation.findNavController(this,mBinding.navHostFragment.id)
            .navigate(R.id.action_tasksFragment_to_addCollaboratorFragment)
    }

    private fun moveToMyCollaborators(){
        if (Navigation.findNavController(this,mBinding.navHostFragment.id).currentDestination?.id != R.id.tasksFragment) {
            Navigation.findNavController(this,mBinding.navHostFragment.id).popBackStack()
        }
        Navigation.findNavController(this,mBinding.navHostFragment.id)
            .navigate(R.id.action_tasksFragment_to_collaboratorFragment)
    }



    private fun setupBottomNavigationView(){
        mBinding.bottomNav.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.page_0 -> {
                    moveToHome()

                }
                R.id.page_1 -> {

                    moveToMyCollaborators()
                    //Toast.makeText(this,"Hola2",Toast.LENGTH_SHORT).show()
                }
                R.id.page_2 -> {
                    moveToAddCollaborator()
                    //Toast.makeText(this,"Hola3",Toast.LENGTH_SHORT).show()
                }

            }
            true
        }
    }

    fun setUpNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            mBinding.bottomNav,
            navHostFragment!!.navController
        )
    }



}