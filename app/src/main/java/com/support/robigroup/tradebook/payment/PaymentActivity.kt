package com.support.robigroup.tradebook.payment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.tovar_list.ChequeActivity
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    var mNoSki = 0.0
    var mSki = 0.0
    var mWithScki = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Оплата"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mNoSki = intent.getDoubleExtra(ARG_NO_SKI,0.0)
        mSki = intent.getDoubleExtra(ARG_SKI,0.0)
        mWithScki = ChequeActivity.getPayPrice(mNoSki,mSki)
        ski.text = String.format("%.2f * %.2f",mSki,mNoSki)
        no_ski.text = String.format("%.2f",mNoSki)
        with_ski.text = String.format("%.2f",mWithScki)




    }

    fun openPayActivity(v: View){
        PayActivity.open(this,mWithScki)
    }

    companion object {
        val ARG_NO_SKI = "no"
        val ARG_SKI = "ski"
        fun open(con: Context, noSki: Double, ski: Double){
            val intent = Intent(con, PaymentActivity::class.java)
            intent.putExtra(ARG_NO_SKI, noSki)
            intent.putExtra(ARG_SKI, ski)
            con.startActivity(intent)
        }
    }
}
