package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCconlineBinding

class Easy_CCOnlineActivity_14 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCconlineBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCconlineBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initViewAction()

    }



    private fun initViewAction() {
        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.ivHomeCcBtn.setOnClickListener(this)
        mBinding.ivBuyCcBtn.setOnClickListener(this)
        mBinding.ivComCcBtn.setOnClickListener(this)
        mBinding.ivCalCcBtn.setOnClickListener(this)
        mBinding.ivMediaCcBtn.setOnClickListener(this)
        mBinding.ivDisCcBtn.setOnClickListener(this)
        mBinding.ivCmCcBtn.setOnClickListener(this)
        mBinding.ivFaqsCcBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
            mBinding.ivHomeCcBtn->{
                mBinding.ivHomeCcBtn.isEnabled = false
                startNewActivity(1)
            }
            mBinding.ivBuyCcBtn->{
                mBinding.ivBuyCcBtn.isEnabled = false
                startNewActivity(2)
            }
            mBinding.ivComCcBtn->{
                mBinding.ivComCcBtn.isEnabled = false
                startNewActivity(3)
            }
            mBinding.ivCalCcBtn->{
                mBinding.ivCalCcBtn.isEnabled = false
                startNewActivity(4)
            }
            mBinding.ivMediaCcBtn->{
                mBinding.ivMediaCcBtn.isEnabled = false
                startNewActivity(5)
            }
            mBinding.ivDisCcBtn->{
                mBinding.ivDisCcBtn.isEnabled = false
                startNewActivity(6)
            }
            mBinding.ivCmCcBtn->{
                mBinding.ivCmCcBtn.isEnabled = false
                startNewActivity(7)
            }
            mBinding.ivFaqsCcBtn->{
                mBinding.ivFaqsCcBtn.isEnabled = false
                startNewActivity(8)
            }


        }
    }

    override fun onRestart() {
        super.onRestart()
       
    }

    override fun onBackPressed() {
        finish()

    }

    private fun startNewActivity(i: Int) {

        gotoNextActivity(i)

    }

    private fun gotoNextActivity(i: Int) {
        when(i){
            1->{
                mBinding.ivHomeCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",1))
            }
            2->{
                mBinding.ivBuyCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",2))
            }
            3->{
                mBinding.ivComCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",3))
            }
            4->{
                mBinding.ivCalCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",4))
            }
            5->{
                mBinding.ivMediaCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",5))
            }
            6->{
                mBinding.ivDisCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",6))
            }
            7->{
                mBinding.ivCmCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",7))
            }
            8->{
                mBinding.ivFaqsCcBtn.isEnabled = true
                startActivity(Intent(this, Easy_CCOnlineMainActivity_15::class.java).putExtra("number",8))
            }
        }
    }
}