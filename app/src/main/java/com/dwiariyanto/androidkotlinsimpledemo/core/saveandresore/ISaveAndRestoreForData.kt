package com.dwiariyanto.androidkotlinsimpledemo.core.saveandresore

import android.os.Bundle
import android.os.Parcelable

/**
 * Created by Dwi Ariyanto on 4/19/18.
 */
interface ISaveAndRestoreForData<DATA : Parcelable>
{
    var data: DATA?

    fun doViewStateRestoredForData(savedInstanceState: Bundle?)
    {
        if (data == null) data = getData(savedInstanceState)
    }

    fun doSaveInstanceStateForData(outState: Bundle)
    {
        saveData(outState, data)
    }

    private fun saveData(bundle: Bundle, data: DATA?)
    {
        bundle.putParcelable(DATA, data)
    }

    private fun <T : Parcelable> getData(bundle: Bundle?): T?
    {
        return bundle?.getParcelable(DATA)
    }

    companion object
    {
        private const val DATA = "data"
    }
}