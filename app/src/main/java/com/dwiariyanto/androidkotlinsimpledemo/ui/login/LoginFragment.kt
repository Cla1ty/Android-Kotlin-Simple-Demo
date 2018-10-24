package com.dwiariyanto.androidkotlinsimpledemo.ui.login

import android.support.v4.app.Fragment

import com.dwiariyanto.androidkotlinsimpledemo.R
import com.dwiariyanto.androidkotlinsimpledemo.core.activity.BaseActivity
import com.dwiariyanto.androidkotlinsimpledemo.core.fragment.BaseFragment
import com.dwiariyanto.androidkotlinsimpledemo.data.preference.AppPreference
import com.dwiariyanto.androidkotlinsimpledemo.ui.home.HomeFragment
import com.dwiariyanto.androidkotlinsimpledemo.utils.edittext.isEmailPatternNotValid
import com.dwiariyanto.androidkotlinsimpledemo.utils.edittext.isEmpty
import com.dwiariyanto.androidkotlinsimpledemo.utils.edittext.minCount
import kotlinx.android.synthetic.main.login_fragment.*

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : BaseFragment()
{
    override fun setup() = Setup(TAG, R.layout.login_fragment)

    override fun setupForToolbar() = SetupForToolbar(
            title = "Login"
    )

    override fun init()
    {
        btnLogin.setOnClickListener { login() }
    }

    private fun login()
    {
        if (isValid())
        {
            AppPreference.instance.token = etEmail.text.toString()

            moveToHomeFragment()
        }
    }

    private fun isValid(): Boolean
    {
        var isValid = true

        if (etEmail.isEmpty("Email")) isValid = false
        if (etEmail.isEmailPatternNotValid()) isValid = false
        if (etPassword.isEmpty("Password")) isValid = false
        if (etPassword.minCount("Password")) isValid = false

        return isValid
    }

    private fun moveToHomeFragment()
    {
        val param = HomeFragment.Param(etEmail.text.toString())
        HomeFragment.replace(baseActivity, param)
    }

    companion object
    {
        val TAG = LoginFragment::class.java.name

        fun replace(baseActivity: BaseActivity?)
        {
            baseActivity?.replaceFragment(LoginFragment(), false)
        }
    }
}
