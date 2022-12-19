package com.example.androud_skin_update;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.skinlibrary.SkinManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class SkinActivity extends Activity {


    private String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);

        path = getExternalFilesDir(null).getPath();
        try {
            InputStream inputStream = getAssets().open("skin-debug.apk");

            File file = new File(path, "skin");
            if (!file.exists()) {
                file.mkdirs();
            }
            File apkFile = new File(file, "skin-debug.apk");
            if (apkFile.exists()) {
                apkFile.delete();
            }
            apkFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(apkFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[2048];
            int count;
            while ((count = inputStream.read(bytes)) != -1) {
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
        SkinManager.getInstance().loadSkin(path + "/skin/skin-debug.apk");
    }

    public void restore(View view) {
        SkinManager.getInstance().loadSkin(null);
    }
}
