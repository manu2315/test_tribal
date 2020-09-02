package com.example.androidtest.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Fragment.setSupportActionBar(toolbar: Toolbar? = null) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    setHasOptionsMenu(true)
}

