package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcguideBinding

class Easy_CCGuideActivity_9 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCcguideBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcguideBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initView()
       

    }

    override fun onBackPressed() {

        finish()


    }

    private fun initView() {
        mBinding.ivNextBtn.setOnClickListener(this)
        mBinding.ivBackBtn.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0){
            mBinding.ivNextBtn->{
                nextActivity()

            }
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
        }
    }

    private fun nextActivity(){
        mBinding.ivNextBtn.isEnabled = true
        startActivity(Intent(this, Easy_CCCheckActivity_10::class.java))

    }
}