package com.dwiariyanto.androidkotlinsimpledemo.data.preference.base

import android.content.Context
import android.content.SharedPreferences
import com.dwiariyanto.androidkotlinsimpledemo.App

/**
 * Created by Dwi Ariyanto on 2/8/2018.
 */

abstract class BasePreference(prefName: String)
{
    protected val pref: SharedPreferences = App.context.getSharedPreferences(prefName,
            Context.MODE_PRIVATE)

    private val listPrefChange: ArrayList<OnPrefChange> = arrayListOf()

    protected fun doEdit(edit: SharedPreferences.Editor.() -> Unit)
    {
        pref.edit()
                .apply {
                    edit.invoke(this)
                }
                .apply()
        listPrefChange.forEach { it.onChange.invoke() }
    }

    fun registerPrefChange(onPrefChange: OnPrefChange)
    {
        listPrefChange.add(onPrefChange)
    }

    fun unregisterPrefChange(onPrefChange: OnPrefChange)
    {
        listPrefChange.remove(onPrefChange)
    }

    data class OnPrefChange(val onChange: () -> Unit)
}
