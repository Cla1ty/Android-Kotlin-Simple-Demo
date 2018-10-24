package com.dwiariyanto.androidkotlinsimpledemo.utils.edittext

import android.util.Patterns
import android.widget.TextView

/**
 * Created by Dwi Ariyanto on 24/10/18.
 */

fun TextView.isEmpty(title: String): Boolean
{
    if (text.isEmpty())
    {
        error = "$title tidak boleh kosong"
        return true
    }

    error = null
    return false
}

fun TextView.isEmailPatternNotValid(): Boolean
{
    if (!Patterns.EMAIL_ADDRESS.matcher(text).matches())
    {
        error = "Format email salah"
        return true
    }

    error = null
    return false
}

fun TextView.minCount(title: String, minCount: Int = 6): Boolean
{
    if (text.length < minCount)
    {
        error = "$title tidak boleh kurang dari $minCount"
        return true
    }

    error = null
    return false
}