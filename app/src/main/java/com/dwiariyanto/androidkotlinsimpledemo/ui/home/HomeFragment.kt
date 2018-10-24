package com.dwiariyanto.androidkotlinsimpledemo.ui.home

import android.os.Parcelable
import android.support.v4.app.Fragment
import com.dwiariyanto.androidkotlinsimpledemo.R
import com.dwiariyanto.androidkotlinsimpledemo.core.activity.BaseActivity
import com.dwiariyanto.androidkotlinsimpledemo.core.fragment.BaseFragment
import com.dwiariyanto.androidkotlinsimpledemo.core.saveandresore.ISaveAndRestoreForParam
import com.dwiariyanto.androidkotlinsimpledemo.data.preference.AppPreference
import com.dwiariyanto.androidkotlinsimpledemo.view.dialog.DefaultDialog
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment(), ISaveAndRestoreForParam<HomeFragment.Param>
{
    override var param: Param? = null

    override fun setup() = Setup(TAG, R.layout.home_fragment)

    override fun setupForToolbar() = SetupForToolbar(
            title = "Home Fragment"
    )

    override fun init()
    {
        tvName.text = param?.email ?: ""
        btnClearToken.setOnClickListener {
            showClearTokenDialog()
        }
    }

    private fun showClearTokenDialog()
    {
        defaultDialog.show(context!!,
                "Hapus Token?",
                DefaultDialog.Button("Ya") {
                    AppPreference.instance.deleteAll()
                    baseActivity.onBackPressed()
                },
                DefaultDialog.Button("Tidak"))
    }

    @Parcelize
    data class Param(
            val email: String
    ) : Parcelable

    companion object
    {
        val TAG = HomeFragment::class.java.name

        fun replace(baseActivity: BaseActivity?, param: Param)
        {
            baseActivity?.replaceFragment(HomeFragment().also { it.param = param }, false)
        }
    }

}
