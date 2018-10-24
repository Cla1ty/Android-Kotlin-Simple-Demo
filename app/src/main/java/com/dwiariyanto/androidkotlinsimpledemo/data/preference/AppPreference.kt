package com.dwiariyanto.androidkotlinsimpledemo.data.preference

import android.annotation.SuppressLint
import com.dwiariyanto.androidkotlinsimpledemo.data.preference.base.BasePreference

/**
 * Created by Dwi Ariyanto on 4/8/18.
 */
class AppPreference
    : BasePreference("APP")
{
    var token: String
        get() = pref.getString(TOKEN_KEY, "")
        set(value) = doEdit { putString(TOKEN_KEY, value) }

    @SuppressLint("ApplySharedPref")
    fun deleteAll()
    {
        pref.edit().clear().commit()
    }

    companion object
    {
        private const val TOKEN_KEY = "K1"
        val instance by lazy { AppPreference() }
    }
}
