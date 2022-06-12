package com.example.baothuchihi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
class Peoplenhan extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("asdasd","asdasdas");
        Intent myIntent = new Intent(context,nhacbaothuc.class);
        context.startService(myIntent);
    }
}
