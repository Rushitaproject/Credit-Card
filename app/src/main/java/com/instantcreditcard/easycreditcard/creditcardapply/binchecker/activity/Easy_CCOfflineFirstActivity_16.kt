package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcofflineFirstBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.DataKeeper
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.second_btn_class
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import java.lang.StringBuilder



class Easy_CCOfflineFirstActivity_16 : AppCompatActivity(), View.OnClickListener, OnSeekChangeListener {
    private lateinit var mBinding:ActivityCcofflineFirstBinding
    var secfb = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcofflineFirstBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
        initViewAction()
    }

    private fun initViews() {

     mBinding.lastNegativeItemBar.setMax(7.0f)
        mBinding.creditCardsBar.max = 6.0f
        mBinding.mortgagesBar.max = 6.0f
        mBinding.retailFinancesBar.max = 6.0f
        mBinding.autoLoansBar.max = 6.0f
        mBinding.studentLoansBar.max = 6.0f
        mBinding.otherLoansBar.max = 6.0f
        mBinding.lastNegativeItemBar.setProgress(DataKeeper().lastNegativeItem.toFloat())
        mBinding.creditCardsBar.setProgress(DataKeeper().creditCards.toFloat())
        mBinding.mortgagesBar.setProgress(DataKeeper().mortgages.toFloat())
        mBinding.retailFinancesBar.setProgress(DataKeeper().retailFinances.toFloat())
        mBinding.autoLoansBar.setProgress(DataKeeper().autoLoans.toFloat())
        mBinding.studentLoansBar.setProgress(DataKeeper().studentLoans.toFloat())
        mBinding.otherLoansBar.setProgress(DataKeeper().otherLoans.toFloat())
        mBinding.creditCardsBar.onSeekChangeListener = this
        mBinding.mortgagesBar.onSeekChangeListener = this
        mBinding.retailFinancesBar.onSeekChangeListener = this
        mBinding.autoLoansBar.onSeekChangeListener = this
        mBinding.studentLoansBar.onSeekChangeListener = this
        mBinding.otherLoansBar.onSeekChangeListener = this
        mBinding.lastNegativeItemBar.onSeekChangeListener = this
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




    private fun gotoNextActivity(){
        mBinding.ivNextBtn.isEnabled = true
        activityResultLauncher.launch(Intent(this, Easy_CCOfflineSecondActivity_17::class.java))
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

    private fun startNewActivity(){
        gotoNextActivity()
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSeeking(seekParams: SeekParams?) {
        val str: String
        var valueOf = java.lang.String.valueOf(seekParams!!.seekBar.progress)
        val progress = seekParams.seekBar.progress
        when (seekParams.seekBar) {
           mBinding.autoLoansBar -> {
                if (progress == 6) {
                    valueOf = getString(R.string.credit_cards_bar_max)
                }
                second_btn_class.f5 = valueOf
                mBinding.autoLoansValue.text = valueOf
                return
            }
            mBinding.creditCardsBar -> {
                if (progress == 6) {
                    valueOf = getString(R.string.credit_cards_bar_max)
                }
                second_btn_class.f2 = valueOf
                mBinding.creditCardsValue.text = valueOf
                return
            }
            mBinding.lastNegativeItemBar -> {
                str = if (progress == 0) {
                    getString(R.string.never)
                } else if (progress == 7) {
                    getString(R.string.last_negative_item_bar_max)
                } else {
                    val sb = StringBuilder()
                    sb.append(valueOf)
                    sb.append(if (progress != 1) " years" else " year")
                    sb.toString()
                }
                second_btn_class.f1 = str
                mBinding.lastNegativeItemValue.text = str
                return
            }
            mBinding.mortgagesBar -> {
                if (progress == 6) {
                    valueOf = getString(R.string.credit_cards_bar_max)
                }
                second_btn_class.f3 = valueOf
                mBinding.mortgagesValue.text = valueOf
                return
            }
            mBinding.otherLoansBar -> {
                if (progress == 6) {
                    valueOf = getString(R.string.credit_cards_bar_max)
                }
                second_btn_class.f7 = valueOf
                mBinding.otherLoansValue.text = valueOf
                return
            }
            mBinding.retailFinancesBar -> {
                if (progress == 6) {
                    valueOf = getString(R.string.credit_cards_bar_max)
                }
                second_btn_class.f4 = valueOf
                mBinding.retailFinancesValue.text = valueOf
                return
            }
            mBinding.studentLoansBar -> {
                if (progress == 6) {
                    valueOf = getString(R.string.credit_cards_bar_max)
                }
                second_btn_class.f6 = valueOf
                mBinding.studentLoansValue.text = valueOf
                return
            }
            else -> return
        }
    }

    override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
        when (seekBar) {
            mBinding.autoLoansBar -> {
                DataKeeper().autoLoans = seekBar.progress
                return
            }
            mBinding.creditCardsBar -> {
                DataKeeper().creditCards = seekBar.progress
                return
            }
            mBinding.lastNegativeItemBar -> {
                DataKeeper().lastNegativeItem = seekBar.progress
                return
            }
            mBinding.mortgagesBar -> {
                DataKeeper().mortgages = seekBar.progress
                return
            }
            mBinding.otherLoansBar -> {
                DataKeeper().otherLoans = seekBar.progress
                return
            }
           mBinding.retailFinancesBar -> {
                DataKeeper().retailFinances = seekBar.progress
                return
            }
            mBinding.studentLoansBar -> {
                DataKeeper().studentLoans = seekBar.progress
                return
            }
            else -> return
        }
    }
}