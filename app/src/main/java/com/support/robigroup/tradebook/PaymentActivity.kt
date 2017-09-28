package com.support.robigroup.tradebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        supportActionBar?.title = "Оплата"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
