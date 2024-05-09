package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adapter.Easy_SelectCardAdapter
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivitySelectCardBinding

class Easy_SelectCardActivity_4 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivitySelectCardBinding
    private var mCardList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySelectCardBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
       

        mCardList.add("Master Card")
        mCardList.add("Visa")
        mCardList.add("Switch / Solo")
        mCardList.add("Master Card")
        mCardList.add("Amex")
        mCardList.add("Rupay")
        mCardList.add("JCB")
        mCardList.add("Dankort")
        mCardList.add("Discover")
        
        mBinding.ivRecyclerview.adapter = Easy_SelectCardAdapter(this,
            mCardList, object : Easy_SelectCardAdapter.onClick{
            override fun onBtnClick(view: View) {
                view.isEnabled = false
                startNewActivity(view)
            }
        })
        mBinding.ivRecyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        initViewAction()

    }

    private fun initViewAction() {
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    private fun startNewActivity(view: View) {
        nextActivity(view)
    }

    private fun nextActivity(pos: View) {
        pos.isEnabled = true
        startActivity(Intent(this, Easy_SelectYourTypeActivity_5::class.java))
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivBackBtn->{
                onBackPressed()
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onBackPressed() {
        finish()
    }
}