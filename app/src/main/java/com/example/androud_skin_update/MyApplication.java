package com.example.androud_skin_update;

import android.app.Application;

import com.example.skinlibrary.SkinManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);

    }
}
