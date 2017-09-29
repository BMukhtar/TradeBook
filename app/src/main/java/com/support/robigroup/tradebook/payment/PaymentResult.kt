package com.support.robigroup.tradebook.payment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.main.MainActivity

class PaymentResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_result)
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
        fun open (con: Context, surrender: String){
            val intent = Intent(con,PaymentResult::class.java)
            intent.putExtra(ARG_SURRENDER,surrender)
            con.startActivity(intent)
        }
    }
}
