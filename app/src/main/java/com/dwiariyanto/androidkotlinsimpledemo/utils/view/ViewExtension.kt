package com.dwiariyanto.androidkotlinsimpledemo.utils.view

import android.view.View

/**
 * Created by Dwi Ariyanto on 24/10/18.
 */

fun View.visible()
{
    visibility = View.VISIBLE
}

fun View.gone()
{
    visibility = View.GONE
}

var View.isVisible
    get() = visibility == View.VISIBLE
    set(value)
    {
        if (value) visible() else gone()
    }