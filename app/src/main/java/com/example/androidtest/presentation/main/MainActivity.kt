package com.example.androidtest.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidtest.R
import com.example.androidtest.databinding.ActivityMainBinding
import com.example.androidtest.presentation.base.BaseActivity


class MainActivity : BaseActivity() {
    private lateinit var mBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()
        //mBinding.bottomNav.setupWithNavController(Navigation.findNavController(this,R.id.nav_host_fragment))
        //val navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        setUpNavigation()
        setupBottomNavigationView()


    }

    override fun onStart() {
        super.onStart()

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