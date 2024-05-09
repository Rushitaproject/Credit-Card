package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityApplyThirdBinding

class Easy_ApplyThirdActivity_23 : AppCompatActivity(), View.OnClickListener  {
    private lateinit var mBinding: ActivityApplyThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityApplyThirdBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        initViewAction()
    }


    private fun initViewAction() {
        mBinding.ivNextBtn.setOnClickListener(this)

        mBinding.ivBackBtn.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when(v){

            mBinding.ivNextBtn->{
                mBinding.ivNextBtn.isEnabled= false
                startNewActivity(1)
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
                mBinding.ivNextBtn.isEnabled = true
                activityResultLauncher.launch(Intent(this, Easy_ApplyFourthActivity_24::class.java))
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

            val resultInt = Intent()
            resultInt.putExtra("Added", "yesAdded")
            setResult(RESULT_OK, resultInt)
            finish()
        }
    }

    override fun onRestart() {
        super.onRestart()
       
    }
    override fun onBackPressed() {

        finish()
    }


}