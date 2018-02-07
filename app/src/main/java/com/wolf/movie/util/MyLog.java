package com.wolf.movie.util;

import android.util.Log;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by W.J on 2018/2/7.
 */

public class MyLog {
    public static void i(String tag,String msg){
        Log.i(tag,msg);
    }
    public static void s(String tag,Object msg){
        LogUtils.i(tag,msg);
    }
    public static void s(Object msg){
        LogUtils.i(msg);
    }
}
