package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivitySelectCountryBinding

class Easy_SelectCountryActivity_2 : AppCompatActivity(), View.OnClickListener {
    lateinit var mBinding: ActivitySelectCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySelectCountryBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewAction()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onBackPressed() {
        finish()
    }

    private fun initViewAction() {
        mBinding.ivUkCountryBtn.setOnClickListener(this)
        mBinding.ivUsCountryBtn.setOnClickListener(this)
        mBinding.ivGrCountryBtn.setOnClickListener(this)
        mBinding.ivFrCountryBtn.setOnClickListener(this)
        mBinding.ivInCountryBtn.setOnClickListener(this)
        mBinding.ivOtherCountryBtn.setOnClickListener(this)
        mBinding.ivSpCountryBtn.setOnClickListener(this)
        mBinding.ivAuCountryBtn.setOnClickListener(this)
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mBinding.ivUsCountryBtn -> {
                mBinding.ivUsCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivUkCountryBtn -> {
                mBinding.ivUkCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivGrCountryBtn -> {
                mBinding.ivGrCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivAuCountryBtn -> {
                mBinding.ivAuCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivFrCountryBtn -> {
                mBinding.ivFrCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivInCountryBtn -> {
                mBinding.ivInCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivSpCountryBtn -> {
                mBinding.ivSpCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivOtherCountryBtn -> {
                mBinding.ivOtherCountryBtn.isEnabled = false
                startNewActivity(v)
            }
            mBinding.ivBackBtn->{
                onBackPressed()
            }
        }
    }

    private fun startNewActivity(view: View) {
        nextActivity(view)
    }

    private fun nextActivity(view: View) {
            mBinding.ivUsCountryBtn.isEnabled = true
            startActivity(
                Intent(
                    this@Easy_SelectCountryActivity_2,
                    Easy_SelectLangaugeActivity_3::class.java
                )
            )
    }
}