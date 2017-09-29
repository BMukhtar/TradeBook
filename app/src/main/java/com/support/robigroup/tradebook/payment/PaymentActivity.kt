package com.support.robigroup.tradebook.payment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.support.robigroup.tradebook.R

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        supportActionBar?.title = "Оплата"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun openPayActivity(v: View){
        PayActivity.open(this,"3280")
    }

    companion object {
        val ARG_OPLATA = "oplata"
        fun open(con: Context, oplata: String){
            val intent = Intent(con, PaymentActivity::class.java)
            intent.putExtra(ARG_OPLATA, oplata)
            con.startActivity(intent)
        }
    }
}
