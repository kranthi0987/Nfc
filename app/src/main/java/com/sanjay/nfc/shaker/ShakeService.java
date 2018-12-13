package com.sanjay.nfc.shaker;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ShakeService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        if(MainActivity.shakingStarted) {
//            intent = new Intent(getApplicationContext(), MainActivity.class)
//                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//        }
        return super.onStartCommand(intent, flags, startId);
    }
}