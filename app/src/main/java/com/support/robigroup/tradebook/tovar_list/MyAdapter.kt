package com.support.robigroup.tradebook.tovar_list

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.support.robigroup.tradebook.PaymentActivity
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.adapter.Tovar
import java.util.ArrayList

class MyAdapter(private var mDataSet: ArrayList<Tovar>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mNameText.text = mDataSet[position].name
        holder.mDescText.text = mDataSet[position].skidka
        holder.mPrice.text = mDataSet[position].price + " тенге"
        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context,PaymentActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_tovar, parent, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        var mNameText = view.findViewById<TextView>(R.id.name)
        var mImage = view.findViewById<ImageView>(R.id.tovar_image)
        var mDescText = view.findViewById<TextView>(R.id.tovar_desk)
        var mPrice = view.findViewById<TextView>(R.id.tovar_price)
    }
}