package com.example.serviceapp

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class ForegroundMusicService : Service() {

    private val CHANNEL_ID = "ForegroundService"
    private lateinit var player:MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.queen_we_are_the_champions)
        player.isLooping = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player.start()
        /*
        createNotificationChannel()
        //Devo chiamare lo start in foreground
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)
        var notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service Kotli Example")
            .setContentText("Stai ascoltando: Queen - We Are The Champions")
            .setSmallIcon(com.google.android.material.R.drawable.ic_mtrl_checked_circle)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1,notification)
         */
        return super.onStartCommand(intent, flags, startId)
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel(CHANNEL_ID, "Foreground Service Channel", NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}
