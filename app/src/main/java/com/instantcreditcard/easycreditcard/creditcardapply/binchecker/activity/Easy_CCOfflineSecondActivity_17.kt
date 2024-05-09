package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcofflineSecondBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.DataKeeper
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.second_btn_class


class Easy_CCOfflineSecondActivity_17 : AppCompatActivity(), View.OnClickListener, OnSeekChangeListener {
    private lateinit var mBinding:ActivityCcofflineSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcofflineSecondBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
        initViewAction()
    }

    private fun initViews() {
        mBinding.allCreditLimitsBar.setOnSeekChangeListener(this)
        mBinding.allCreditLimitsBar.max = 100000.0f
        mBinding.allCreditLimitsBar.setProgress(DataKeeper().creditLimit.toFloat())
        mBinding.recentBalancesBar.setOnSeekChangeListener(this)
        mBinding.recentBalancesBar.max = 100000.0f
        mBinding.recentBalancesBar.setProgress(DataKeeper().recentBalances.toFloat())
    }

    private fun initViewAction() {
        mBinding.ivNextBtn.setOnClickListener(this)
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivNextBtn->{
                mBinding.ivNextBtn.isEnabled = false
                startNewActivity()
            }
            mBinding.ivBackBtn->{
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun gotoNextActivity(){
        mBinding.ivNextBtn.isEnabled = true
        activityResultLauncher.launch(Intent(this, Easy_CCOfflineThirdActivity_18::class.java))
    }

    val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            Log.e(
                "TAG", "onActivityResult: callNext"
                        + result.data!!.getStringExtra("Added")
            )
            val resultInt = Intent()
            resultInt.putExtra("Added", "yesAdded")
            setResult(RESULT_OK, resultInt)
            finish()
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    private fun startNewActivity(){
        gotoNextActivity()
    }

    override fun onSeeking(seekParams: SeekParams?) {
        val progress = seekParams!!.seekBar.progress
        var valueOf = progress.toString()
        val id = seekParams!!.seekBar.id
        if (id == R.id.all_credit_limits_bar) {
            if (progress == 0) {
                valueOf = getString(R.string.zero_dollars).substring(1)
            } else if (progress == 100000) {
                valueOf = getString(R.string.all_credit_limits_bar_max).substring(1)
            }
            second_btn_class.f8 = valueOf
            mBinding.allCreditLimitsValue.text = "$$valueOf"
        } else if (id == R.id.recent_balances_bar) {
            if (progress == 0) {
                valueOf = getString(R.string.zero_dollars).substring(1)
            } else if (progress == 100000) {
                valueOf = getString(R.string.all_credit_limits_bar_max).substring(1)
            }
            second_btn_class.f9 = valueOf
            mBinding.recentBalancesValue.text = "$$valueOf"
        }
    }

    override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
        val id: Int = seekBar!!.id
        if (id == R.id.all_credit_limits_bar) {
            DataKeeper().creditLimit = seekBar.progress
        } else if (id == R.id.recent_balances_bar) {
            DataKeeper().recentBalances = seekBar.progress
        }
    }
}