package com.dwiariyanto.androidkotlinsimpledemo.core.saveandresore

import android.os.Bundle
import android.os.Parcelable

/**
 * Created by Dwi Ariyanto on 4/19/18.
 */
interface ISaveAndRestoreForParam<DATA : Parcelable>
{
    var param: DATA?

    fun doViewStateRestoredForParam(savedInstanceState: Bundle?)
    {
        if (param == null) param = getParam(savedInstanceState)
    }

    fun doSaveInstanceStateForParam(outState: Bundle)
    {
        saveParam(outState, param)
    }

    private fun saveParam(bundle: Bundle, data: DATA?)
    {
        bundle.putParcelable(PARAM, data)
    }

    private fun <T : Parcelable> getParam(bundle: Bundle?): T?
    {
        return bundle?.getParcelable(PARAM)
    }

    companion object
    {
        private const val PARAM = "param"
    }
}