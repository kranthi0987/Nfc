package com.sanjay.nfc.shaker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        intent = new Intent(context, ShakeService.class);
        context.startService(intent);
    }
}