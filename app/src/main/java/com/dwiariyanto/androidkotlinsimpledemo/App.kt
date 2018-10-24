package com.dwiariyanto.androidkotlinsimpledemo

import android.app.Application

/**
 * Created by Dwi Ariyanto on 24/10/18.
 */

class App : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        context = this
    }

    companion object
    {
        lateinit var context: Application
    }
}