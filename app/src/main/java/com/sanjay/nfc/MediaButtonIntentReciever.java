package com.sanjay.nfc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class MediaButtonIntentReciever extends BroadcastReceiver {
    private static final String TAG = MediaButtonIntentReciever.class.getSimpleName();

    private static long prevTime;

    private static boolean isSingleCall = false;

    public MediaButtonIntentReciever() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                Log.d(TAG, "media button action recieved");
                if (intent.getExtras() != null) {
                    int prevVolume = intent.getExtras().getInt("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0);
                    int currentValue = intent.getExtras().getInt("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);

                    AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                    int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

                    //Forunlocking only one event will trigger. When phone is open ui popup will also trigger the volume change
                    boolean volumeAction = false;
                    if ((currentValue == 0 && prevVolume == 0) || currentValue == maxVolume && prevVolume == maxVolume) {
                        if (!isSingleCall) {
                            isSingleCall = true; // Wait for ui volume change call
                        } else {
                            isSingleCall = false;   //Resetting value
                            volumeAction = true;
                        }
                    } else if (currentValue != 0 && prevVolume != 0 && currentValue != prevVolume) {
                        volumeAction = true;
                    }


                }
            } else {
                Log.d(TAG, "uncached intent arrived");
            }
        } else {
            Log.d(TAG, "null Intent recieved");
        }
    }

}