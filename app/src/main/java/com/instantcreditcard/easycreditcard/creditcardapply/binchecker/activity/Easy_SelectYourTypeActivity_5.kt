package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adhelper.*
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivitySelectYourTypeBinding


class Easy_SelectYourTypeActivity_5 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivitySelectYourTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySelectYourTypeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        SharedPrefs.savePref(this, "isIntroEveryTime", true)
        if(Constants.ApplyCreditCard){
            mBinding.ivCcApplyBtn.visibility = View.VISIBLE
        }
        if(Constants.CreditCardScore){
            mBinding.ivCcScoreBtn.visibility = View.VISIBLE
        }
        initViewAction()
    }

    private fun initViewAction() {
        mBinding.ivCcChekBtn.setOnClickListener(this)
        mBinding.ivCcScoreBtn.setOnClickListener(this)
        mBinding.ivCcApplyBtn.setOnClickListener(this)
        mBinding.ivCcIntroBtn.setOnClickListener(this)
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivCcChekBtn->{
                mBinding.ivCcChekBtn.isEnabled= false
                startNewActivity(1)
            }
            mBinding.ivCcScoreBtn->{
                mBinding.ivCcScoreBtn.isEnabled= false
                startNewActivity(2)
            }
            mBinding.ivCcApplyBtn->{
                mBinding.ivCcApplyBtn.isEnabled= false
                startNewActivity(3)
            }
            mBinding.ivCcIntroBtn->{
                mBinding.ivCcIntroBtn.isEnabled= false
                startNewActivity(4)
            }
            mBinding.ivBackBtn->{
                onBackPressed()
            }
        }
    }

    private fun startNewActivity(nextInt:Int){
        nextActivity(nextInt)
    }

    private fun nextActivity(nextInt:Int){
        when(nextInt){
            1->{
                mBinding.ivCcChekBtn.isEnabled = true
                startActivity(Intent(this, Easy_CreditCardActivity_6::class.java))
            }
            2->{
                mBinding.ivCcScoreBtn.isEnabled = true
                startActivity(Intent(this, Easy_CSCheckTypeActivity_7::class.java))
            }
            3->{
                mBinding.ivCcApplyBtn.isEnabled = true
                activityResultLauncher.launch(Intent(this, Easy_CSApplyCreditActivity_21::class.java))
            }
            4->{
                mBinding.ivCcIntroBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCInfoActivity_12::class.java))
            }
        }
    }
    val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            Log.e(
                "TAG", "onActivityResult: callNext"
                        + result.data!!.getStringExtra("Added")
            )

        }
    }

    override fun onRestart() {
        super.onRestart(

        )
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onResume() {
        super.onResume()
    }

}