package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCcofflineReportBinding
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.DataKeeper
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.second_btn_class
import android.content.Intent
import android.view.View
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit


class Easy_CCOfflineReportActivity_20 : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityCcofflineReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCcofflineReportBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViews()
        initViewAction()

    }
    override fun onRestart() {
        super.onRestart()
    }

    private fun initViewAction() {
        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.ivShareBtn.setOnClickListener(this)

        mBinding.konfettiView.start(
            Party(
                speed = 0f,
                maxSpeed = 30f,
                damping = 0.9f,
                spread = 360,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                position = Position.Relative(0.5, 0.3)
            )
        )    }

    private fun initViews() {
        mBinding.reportText.text = """1.${resources.getString(R.string.last_negative_item)}  :-  ${second_btn_class.f1}
    
    2.${resources.getString(R.string.count_following_accounts)}
            1.${resources.getString(R.string.credit_cards)} :- ${second_btn_class.f2}
            2.${resources.getString(R.string.mortgages)} :- ${second_btn_class.f3}
            3.${resources.getString(R.string.retail_finances)} :- ${second_btn_class.f4}
            4.${resources.getString(R.string.auto_loans)} :- ${second_btn_class.f5}
            5.${resources.getString(R.string.student_loans)} :- ${second_btn_class.f6}
            6.${resources.getString(R.string.other_loans)} :- ${second_btn_class.f7}
    
    3.${resources.getString(R.string.all_credit_limits)}  :-  ${second_btn_class.f8}
    
    4.${resources.getString(R.string.recent_balances)}  :-  ${second_btn_class.f9}
    
    5.${resources.getString(R.string.apply_credit)}  :-  ${second_btn_class.f10}
    
    6.${resources.getString(R.string.first_open_oldest_active)}  :-  ${second_btn_class.f11}
    
                        ${resources.getString(R.string.your_score_txt)}  :-  ${DataKeeper().score.toString()}
    
    """
    }

    fun createandDisplayPdf(str: String?) {
        mBinding.ivShareBtn.isEnabled = false
        startNewActivity(str)
    }


    private fun gotoNextActivity(str:String){
        mBinding.ivShareBtn.isEnabled = true
        share(str!!)
    }


    private fun startNewActivity(str: String?) {
        gotoNextActivity(str!!)
    }


    private fun share(str:String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.app_name))
        intent.putExtra(Intent.EXTRA_TEXT, str)
       startActivity(Intent.createChooser(intent, str))
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
            mBinding.ivShareBtn->{
                createandDisplayPdf(
                    """1.${resources.getString(R.string.last_negative_item).toString()}  :-  ${second_btn_class.f1.toString()}
    
    2.${resources.getString(R.string.count_following_accounts).toString()}
            1.${resources.getString(R.string.credit_cards).toString()} :- ${second_btn_class.f2.toString()}
            2.${resources.getString(R.string.mortgages).toString()} :- ${second_btn_class.f3.toString()}
            3.${resources.getString(R.string.retail_finances).toString()} :- ${second_btn_class.f4.toString()}
            4.${resources.getString(R.string.auto_loans).toString()} :- ${second_btn_class.f5.toString()}
            5.${resources.getString(R.string.student_loans).toString()} :- ${second_btn_class.f6.toString()}
            6.${resources.getString(R.string.other_loans).toString()} :- ${second_btn_class.f7.toString()}
    
    3.${resources.getString(R.string.all_credit_limits).toString()}  :-  ${second_btn_class.f8.toString()}
    
    4.${resources.getString(R.string.recent_balances).toString()}  :-  ${second_btn_class.f9.toString()}
    
    5.${resources.getString(R.string.apply_credit).toString()}  :-  ${second_btn_class.f10.toString()}
    
    6.${resources.getString(R.string.first_open_oldest_active).toString()}  :-  ${second_btn_class.f11.toString()}
    
                        ${resources.getString(R.string.your_score_txt).toString()}  :-  ${DataKeeper().score}
    
    """
                )
            }

        }
    }

    override fun onBackPressed() {
        nextActivity()
    }


    private fun nextActivity() {
        val resultInt = Intent()
        resultInt.putExtra("Added", "yesAdded")
        setResult(RESULT_OK, resultInt)
        finish()
    }

}