package com.dwiariyanto.androidkotlinsimpledemo

import android.os.Bundle
import com.dwiariyanto.androidkotlinsimpledemo.core.activity.BaseActivity
import com.dwiariyanto.androidkotlinsimpledemo.data.preference.AppPreference
import com.dwiariyanto.androidkotlinsimpledemo.ui.home.HomeFragment
import com.dwiariyanto.androidkotlinsimpledemo.ui.login.LoginFragment

class MainActivity : BaseActivity()
{
    override fun setup() = Setup(TAG)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val user = AppPreference.instance.token
        if (user.isNotEmpty())
            HomeFragment.replace(this, HomeFragment.Param(user))
        else
            LoginFragment.replace(this)
    }

    companion object
    {
        val TAG = MainActivity::class.java.name
    }
}
