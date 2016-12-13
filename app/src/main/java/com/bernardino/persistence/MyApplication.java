package com.bernardino.persistence;

import android.app.Application;
import android.content.Context;

import com.bernardino.persistence.dao.DBHelper;
import com.bernardino.persistence.dao.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * Created by rm31243 on 12/12/2016.
 */
public class MyApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        this.context = getApplicationContext();
        DatabaseManager.initializeInstance(new DBHelper());
    }

    public static Context getContext() {
        return context;
    }
}
