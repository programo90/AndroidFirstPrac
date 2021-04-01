package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class BarcodeReaderActivity : AppCompatActivity() {
    private val TAG = "ReaderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode_reader)
    }

    override fun onResume() {
        super.onResume()

        val integrator = IntentIntegrator(this)
        integrator.setCaptureActivity(CodeCaptureActivity::class.java)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG,"result : "+resultCode)
        if(resultCode == Activity.RESULT_OK) {
            val scanResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
            val message = scanResult.contents
            Log.d(TAG,message)
            Toast.makeText(this,"result : "+ message, Toast.LENGTH_LONG).show()
        }
    }
}