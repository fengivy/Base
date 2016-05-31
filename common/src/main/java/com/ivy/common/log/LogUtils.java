package com.ivy.common.log;

import android.util.Log;

/**
 * Created by ivy on 2016/5/31.
 */
public class LogUtils {
    public static void e(String tag,String value){
        Log.e(tag,value);
    }

    public static void d(String tag,String value){
        Log.d(tag,value);
    }

    public static void v(String tag,String value){
        Log.v(tag,value);
    }

    public static void i(String tag,String value){
        Log.i(tag,value);
    }
}
