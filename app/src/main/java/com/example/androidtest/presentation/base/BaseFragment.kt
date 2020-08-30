package com.example.androidtest.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.airbnb.lottie.LottieAnimationView
import com.example.androidtest.R
import com.example.androidtest.presentation.utils.setSupportActionBar
import com.google.android.material.snackbar.Snackbar


open class BaseFragment :Fragment(){


    private var menuId: Int = 0
    private var toolbar: Toolbar? = null
    private var functionOnCreateOptionsMenu: (() -> Unit)? = null
    private val progressDialog: AlertDialog by lazy {

        AlertDialog.Builder(requireContext())
            .setView(layoutInflater.inflate(R.layout.animation_loading, null))
            .setCancelable(false)
            //.setTitle("Cargando")
            .create()
    }
    private val snackBarWhitOutButton: Snackbar by lazy {
        Snackbar.make(requireView(), "", Snackbar.LENGTH_INDEFINITE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupProgressDialog()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSnackBarWhitOutButton()
        onBackPress(this)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun onBackPress(owner: LifecycleOwner) {
        requireActivity().onBackPressedDispatcher
            .addCallback(owner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPressFun()
                }
            })
    }

    open fun onBackPressFun() {}


    /*ProgressDialog functions*/
    private fun setupProgressDialog() {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.window!!.statusBarColor = Color.TRANSPARENT
        progressDialog.window!!.statusBarColor = Color.TRANSPARENT
        progressDialog.window!!.navigationBarColor = Color.TRANSPARENT
    }

    fun showProgressBar() {
        progressDialog.show()
    }

    fun hideProgressBar() {
        progressDialog.dismiss()
    }

    private fun setupSnackBarWhitOutButton() {
        snackBarWhitOutButton.view
            .setBackgroundColor(
                ContextCompat.getColor(
                    requireActivity().applicationContext,
                    R.color.colorPrimaryColor
                )
            )
        snackBarWhitOutButton.setTextColor(
            ContextCompat.getColor(
                requireActivity().applicationContext,
                R.color.colorPrimaryTextColor
            )
        )
    }

    fun showSnackBarFinsolColorsWhitOutButton(message: String) {
        snackBarWhitOutButton.setText(message)
        snackBarWhitOutButton.show()
    }

    fun hideSnackBarFinsolColorsWhitOutButton() {
        snackBarWhitOutButton.dismiss()
    }


    fun setupToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    fun setupToolbar(toolbar: Toolbar, menuId: Int) {
        setSupportActionBar(toolbar)
        this.toolbar = toolbar
        this.menuId = menuId
    }

    fun setupToolbar(toolbar: Toolbar, titleToolbar: String, menuId: Int) {
        setSupportActionBar(toolbar)
        toolbar.title = titleToolbar
        this.toolbar = toolbar
        this.menuId = menuId
    }

    fun setupToolbarNoMenuWhitNavIcon(
        toolbar: Toolbar,
        titleToolbar: String,
        navigationIcon: Int = R.drawable.ic_arrow_back
    ) {
        setSupportActionBar(toolbar)
        toolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description)
        toolbar.setNavigationIcon(navigationIcon)
        toolbar.setNavigationOnClickListener { onBackPressFun() }
        toolbar.title = titleToolbar
        this.toolbar = toolbar
    }

    fun setupToolbarWhitNavIcon(
        toolbar: Toolbar,
        titleToolbar: String,
        menuId: Int,
        navigationIcon: Int = R.drawable.ic_arrow_back
    ) {
        setSupportActionBar(toolbar)
        toolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description)
        toolbar.setNavigationIcon(navigationIcon)
        toolbar.setNavigationOnClickListener { onBackPressFun() }
        toolbar.title = titleToolbar
        this.toolbar = toolbar
        this.menuId = menuId
    }

    fun setupToolbarHighOrder(
        toolbar: Toolbar,
        titleToolbar: String,
        menuId: Int,
        functionOnCreateOptionsMenu: () -> Unit,
        navigationIcon: Int = R.drawable.ic_arrow_back
    ) {
        setSupportActionBar(toolbar)
        toolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description)
        toolbar.setNavigationIcon(navigationIcon)
        toolbar.setNavigationOnClickListener { onBackPressFun() }
        toolbar.title = titleToolbar
        this.toolbar = toolbar
        this.menuId = menuId
        this.functionOnCreateOptionsMenu = functionOnCreateOptionsMenu
    }

}