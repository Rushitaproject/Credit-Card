package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.ClipboardManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.R
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCconlineMainBinding

class Easy_CCOnlineMainActivity_15 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCconlineMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCconlineMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding.ivCsWebsiteTxt.isSelected = true

        var number = intent.getIntExtra("number",0)
        when(number){
            1->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.home_score_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.home_score_website_txt)
            }
            2->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.buy_score_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.buy_score_website_txt)
            }
            3->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.com_score_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.com_score_website_txt)
            }
            4->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.cal_score_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.cal_score_website_txt)
            }
            5->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.dis_score_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.dis_score_website_txt)
            }
            6->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.media_score_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.media_score_website_txt)
            }
            7->{
                mBinding.ivCardview.visibility = View.VISIBLE
                mBinding.ivCardview2.visibility = View.VISIBLE
                mBinding.ivCopyLinkBtn.visibility = View.VISIBLE
                mBinding.ivScorllview.visibility = View.GONE
                mBinding.ivCsOnlineTxt.text = resources.getText(R.string.credit_mantri_txt)
                mBinding.ivCsWebsiteTxt.text = resources.getText(R.string.credit_mantri_website_txt)
            }
            8->{
                mBinding.ivCardview.visibility = View.GONE
                mBinding.ivCardview2.visibility = View.GONE
                mBinding.ivCopyLinkBtn.visibility = View.GONE
                mBinding.lottiOnline.visibility = View.GONE
                mBinding.ivScorllview.visibility = View.VISIBLE

            }

        }


        initViews()

    }

    override fun onRestart() {
        super.onRestart()
       
    }

    private fun initViews() {
        mBinding.ivCopyLinkBtn.setOnClickListener(this)
        mBinding.ivBackBtn.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivCopyLinkBtn->{
                gotoAdActivity()


            }
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
        }
    }

    private fun gotoAdActivity() {
        mBinding.ivCopyLinkBtn.isEnabled =true
        when(intent.getIntExtra("number",0)){
            1->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.home_score_website_txt)

            }
            2->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.buy_score_website_txt)
            }
            3->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.com_score_website_txt)
            }
            4->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.cal_score_website_txt)
            }
            5->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.dis_score_website_txt)
            }
            6->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.media_score_website_txt)
            }
            7->{
                (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).text = resources.getText(R.string.credit_mantri_website_txt)
            }
        }
        Toast.makeText(this,"Linked Copied",Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {

        finish()


    }
}