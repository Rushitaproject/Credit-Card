package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityFullFromForthBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Easy_FullFromForthActivity_28 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityFullFromForthBinding


    val myCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFullFromForthBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewAction()
    }

    private fun initViewAction() {
        mBinding.ivNextBtn.setOnClickListener(this)

        mBinding.ivBackBtn.setOnClickListener(this)

        val date =
            OnDateSetListener { view, year, month, day ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, day)
                updateLabel()
            }
        mBinding.ebirth.setOnClickListener(View.OnClickListener {

            DatePickerDialog(
                this@Easy_FullFromForthActivity_28,
                date,
                myCalendar[Calendar.YEAR],
                myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH]
            ).show()
        })
    }



    override fun onClick(v: View?) {
        when(v){
            mBinding.ivNextBtn->{
                val checkedRadioButtonId: Int = mBinding.gradio.getCheckedRadioButtonId()
                if (mBinding.ebirth.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromForthActivity_28,"Please select date of birth", Toast.LENGTH_SHORT).show()
                }else if (checkedRadioButtonId == -1){
                    Toast.makeText(this@Easy_FullFromForthActivity_28,"No Gender has been selected", Toast.LENGTH_SHORT).show()
                }else if (mBinding.eemail.text.toString().equals("")){
                    Toast.makeText(this@Easy_FullFromForthActivity_28,"Please Enter Email Address", Toast.LENGTH_SHORT).show()
                } else if (!Patterns.EMAIL_ADDRESS.matcher(mBinding.eemail.text.toString()).matches()){
                    Toast.makeText(this@Easy_FullFromForthActivity_28,"Please Enter Valid Email", Toast.LENGTH_SHORT).show()
                }else{
                    neatActivity()
                }
            }
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
        }
    }

    private fun neatActivity() {
        activityResultLauncher.launch(Intent(this@Easy_FullFromForthActivity_28, Easy_SubmitFromActivity_29::class.java))
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
            resultInt.putExtra("Added", result.data!!.getStringExtra("Added"))
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

    private fun updateLabel() {
        val myFormat = "dd/MM/yy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        mBinding.ebirth.setText(dateFormat.format(myCalendar.time))
    }


    private fun getAge(dobString: String): Int {
        var date: Date? = null
        val sdf = SimpleDateFormat("dd/MM/yy")
        try {
            date = sdf.parse(dobString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (date == null) return 0
        val dob = Calendar.getInstance()
        val today = Calendar.getInstance()
        dob.time = date
        val year = dob[Calendar.YEAR]
        val month = dob[Calendar.MONTH]
        val day = dob[Calendar.DAY_OF_MONTH]
        dob[year, month + 1] = day
        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }
        return age
    }

}