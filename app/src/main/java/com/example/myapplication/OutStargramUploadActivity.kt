package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.net.URI

class OutStargramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stargram_upload)

        findViewById<TextView>(R.id.outstar_view_pictures).setOnClickListener {
            val checkExternalStoragePermission = ContextCompat.checkSelfPermission(
                this@OutStargramUploadActivity
            ,android.Manifest.permission.READ_EXTERNAL_STORAGE
            )

            if(PackageManager.PERMISSION_GRANTED != checkExternalStoragePermission) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1100
                )

                val reCheckExternalStoragePermission = ContextCompat.checkSelfPermission(
                    this@OutStargramUploadActivity
                    ,android.Manifest.permission.READ_EXTERNAL_STORAGE)

                if(PackageManager.PERMISSION_GRANTED == reCheckExternalStoragePermission) {
                    getPicture()
                } else {
                    Toast.makeText(this,"권한 동의가 필요합니다.", Toast.LENGTH_LONG)
                }
            } else {
                getPicture()
            }
        }

        findViewById<TextView>(R.id.outstar_view_upload).setOnClickListener {
            uploadPost()
        }


        // navi
        findViewById<TextView>(R.id.outstar_list_all).setOnClickListener {
            startActivity(Intent(this, OutStargramPostListActivity::class.java))
        }

        findViewById<TextView>(R.id.outstar_list_my).setOnClickListener {
            startActivity(Intent(this, OutstarMyPostListActivity::class.java))
        }

        /*findViewById<TextView>(R.id.outstar_list_upload).setOnClickListener {
            startActivity(Intent(this, OutStargramUploadActivity::class.java))
        }*/

        findViewById<TextView>(R.id.outstar_list_info).setOnClickListener {
            startActivity(Intent(this, OutstargramUserInfo::class.java))
        }



    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1100) {
            if(grantResults.get(0) == PackageManager.PERMISSION_GRANTED) {
                Log.d("storage permission : ", "granted")
            } else {
                Log.d("storage permission : ", "denied")
            }
        }
    }

    fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1000) {
            val uri: Uri = data!!.data!!
            filePath = getImageFilePath(uri)
        }
    }


    fun getImageFilePath(contentUri:Uri):String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection,null, null, null)
        if(cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost() {
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image",file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : retrofit2.Callback<OutStarPost>{
            override fun onFailure(call: Call<OutStarPost>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<OutStarPost>, response: Response<OutStarPost>) {
                if(response.isSuccessful) {
                    val post = response.body()
                    Log.d("path : " , post!!.content.toString())
                    finish()
                    startActivity(Intent(this@OutStargramUploadActivity, OutstarMyPostListActivity::class.java))
                }
            }
        })
    }

    fun getContent():String{
        return findViewById<EditText>(R.id.outstar_content_input).text.toString()
    }
}