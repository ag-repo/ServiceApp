package com.example.serviceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener{
            //val intentBg = Intent(this, BackgroundMusicService::class.java)
            //startService(intentBg)
            val intentFg = Intent(this, ForegroundMusicService::class.java)
            startService(intentFg)
        }

        btn_stop.setOnClickListener{
            val intentFg = Intent(this, ForegroundMusicService::class.java)
            stopService(intentFg)
        }
    }
}