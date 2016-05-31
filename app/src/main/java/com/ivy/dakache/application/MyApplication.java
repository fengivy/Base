package com.ivy.dakache.application;

import android.app.Application;

/**
 * Created by ivy on 2016/5/31.
 */
public class MyApplication extends Application{
    private static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }

    public static MyApplication getApplication(){
        return myApplication;
    }
}
