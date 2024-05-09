package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.DBHandler.DbHandler
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adapter.Easy_HistoryAdapter
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivityCchistoryBinding

class Easy_CCHistoryActivity_11 : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding:ActivityCchistoryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCchistoryBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        initViews()


        if (DbHandler(
                this
            ).GetUsers().size == 0){
            mBinding.conNoData.visibility = View.VISIBLE
            mBinding.ivRecylerview.visibility = View.GONE
        }else{
            mBinding.conNoData.visibility = View.GONE
            mBinding.ivRecylerview.visibility = View.VISIBLE
        }
        mBinding.ivRecylerview.adapter = Easy_HistoryAdapter(this,
            DbHandler(this).GetUsers(), object : Easy_HistoryAdapter.onClick{
            override fun onDeleteBtnClick(id: Int,pos:Int) {
                DbHandler(this@Easy_CCHistoryActivity_11).DeleteUser(id)

            }

        },mBinding.conNoData)
        mBinding.ivRecylerview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)


    }

    private fun initViews() {
        mBinding.ivBackBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            mBinding.ivBackBtn->{
              
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {

        finish()


    }
}