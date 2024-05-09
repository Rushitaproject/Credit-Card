package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCscheckTypeBinding

class Easy_CSCheckTypeActivity_7 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCscheckTypeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCscheckTypeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewAction()
    }

    override fun onRestart() {
        super.onRestart()
    }

    private fun initViewAction() {
        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.ivCcChekOfflineBtn.setOnClickListener(this)
        mBinding.ivCcScoreOnlineBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivCcChekOfflineBtn->{
                mBinding.ivCcChekOfflineBtn.isEnabled = false
                startNewActivity(1)
            }
            mBinding.ivCcScoreOnlineBtn->{
                mBinding.ivCcScoreOnlineBtn.isEnabled = false
                startNewActivity(2)
            }
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
        }
    }

    private fun startNewActivity(pos: Int) {
        nextActivity(pos)
    }

    private fun nextActivity(pos: Int) {
        when (pos) {
            1 -> {
                mBinding.ivCcChekOfflineBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOfflineFirstActivity_16::class.java))
            }
            2 -> {
                mBinding.ivCcScoreOnlineBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineActivity_14::class.java))
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}