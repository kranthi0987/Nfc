package com.sanjay.nfc.Camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.sanjay.nfc.MainActivity;

public class camera extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
// Prevent other apps from launching
        abortBroadcast();
// Your Program
        Intent startActivity = new Intent();
        startActivity.setClass(context, MainActivity.class);
        startActivity.setAction(MainActivity.class.getName());
        startActivity.setFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(startActivity);
    }
}

