package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.HistoryItemLayoutBinding
import java.util.HashMap

class Easy_HistoryAdapter (var mContext:Context, var mHistoryList:ArrayList<HashMap<String, String>>, var mOnClick: onClick, var view: View): RecyclerView.Adapter<Easy_HistoryAdapter.ItemViewHolder>() {


    class ItemViewHolder(val mHistoryBinding:HistoryItemLayoutBinding) : RecyclerView.ViewHolder(mHistoryBinding.root)

    interface onClick{
        fun onDeleteBtnClick(id:Int,pos:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(HistoryItemLayoutBinding.inflate(LayoutInflater.from(mContext),parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.mHistoryBinding.name.text = mHistoryList[position]["name"]
        holder.mHistoryBinding.cardType.text = mHistoryList[position]["designation"]

        holder.mHistoryBinding.ivDelete.setOnClickListener {
            mOnClick.onDeleteBtnClick(mHistoryList[position]["id"]!!.toInt(),position)
            mHistoryList.removeAt(position)
            notifyDataSetChanged()
            if (mHistoryList.size == 0){
                view.visibility = View.VISIBLE
            }else{
                view.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return mHistoryList.size
    }
}