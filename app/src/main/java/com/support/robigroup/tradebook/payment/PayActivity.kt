package com.support.robigroup.tradebook.payment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.support.robigroup.tradebook.R
import kotlinx.android.synthetic.main.activity_pay.*
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem


class PayActivity : AppCompatActivity() {
    var price = 0.0
    var clientAmount: Double? = null
    var surrender = -1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        setSupportActionBar(toolbar)

        price = intent.getDoubleExtra(ARG_AMOUNT,0.0)

        supportActionBar?.title = String.format("%s %.2f т",getString(R.string.to_pay),price)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if(price==0.0){
            Snackbar.make(findViewById(android.R.id.content),"An Error Occured", Snackbar.LENGTH_SHORT)
            finish()
        }
        editClientMoney.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int,count: Int) {
                if (s != "") {
                    updateSurrender(s.toString())
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int,after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    fun updateSurrender(amount: String){
        val am = amount.toDouble()
        surrender = am - price
        if(surrender < 0.0){
            text_sdacha.text = getString(R.string.error_amount)
        }else{
            text_sdacha.text = String.format("%.2f тенге", surrender)
        }
    }


    fun closeSale(v: View){
        if(surrender>=0.0)
        {
            PaymentResult.open(this,surrender)
            finish()
        }else{
            Snackbar.make(findViewById(android.R.id.content),getString(R.string.error_amount),Snackbar.LENGTH_SHORT).show()
        }

    }

    companion object {
        val ARG_AMOUNT = "amount"
        fun open (con: Context, amount: Double){
            val intent = Intent(con,PayActivity::class.java)
            intent.putExtra(ARG_AMOUNT,amount)
            con.startActivity(intent)
        }
    }
}
