package com.dwiariyanto.androidkotlinsimpledemo.view.dialog

import android.content.Context
import android.view.View
import com.dwiariyanto.androidkotlinsimpledemo.R
import com.dwiariyanto.androidkotlinsimpledemo.utils.view.gone
import com.dwiariyanto.androidkotlinsimpledemo.utils.view.visible
import com.dwiariyanto.androidkotlinsimpledemo.core.dialog.BaseDialog
import kotlinx.android.synthetic.main.default_dialog.view.*

/**
 * Created by Dwi Ariyanto on 5/27/18.
 */
open class DefaultDialog : BaseDialog(R.layout.default_dialog)
{
    fun show(pContext: Context,
             pMessage: String,
             pButton1: Button? = null,
             pButton2: Button? = null)
    {
        showDialog(pContext)

        layout.tvMessage.text = pMessage
        layout.btn1.apply {
            if (pButton1 == null)
            {
                gone()
            }
            else
            {
                visible()
                text = pButton1.title
                setOnClickListener {
                    dismiss()
                    pButton1.onClick?.invoke()
                }
            }
        }
        layout.btn2.apply {
            if (pButton2 == null)
            {
                gone()
            }
            else
            {
                visible()
                text = pButton2.title
                setOnClickListener {
                    dismiss()
                    pButton2.onClick?.invoke()
                }
            }
        }
    }

    override fun onShowDialog()
    {
    }

    override fun bindView(pLayout: View)
    {
    }

    data class Button(val title: String, val onClick: (() -> Unit)? = null)
}