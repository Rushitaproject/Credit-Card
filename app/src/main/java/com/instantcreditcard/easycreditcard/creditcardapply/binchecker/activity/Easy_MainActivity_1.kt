package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adhelper.*
//import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adhelper.Constants.EXTRA_SCREEN
//import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adhelper.Constants.ExitDialogShow
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityMainBinding



class Easy_MainActivity_1 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewListener()
    }

    private fun initViewListener() {
        mBinding.ivStartBtn.setOnClickListener(this)
        mBinding.icShare.setOnClickListener(this)
        mBinding.icRate.setOnClickListener(this)
        mBinding.icPrivacyPolicy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mBinding.ivStartBtn -> {
                nextActivity()


            }

            mBinding.icShare -> {
                val intent = Intent("android.intent.action.SEND")
                intent.putExtra(
                    "android.intent.extra.SUBJECT",
                    getString(R.string.app_name)
                )
                intent.putExtra(
                    "android.intent.extra.TEXT", getString(R.string.share_app_message) + """
     
     https://play.google.com/store/apps/details?id=$packageName
     """.trimIndent()
                )
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share"))
            }
            mBinding.icRate -> {
                try {
                    try {
                        startActivity(
                            Intent(
                                "android.intent.action.VIEW",
                                Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
                            )
                        )
                    } catch (e: ActivityNotFoundException) {
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            mBinding.icPrivacyPolicy -> {
                try {
                    val builder1 = CustomTabsIntent.Builder()
                    val customTabsIntent = builder1.build()
                    customTabsIntent.launchUrl(
                        this,
                        Uri.parse("Constants.PrivacyPolicy")
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun nextActivity() {
            if (SharedPrefs.getBoolean(this@Easy_MainActivity_1, "isIntroEveryTime", false)) {
                startActivity(Intent(this@Easy_MainActivity_1, Easy_SelectYourTypeActivity_5::class.java))
            } else {
                    startActivity(Intent(this@Easy_MainActivity_1, Easy_SelectCountryActivity_2::class.java))
             }
    }

    override fun onBackPressed() {
            finishAffinity()
    }

    private fun startExit() {
        val dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.requestWindowFeature(1)
        dialog.getWindow()!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_exit)
        dialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(0))
        dialog.setCanceledOnTouchOutside(false)
        val tvOk: Button = dialog.findViewById(R.id.btn_yes)
        val tvCancel: Button = dialog.findViewById(R.id.btn_no)

        tvOk.setOnClickListener(View.OnClickListener {

            finishAffinity()
            dialog.dismiss()
        })
        tvCancel.setOnClickListener(View.OnClickListener { dialog.dismiss() })
        val window: Window = dialog.getWindow()!!
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog.show()
    }



}