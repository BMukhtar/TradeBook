package com.support.robigroup.tradebook.tovar_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.adapter.Tovar
import kotlinx.android.synthetic.main.activity_check.*
import java.util.ArrayList

class CheckActivity : AppCompatActivity() {

    private var mDataSet = ArrayList<Tovar>()
    lateinit var mAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)
        supportActionBar?.title = "Чек"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tovar1 = Tovar("Coca-Cola Zero, 1л", "Без скидки", "260")
        val tovar2 = Tovar("Печенья Орео, мягкая упаковка, 250 гр", "Без скидки", "1000")
        val tovar3 = Tovar("Советское шампаское", "Скидка 50%", "1800")

        mDataSet.add(tovar1)
        mDataSet.add(tovar2)
        mDataSet.add(tovar3)

        mAdapter = MyAdapter(mDataSet)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = mAdapter

    }
}
