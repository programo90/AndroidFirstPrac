package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        findViewById<Button>(R.id.permission_btn).setOnClickListener {
            val checkCameraPermission = ContextCompat.checkSelfPermission(
                this@PermissionActivity
                , android.Manifest.permission.CAMERA
            )

            if(PackageManager.PERMISSION_GRANTED != checkCameraPermission) {
                //권한이 없음
                ActivityCompat.requestPermissions(
                    this
                    , arrayOf(android.Manifest.permission.CAMERA)
                    ,1000
                )
            } else {
                Log.d("permission", "already granted")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1000) {
            if(grantResults.get(0) == PackageManager.PERMISSION_GRANTED) {
                Log.d("permission : ", "granted")
            } else {
                Log.d("permission : ", "denied")
            }
        }
    }
}