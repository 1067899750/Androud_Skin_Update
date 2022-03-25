package com.example.androud_skin_update;

import android.app.Application;
import android.content.Context;

import com.example.skinlibrary.SkinManager;

/**
 * @author puyantao
 * @description :
 * @date 2022/3/25
 */
public class SkinApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);
    }
}
