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

        //3 bottoni dopo
        btn_bindService.setOnClickListener{
            val intentFg = Intent(this, BoundMusicService::class.java)
            bindService(intent, servConn, BIND_AUTO_CREATE)

        }

        btn_unbindService.setOnClickListener{
            val intentFg = Intent(this, BoundMusicService::class.java)
            stopService(intentFg)
        }

        btn_useService.setOnClickListener{
            val intentFg = Intent(this, BoundMusicService::class.java)
            stopService(intentFg)
        }
    }
}