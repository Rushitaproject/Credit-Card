package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityFullFromSecondBinding

class Easy_FullFromSecondActivity_26 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityFullFromSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFullFromSecondBinding.inflate(layoutInflater)
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
                if (mBinding.ehouse.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromSecondActivity_26,"Please Enter House or Apartment No.", Toast.LENGTH_SHORT).show()
                }else if (mBinding.eaddress.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromSecondActivity_26,"Please Enter Address", Toast.LENGTH_SHORT).show()
                }else if (mBinding.ecity.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromSecondActivity_26,"Enter Enter City", Toast.LENGTH_SHORT).show()
                }else{
                    nextActivity()
                }
            }
            mBinding.ivBackBtn->{
                onBackPressed()
            }

        }
    }

    private fun nextActivity() {
        activityResultLauncher.launch(Intent(this@Easy_FullFromSecondActivity_26,
            Easy_FullFromThirdActivity_27::class.java))
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

