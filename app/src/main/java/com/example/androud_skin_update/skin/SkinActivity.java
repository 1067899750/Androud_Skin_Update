package com.example.androud_skin_update.skin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;


import com.example.androud_skin_update.R;
import com.example.skinlibrary.SkinManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SkinActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LayoutInflater.from(this).setFactory2();
        setContentView(R.layout.activity_skin);

//        findViewById(R.id.tabLayout);
//        Resources resources = getResources();
//        new Resources()
        ///storage/emulated/0/Android/data/com.example.androud_skin_update/files
        String path = getCacheDir().getPath();
        try {
            InputStream inputStream = getAssets().open("skin-debug.apk");

            File file = new File(path, "skin");
            if (!file.exists()){
                file.mkdirs();
            }
            File apkFile = new File(file, "skin-debug.apk");
            if (apkFile.exists()){
                apkFile.delete();
            }
            apkFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(apkFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[2048];
            int count;
            while ((count = inputStream.read(bytes)) !=  -1){
                bos.write(bytes, 0, count);
            }

            bos.close();
            fos.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void change(View view) {
        //换肤，收包裹，皮肤包是独立的apk包，可以来自网络下载
        String path = getCacheDir().getPath();
        SkinManager.getInstance().loadSkin(path + "/skin/skin-debug.apk");
    }

    public void restore(View view) {
        SkinManager.getInstance().loadSkin(null);
    }
}
