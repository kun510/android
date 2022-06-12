package com.example.baothuchihi;

import android.app.Service;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class nhacbaothuc extends Service {
    MediaParser mediaParser = MediaParser.create(MainActivity.this,R.raw.nhacchuong);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaParser.start();
        Log.e("Toi trong sdsadas","saasdasdasd");
        return START_NOT_STICKY;
    }
}