package com.support.robigroup.tradebook.tovar_list

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.support.robigroup.tradebook.payment.PaymentActivity
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.adapter.Tovar
import java.util.ArrayList

class MyAdapter(private val mListener: ChequeActivity,private var mDataSet: ArrayList<Tovar>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mDataSet[position]
        holder.mNameText.text = item.name
        holder.mDescText.text = item.skidka
        holder.mPrice.text = String.format("%d %s",(item.price*item.count),"тенге")
        holder.mImage.setImageResource(item.image)
        holder.mCountText.text = item.count.toString()
        holder.mButtonMinus.setOnClickListener {
            if(item.count>1){
                item.count--
                notifyItemChanged(position)
                mListener.updatePayPrice()
            }
        }
        holder.mButtonPlus.setOnClickListener {
            item.count++
            notifyItemChanged(position)
            mListener.updatePayPrice()
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    fun getTotalPrice(): Double{
        var res = 0.0
        for(item in mDataSet){
            res += item.count*item.price
        }
        return res
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_tovar, parent, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var mNameText = view.findViewById<TextView>(R.id.name)
        var mCountText = view.findViewById<TextView>(R.id.count_text)
        var mImage = view.findViewById<ImageView>(R.id.tovar_image)
        var mDescText = view.findViewById<TextView>(R.id.tovar_desk)
        var mPrice = view.findViewById<TextView>(R.id.tovar_price)
        var mButtonPlus = view.findViewById<ImageButton>(R.id.imb_plus)
        var mButtonMinus = view.findViewById<ImageButton>(R.id.imb_minus)
        var mItem: Tovar? = null
    }
}