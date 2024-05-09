package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCreditCardBinding


class Easy_CreditCardActivity_6 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCreditCardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCreditCardBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewListener()
    }

    private fun initViewListener() {
        mBinding.ivMenuBtn.setOnClickListener(this)
        mBinding.ivBinCheckerBtn.setOnClickListener(this)
        mBinding.ivCcCheckBtn.setOnClickListener(this)
        mBinding.ivCcHistoryBtn.setOnClickListener(this)
        mBinding.ivCcInfoBtn.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v){
            mBinding.ivMenuBtn->{
                mBinding.ivMenuBtn.isEnabled = false
                startNewActivity(5)
            }
            mBinding.ivBinCheckerBtn->{
                mBinding.ivBinCheckerBtn.isEnabled = false
                startNewActivity(1)
            }
            mBinding.ivCcCheckBtn->{
                mBinding.ivCcCheckBtn.isEnabled = false
                startNewActivity(2)
            }
            mBinding.ivCcHistoryBtn->{
                mBinding.ivCcHistoryBtn.isEnabled = false
                startNewActivity(3)
            }
            mBinding.ivCcInfoBtn->{
                mBinding.ivCcInfoBtn.isEnabled = false
                startNewActivity(4)
            }
        }
    }

    private fun startNewActivity(nextInt:Int){
        nextActivity(nextInt)
    }


    private fun nextActivity(nextInt:Int){
        when(nextInt){
            1->{
                mBinding.ivBinCheckerBtn.isEnabled = true
                startActivity(Intent(this, Easy_CheckCCActivity_8::class.java))

            }
            2->{
                mBinding.ivCcCheckBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCGuideActivity_9::class.java))

            }
            3->{
                mBinding.ivCcHistoryBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCHistoryActivity_11::class.java))

            }
            4->{
                mBinding.ivCcInfoBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCInfoActivity_12::class.java))

            }
            5->{
                mBinding.ivMenuBtn.isEnabled = true
                startActivity(Intent(this, Easy_SettingActivity_13::class.java))
            }
        }
    }



    override fun onBackPressed() {
        finish()

    }
}