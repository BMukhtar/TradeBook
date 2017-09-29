package com.support.robigroup.tradebook.tovar_list

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.adapter.Tovar
import com.support.robigroup.tradebook.payment.PayActivity
import com.support.robigroup.tradebook.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_check.*
import java.util.ArrayList

class ChequeActivity : AppCompatActivity() {

    private var mDataSet = ArrayList<Tovar>()
    lateinit var mAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)
        supportActionBar?.title = "Чек"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tovar1 = Tovar(R.drawable.image_cola,"Coca-Cola Zero, 1л", "Без скидки", "260")
        val tovar2 = Tovar(R.drawable.image_oreo,"Печенья Орео", "Без скидки", "1000")
        val tovar3 = Tovar(R.drawable.image_shampan,"Советское шампаское", "Скидка 50%", "1800")

        mDataSet.add(tovar1)
        mDataSet.add(tovar2)
        mDataSet.add(tovar3)

        mAdapter = MyAdapter(mDataSet)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
    }

    fun payAmount(v: View){
        PaymentActivity.open(this,"3280")
    }

    companion object {
        val ARG_OPLATA = "oplata"
        fun open(con: Context, oplata: String){
            val intent = Intent(con, ChequeActivity::class.java)
            intent.putExtra(ARG_OPLATA, oplata)
            con.startActivity(intent)

        }
    }
}
