package com.example.lizheng.greendaotest;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * @author lizheng
 * create at 2019/2/22
 * description:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaoHelper.setupDatabase(this);
        Stetho.initializeWithDefaults(this);
    }


}
