package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .build()
        // deleteRealmIfMigrationNeede()
        // 기존 Realm에 Attribute가 추가 되면서 마이그레이션이 필요할 경우
        // Realm을 초기화(테이블삭제) 하는 메서드
        Realm.setDefaultConfiguration(config)

        val ream = Realm.getDefaultInstance()

        findViewById<Button>(R.id.realm_btn_save).setOnClickListener {
            ream.executeTransaction{
                with(it.createObject(School::class.java)) {
                    this.name = "서울대"
                    this.location = "서울"
                }
            }
        }

        findViewById<Button>(R.id.realm_btn_load).setOnClickListener {
            ream.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("data1",data.toString())
            }
        }

        findViewById<Button>(R.id.realm_btn_delete).setOnClickListener {
            ream.executeTransaction {
                it.where(School::class.java).findAll().deleteFromRealm(0)
            }
        }
    }
}