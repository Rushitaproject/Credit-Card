package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.CardItemLayoutBinding

class Easy_SelectCardAdapter(var mContext:Context, var mCardList:ArrayList<String>, var mOnClick: onClick) : RecyclerView.Adapter<Easy_SelectCardAdapter.MyViewHolder>() {
    interface onClick{
        fun onBtnClick(view: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CardItemLayoutBinding.inflate(LayoutInflater.from(mContext),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.mBinding.ivCardName.text = mCardList[position]
        holder.mBinding.root.setOnClickListener {
            mOnClick.onBtnClick(holder.mBinding.root)
        }
    }

    override fun getItemCount(): Int {
        return mCardList.size
    }

    class  MyViewHolder (val mBinding:CardItemLayoutBinding):RecyclerView.ViewHolder(mBinding.root)
}