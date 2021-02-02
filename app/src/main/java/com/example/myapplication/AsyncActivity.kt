package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val progressbar = findViewById<ProgressBar>(R.id.asyn_progressbar)
        val textView = findViewById<TextView>(R.id.asyn_text)

        var task: BackgroundAsyncTask? = null
        findViewById<Button>(R.id.asyn_start_btn).setOnClickListener {
            task = BackgroundAsyncTask(progressbar, textView)
            task?.execute()
        }

        findViewById<Button>(R.id.asyn_cancel_btn).setOnClickListener {
            task?.cancel(true)
        }
    }
}

class BackgroundAsyncTask(
    val progressbar: ProgressBar
    ,val progresstext: TextView
): AsyncTask<Int,Int,Int>(){
    // params - doInBackground 에서 사용할 타입
    // progress - onProgressUpdate 에서 사용할 타입
    // result - onPostExecute 에서 사용할 타입
    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled() == false) {
            percent++
            if(percent>100) break
            else publishProgress(percent)

            try {
                Thread.sleep(100)
            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0)
        progresstext.setText("Percent : "+values[0])
    }

    override fun onPostExecute(result: Int?) {
        progresstext.setText("Completed!")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progresstext.setText("Task canceled")
    }
}