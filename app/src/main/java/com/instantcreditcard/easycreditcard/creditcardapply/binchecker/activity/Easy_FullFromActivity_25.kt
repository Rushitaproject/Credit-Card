package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityFullFromBinding

class Easy_FullFromActivity_25 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityFullFromBinding

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFullFromBinding.inflate(layoutInflater)
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
                if (mBinding.fname.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromActivity_25,"Please Enter First Name",Toast.LENGTH_SHORT).show()
                }else if (mBinding.mname.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromActivity_25,"Please Enter Middle Name",Toast.LENGTH_SHORT).show()
                }else if (mBinding.lname.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromActivity_25,"Please Enter Last Name",Toast.LENGTH_SHORT).show()
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
        activityResultLauncher.launch(Intent(this@Easy_FullFromActivity_25,
            Easy_FullFromSecondActivity_26::class.java))
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
