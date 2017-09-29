package com.support.robigroup.tradebook.payment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.support.robigroup.tradebook.R
import kotlinx.android.synthetic.main.activity_pay.*

class PayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        setSupportActionBar(toolbar)
        val amount = intent.getStringExtra(ARG_AMOUNT)
        supportActionBar?.title = String.format("%s %s",getString(R.string.to_pay),amount)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun closeSale(v: View){
        PaymentResult.open(this,"1720")
        finish()
    }

    companion object {
        val ARG_AMOUNT = "amount"
        fun open (con: Context, amount: String){
            val intent = Intent(con,PayActivity::class.java)
            intent.putExtra(ARG_AMOUNT,amount)
            con.startActivity(intent)
        }
    }
}
