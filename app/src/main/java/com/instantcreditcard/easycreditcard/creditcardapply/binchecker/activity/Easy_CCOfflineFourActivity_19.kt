package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcofflineFourBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.DataKeeper

class Easy_CCOfflineFourActivity_19 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCcofflineFourBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcofflineFourBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
        initViewAction()
    }

    override fun onRestart() {
        super.onRestart()
       
    }

    private fun initViewAction() {

        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.ivSeeFullReportBtn.setOnClickListener(this)
    }

    private fun initViews() {
        mBinding.ivScoreTxt.text = DataKeeper().score.toString()

    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivSeeFullReportBtn->{
                mBinding.ivSeeFullReportBtn.isEnabled = false
                startNewActivity()
            }
            mBinding.ivBackBtn->{
                mBinding.ivBackBtn.isEnabled= false
                onBackPressed()
            }
        }
    }



    private fun gotoNextActivity(){
        mBinding.ivSeeFullReportBtn.isEnabled = true

        activityResultLauncher.launch(Intent(this, Easy_CCOfflineReportActivity_20::class.java))
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
}