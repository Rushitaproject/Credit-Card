package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivitySettingBinding
import java.lang.Exception

class Easy_SettingActivity_13 : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding:ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
    }

    private fun initViews() {
        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.ivPrivacyPolicyBtn.setOnClickListener(this)
        mBinding.ivRateUsBtn.setOnClickListener(this)
        mBinding.ivShareUsBtn.setOnClickListener(this)
    }

    private fun privacyPolicy(){
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

    private fun rateApp(){
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

    private fun shareApp() {
        val intent = Intent("android.intent.action.SEND")
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name))
        intent.putExtra(
            "android.intent.extra.TEXT", getString(R.string.share_app_message) + """
     https://play.google.com/store/apps/details?id=$packageName
     """.trimIndent()
        )
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Share"))
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivBackBtn->{
               onBackPressed()
            }
            mBinding.ivPrivacyPolicyBtn->{
                privacyPolicy()
            }
            mBinding.ivRateUsBtn->{
                rateApp()
            }
            mBinding.ivShareUsBtn->{
                shareApp()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}