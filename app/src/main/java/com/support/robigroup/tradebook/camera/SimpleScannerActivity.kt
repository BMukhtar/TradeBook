package com.support.robigroup.tradebook.camera

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast

import com.google.zxing.Result
import com.support.robigroup.tradebook.R
import com.support.robigroup.tradebook.tovar_list.ChequeActivity

import java.util.ArrayList

import me.dm7.barcodescanner.zxing.ZXingScannerView

class SimpleScannerActivity : Activity(), ZXingScannerView.ResultHandler {
    private var mScannerView: ZXingScannerView? = null
    private val TAG = "myLogs"
    private val tovars = ArrayList<String>()

    public override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        mScannerView = ZXingScannerView(this)   // Programmatically initialize the scanner view
        setContentView(R.layout.activity_scanner)
        val fr = findViewById<FrameLayout>(R.id.container_camera)
        fr.addView(mScannerView)
    }

    public override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView!!.startCamera()          // Start camera on resume
    }

    public override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()           // Stop camera on pause
    }

    fun closeFun(v: View) {
        finish()
    }

    fun openCheque(v: View) {
        ChequeActivity.open(this,"4560")
    }

    override fun handleResult(rawResult: Result) {
        // Do something with the result here
        Log.e(TAG, rawResult.text) // Prints scan results
        Log.e(TAG, rawResult.barcodeFormat.toString()) // Prints the scan format (qrcode, pdf417 etc.)
        val res = rawResult.text
        if (!tovars.contains(res)) {
            Toast.makeText(this, "Товар добавлен", Toast.LENGTH_SHORT).show()
            tovars.add(res)
        }else{
            Toast.makeText(this, "Товар уже добавлен", Toast.LENGTH_SHORT).show()
        }
        // If you would like to resume scanning, call this method below:
        mScannerView!!.resumeCameraPreview(this)

    }
}