package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.apiclient.APIClient
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.apiinterface.APIInterface
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCccheckBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.BinList
import retrofit2.Call
import retrofit2.Callback
import android.text.Editable

import android.text.TextWatcher

import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.DBHandler.DbHandler


class Easy_CCCheckActivity_10 : AppCompatActivity(), View.OnClickListener {
    private var mStrArray:String?= null
    private lateinit var mBinding:ActivityCccheckBinding
    var key = false
    var isAds :Boolean =false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCccheckBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        initViews()
        mBinding.creditCard.addTextChangedListener(CreditCardNumberFormattingTextWatcher())

        mBinding.checkData.setOnClickListener(View.OnClickListener {
            val length: Int = mBinding.creditCard.length()
            if (mBinding.creditCard.text.toString() == "") {
                mBinding.creditCard.error = "Enter Your Card Number"
            } else if (length < 19) {
                mBinding.creditCard.setError("Enter Your Card Number")
            } else if (!key) {
                nextProcess()




            }
        })

    }

    override fun onBackPressed() {


        finish()
    }

    private fun nextProcess() {
        mBinding.checkData.isEnabled = true
        Easy_CheckCCActivity_8().hideKeyboard(this)
        DoBinList()
        mBinding.checkData.visibility = View.GONE
        key = false
    }

    private fun initViews() {
        mBinding.ivBackBtn.setOnClickListener(this)

    }

    fun DoBinList() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage(getString(R.string.loader))
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.show()
        var mApiInterface = APIClient.client?.create(APIInterface::class.java)
        val call: Call<BinList?>? = mApiInterface?.DoBinList(mStrArray)
        call?.enqueue(object : Callback<BinList?> {
            override fun onResponse(call: Call<BinList?>?, response: retrofit2.Response<BinList?>?) {
                progressDialog.dismiss()
                if (response!!.isSuccessful) {
                    progressDialog.dismiss()
                    if (response.body() != null) {
                        mBinding.linRight.visibility = View.VISIBLE
                        mBinding.linWrong.visibility = View.GONE
                        mBinding.cardtext.visibility = View.VISIBLE
                        mBinding.holdernm.text = response.body()!!.scheme
                        DbHandler(
                            this@Easy_CCCheckActivity_10
                        ).insertUserDetails(mBinding.creditCard.text.toString(), response.body()!!.brand, response.body()!!.scheme)
                        return
                    }

                }
                mBinding.linWrong.visibility = View.VISIBLE
                mBinding.linRight.visibility = View.GONE
                mBinding.cardtext.visibility = View.GONE
                mBinding.holdernm.text = "Not Valid"

            }

            override fun onFailure(call: Call<BinList?>?, t: Throwable?) {
                progressDialog.dismiss()
            }
        })


    }

    inner class CreditCardNumberFormattingTextWatcher : TextWatcher {
        private var lock = false
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
        override fun afterTextChanged(editable: Editable) {
            if (!lock && editable.length <= 19) {
                lock = true
                var i = 4
                while (i < editable.length) {
                    if (editable.toString()[i] != ' ') {
                        editable.insert(i, " ")
                    }
                    i += 5
                }
                if (editable.length == 19) {
                   mStrArray = mBinding.creditCard.text.toString().replace(Regex("\\s+"), "")
                }
                if (editable.isEmpty()) {
                    mBinding.checkData.visibility = View.VISIBLE
                    mBinding.linRight.visibility = View.GONE
                    mBinding.linWrong.visibility = View.GONE
                    mBinding.cardtext.visibility = View.VISIBLE
                }
                lock = false
            }
        }
    }

    override fun onClick(p0: View?) {
        when(p0){
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
        }
    }

}