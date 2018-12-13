package com.sanjay.nfc;

import android.app.Application;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ProcessLifecycleOwner;

public class MyApp extends Application implements LifecycleObserver {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }


}