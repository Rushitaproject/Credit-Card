package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.DBHandler.DbHandler
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.apiclient.APIClient
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.apiinterface.APIInterface
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCheckCcactivityBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.BinList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Easy_CheckCCActivity_8 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityCheckCcactivityBinding
    private lateinit var mStrArray: String
    private var mCO_Numeric: String? = null
    private var mCo_Alpha: String? = null
    private var mCo_Name: String? = null
    private var mCo_Currency: String? = null
    private var mCo_lattiude: String? = null
    private var mCo_longtitude: String? = null
    private var mBank_Name: String? = null
    private var mBank_Url: String? = null
    private var mBank_Phone: String? = null

    private var isAds :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCheckCcactivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
    }


    override fun onBackPressed() {
        finish()
    }

    private fun initViews() {
        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.binNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
            override fun afterTextChanged(editable: Editable) {
                val length: Int = mBinding.binNumber.length()
                if (length == 6) {
                    mStrArray = mBinding.binNumber.text.toString().toString().replace("\\s+".toRegex(), "")
                    DoBinList()
                }
                if (length == 0) {
                    mBinding.updateLin.visibility = View.GONE
                    mBinding.lottiBin.visibility = View.VISIBLE
                }
            }
        })

        mBinding.creditCard.addTextChangedListener(CreditCardNumberFormattingTextWatcher())
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
                if (editable.length == 7) {
                    mStrArray = mBinding.creditCard.text.toString().toString().replace("\\s+".toRegex(), "")
                    DoBinList()
                    hideKeyboard(this@Easy_CheckCCActivity_8)
                }
                if (editable.isEmpty()) {
                    mBinding.updateLin.visibility = View.GONE
                    mBinding.lottiBin.visibility = View.VISIBLE
                }
                lock = false
            }
        }
    }

    fun hideKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        var currentFocus = activity.currentFocus
        if (currentFocus == null) {
            currentFocus = View(activity)
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
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
            override fun onResponse(call: Call<BinList?>?, response: Response<BinList?>?) {
                progressDialog.dismiss()
                if (response!!.isSuccessful) {
                    if (response.body() != null) {
                        isAds = true
                        if (isAds){
                            isAds = false
                            hideKeyboard(this@Easy_CheckCCActivity_8)

                            nextActivity(response)

                        }

                    }

                    DbHandler(
                        this@Easy_CheckCCActivity_8
                    ).insertUserDetails(
                        mBinding.creditCard.text.toString(),
                        response.body()!!.brand,
                        response.body()!!.scheme
                    )
                    return
                }

                mBinding.holdername.text = "Not Valid"
                Toast.makeText(this@Easy_CheckCCActivity_8, "Not Valid", Toast.LENGTH_LONG).show()


            }

            override fun onFailure(call: Call<BinList?>?, t: Throwable?) {
                progressDialog.dismiss()
            }
        })


    }

    private fun nextActivity(response: Response<BinList?>) {
        isAds = false
        mBinding.IIN.text = mBinding.creditCard.text.toString()
        mBinding.updateLin.visibility = View.VISIBLE
        mBinding.lottiBin.visibility = View.GONE
        if (response.body()!!.number?.length!= null){
            mBinding.NUMBERLENGTH.text = response.body()!!.number?.length
        }else{
            mBinding.NUMBERLENGTH.text = "No Data Found"
        }

        if (response.body()!!.number?.luhn != null){
            mBinding.NUMBERLUHN.text = response.body()!!.number?.luhn
        }else{
            mBinding.NUMBERLUHN.text = "No Data Found"
        }

        if (response.body()!!.scheme != null){
            mBinding.SCHEME.text = response.body()!!.scheme
            mBinding.holdername.text = response.body()!!.scheme
        }else{
            mBinding.SCHEME.text = "No Data Found"
            mBinding.holdername.text = "No Data Found"
        }


        if (response.body()!!.type != null){
            mBinding.TYPE.text = response.body()!!.type
        }else{
            mBinding.TYPE.text = "No Data Found"
        }

        if (response.body()!!.brand != null){
            mBinding.BRAND.text = response.body()!!.brand
        }else{
            mBinding.BRAND.text = "No Data Found"
        }

        if (response.body()!!.prepaid != null){
            mBinding.PREPAID.text = response.body()!!.prepaid
        }else{
            mBinding.PREPAID.text = "No Data Found"
        }


        if (response.body()!!.country == null) {
            mBinding.COUNTRYNUMERIC.visibility = View.GONE
            mBinding.COUNTRYALPHA2.visibility = View.GONE
            mBinding.COUNTRYNAME.visibility = View.GONE
            mBinding.COUNTRYCURRENCY.visibility = View.GONE
            mBinding.COUNTRYLATITUDE.visibility = View.GONE
            mBinding.COUNTRYLATITUDE.visibility = View.GONE
        } else {
            mCO_Numeric = response.body()!!.country?.numeric
            if (mCO_Numeric != null){
                mCO_Numeric = response.body()!!.country?.numeric
                mBinding.COUNTRYNUMERIC.text = mCO_Numeric
            }else{
                mBinding.COUNTRYNUMERIC.text = "No Data Found"
            }

            mCo_Alpha = response.body()!!.country?.alpha2
            if (mCo_Alpha != null){
                mBinding.COUNTRYALPHA2.text = mCo_Alpha
            }else{
                mBinding.COUNTRYALPHA2.text = "No Data Found"
            }

            mCo_Name = response.body()!!.country?.name

            if (mCo_Name!= null){
                mBinding.COUNTRYNAME.text = mCo_Name
            }else{
                mBinding.COUNTRYNAME.text = "No Data Found"
            }

            mCo_Currency = response.body()!!.country?.currency

            if (mCo_Currency != null){
                mBinding.COUNTRYCURRENCY.text = mCo_Currency
            }else{
                mBinding.COUNTRYCURRENCY.text = "No Data Found"
            }

            mCo_lattiude = response.body()!!.country?.latitude

            if (mCo_lattiude != null){
                mBinding.COUNTRYLATITUDE.text = mCo_lattiude
            }else{
                mBinding.COUNTRYLATITUDE.text  = "No Data Found"
            }


            mCo_longtitude = response.body()!!.country?.longitude

            if (mCo_longtitude != null){
                mBinding.COUNTRYLATITUDE.text = mCo_longtitude
            }else{
                mBinding.COUNTRYLATITUDE.text = "No Data Found"
            }

        }
        if (response.body()!!.bank == null) {
            mBinding.BANKNAME.visibility = View.GONE
            mBinding.BANKURL.visibility = View.GONE
            mBinding.BANKPHONE.visibility = View.GONE
        } else {
            mBank_Name = response.body()!!.bank?.name

            if (mBank_Name!= null){
                mBinding.BANKNAME.text = mBank_Name
            }else{
                mBinding.BANKNAME.text = "No Data Found"
            }

            mBank_Url = response.body()!!.bank?.url
            if (mBank_Url != null){
                mBinding.BANKURL.text = mBank_Url
            }else{
                mBinding.BANKURL.text = "No Data Found"
            }

            mBank_Phone = response.body()!!.bank?.phone

            if (mBank_Phone!= null){
                mBinding.BANKPHONE.text = mBank_Phone
            }else{
                mBinding.BANKPHONE.text = "No Data Found"

            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            mBinding.ivBackBtn -> {
                onBackPressed()
            }
        }
    }

}