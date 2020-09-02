package com.example.androidtest.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.airbnb.lottie.LottieAnimationView
import com.example.androidtest.R
import com.example.androidtest.presentation.utils.setSupportActionBar
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber


open class BaseFragment :Fragment(){


    private var menuId: Int = 0
    private var toolbar: Toolbar? = null
    private var functionOnCreateOptionsMenu: (() -> Unit)? = null
    var layoutInflater2:View?=null
    private val progressDialog: AlertDialog by lazy {
        AlertDialog.Builder(requireContext())
            //.setView(layoutInflater.inflate(R.layout.animation_loading, null))
            .setView(layoutInflater2)
            .setCancelable(false)
            //.setTitle("Cargando")
            .create()
    }
    private val snackBarWhitOutButton: Snackbar by lazy {
        Snackbar.make(requireView(), "", Snackbar.LENGTH_INDEFINITE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutInflater2=LayoutInflater.from(context).inflate(R.layout.animation_loading,null)//layoutInflater.inflate(R.layout.animation_loading,null)

        setupProgressDialog()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSnackBarWhitOutButton()
        onBackPress(this)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if(menuId != 0){
            inflater.inflate(menuId,menu)
        }
        if(functionOnCreateOptionsMenu != null){
            functionOnCreateOptionsMenu!!.invoke()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toolbarMenuOption(itemSelected = item)
        return true
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

    /*Toolbar function*/
    open fun toolbarMenuOption(itemSelected: MenuItem) {}

    /*ProgressDialog functions*/
    private fun setupProgressDialog() {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.window!!.statusBarColor = Color.TRANSPARENT
        progressDialog.window!!.statusBarColor = Color.TRANSPARENT
        progressDialog.window!!.navigationBarColor = Color.TRANSPARENT
    }

    fun showProgressBar() {
        val animamatior= layoutInflater2!!.findViewById<LottieAnimationView>(R.id.animation_view)
        animamatior!!.playAnimation()
        progressDialog.show()
    }

    fun hideProgressBar() {
        val animamatior= layoutInflater2!!.findViewById<LottieAnimationView>(R.id.animation_view)
        animamatior!!.pauseAnimation()
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

    fun searchViewQuery(
        searchView: SearchView,
        onQueryTextChange: (String?) -> Unit?,
        onQueryTextSubmit: (String?) -> Unit?,
        onCloseListener: () -> Unit?
    ) {
        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Timber.e("search query:${query}")
                    onQueryTextSubmit(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Timber.e("search newText:${newText}")
                    onQueryTextChange(newText)
                    return true
                }
            })

            setOnCloseListener {
                onCloseListener()
                return@setOnCloseListener false
            }
        }

    }
}