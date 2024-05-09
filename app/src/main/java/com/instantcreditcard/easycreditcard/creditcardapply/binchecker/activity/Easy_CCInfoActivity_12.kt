package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcinfoBinding

class Easy_CCInfoActivity_12 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCcinfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcinfoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
    }

    private fun initViews() {
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivBackBtn->{
               onBackPressed()
            }
        }
    }


    override fun onBackPressed() {
        finish()
    }
}