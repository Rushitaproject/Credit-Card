package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcofflineThirdBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.DataKeeper
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.second_btn_class
import java.lang.StringBuilder


class Easy_CCOfflineThirdActivity_18 : AppCompatActivity(), View.OnClickListener, OnSeekChangeListener {
    private lateinit var mBinding: ActivityCcofflineThirdBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcofflineThirdBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
        initViewAction()
    }

    private fun initViews() {
        mBinding.applyCreditBar.setOnSeekChangeListener(this)
        mBinding.applyCreditBar.max = 10.0f
        mBinding.applyCreditBar.setProgress(DataKeeper().appliedCredit.toFloat())
        mBinding.firstOpenOldestActiveBar.setOnSeekChangeListener(this)
        mBinding.firstOpenOldestActiveBar.max = 10.0f
        mBinding.firstOpenOldestActiveBar.setProgress(
            DataKeeper().firstOpenCredit.toFloat()
        )
    }

    private fun initViewAction() {
        mBinding.ivNextBtn.setOnClickListener(this)
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mBinding.ivNextBtn -> {
                mBinding.ivNextBtn.isEnabled = false
                startNewActivity()
            }
            mBinding.ivBackBtn -> {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun gotoNextActivity() {
        mBinding.ivNextBtn.isEnabled = true
        activityResultLauncher.launch(Intent(this, Easy_CCOfflineFourActivity_19::class.java))
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


    private fun startNewActivity() {
        gotoNextActivity()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSeeking(seekParams: SeekParams?) {
        val str: String
        val progress = seekParams!!.seekBar.progress
        var valueOf = progress.toString()
        val id = seekParams!!.seekBar.id
        if (id == R.id.apply_credit_bar) {
            if (progress == 10) {
                valueOf = getString(R.string.apply_credit_bar_max)
            }
            second_btn_class.f10 = valueOf
            mBinding.applyCreditLimitsValue.text = valueOf
        } else if (id == R.id.first_open_oldest_active_bar) {
            str = if (progress == 0) {
                getString(R.string.no_accounts_open)
            } else if (progress == 10) {
                getString(R.string.first_open_oldest_active_bar_max)
            } else {
                val sb = StringBuilder()
                sb.append(valueOf)
                sb.append(if (progress != 1) " years" else " year")
                sb.toString()
            }
            second_btn_class.f11 = str
            mBinding.firstOpenOldestActiveValue.text = valueOf
        }
    }

    override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
        val id: Int = seekBar!!.id
        if (id == R.id.apply_credit_bar) {
            DataKeeper().appliedCredit = seekBar.progress
        } else if (id == R.id.first_open_oldest_active_bar) {
            DataKeeper().firstOpenCredit = seekBar.progress
        }
    }
}