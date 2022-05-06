package com.example.serviceapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

class BoundMusicService : Service() {

    private lateinit var player:MediaPlayer
    private val binder: IBinder = LocalBinder()

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.queen_we_are_the_champions)
        player.isLooping = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    fun getDuration(): Int{
        return player.duration
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    inner class LocalBinder: Binder(){
        fun getService(): BoundMusicService = this@BoundMusicService
    }
}
