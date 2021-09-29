package com.dipesh.mjpeg_stream

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dipesh.mjpegviewer.MjpegView


class MainActivity : AppCompatActivity() {
    private var view: MjpegView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.mjpegid)
        view!!.isAdjustHeight = true
        view!!.mode1 = MjpegView.MODE_FIT_WIDTH
        view!!.setUrl("http://192.168.0.12/video_feed")
        view!!.isRecycleBitmap1 = true


    }

    override fun onResume() {
        super.onResume()
        view!!.startStream()
        //view2.startStream();

    }

    override fun onPause() {
        super.onPause()
        view!!.stopStream()
        //view2.stopStream();

    }

    fun startService(v: View?) {
        //val input: String = editTextInput.getText().toString()
        val serviceIntent = Intent(this, ForegroundService::class.java)
        //serviceIntent.putExtra("inputExtra", input)
        startService(serviceIntent)
    }

    fun stopService(v: View){
        val stopIntent = Intent(this, ForegroundService::class.java)
        stopService(stopIntent)
    }
}