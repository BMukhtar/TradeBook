package com.support.robigroup.tradebook.payment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.main.MainActivity
import kotlinx.android.synthetic.main.activity_payment_result.*

class PaymentResult : AppCompatActivity() {

    var price = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_result)
        price = intent.getDoubleExtra(ARG_SURRENDER,0.0)
        price_sdacha.text = String.format("%.2f тенге",price)
    }

    fun closePayment(v: View){
        MainActivity.open(this)
        finish()
    }

    fun printoutCheck(v: View){
        MainActivity.open(this)
        finish()
    }

    companion object {
        val ARG_SURRENDER = "surrender"
        fun open (con: Context, surrender: Double){
            val intent = Intent(con,PaymentResult::class.java)
            intent.putExtra(ARG_SURRENDER,surrender)
            con.startActivity(intent)
        }
    }
}
