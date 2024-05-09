package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityFullFromThirdBinding

class Easy_FullFromThirdActivity_27 : AppCompatActivity(), View.OnClickListener{
private lateinit var mBinding: ActivityFullFromThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFullFromThirdBinding.inflate(layoutInflater)
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
                if (mBinding.estate.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromThirdActivity_27,"PLease Enter State Name", Toast.LENGTH_SHORT).show()
                }else if (mBinding.ecountry.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromThirdActivity_27,"Please Enter Country Name", Toast.LENGTH_SHORT).show()
                }else if (mBinding.ezipcode.text.toString().length != 6){
                    Toast.makeText(this@Easy_FullFromThirdActivity_27,"Please Enter  6 digit Zip Code", Toast.LENGTH_SHORT).show()
                }else{
                    nextActivity();
                }
            }
            mBinding.ivBackBtn->{
                onBackPressed()
            }
        }
    }

    private fun nextActivity() {
        activityResultLauncher.launch(Intent(this@Easy_FullFromThirdActivity_27,
            Easy_FullFromForthActivity_28::class.java))
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