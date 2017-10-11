package com.ljt.voicedemoserver;

import android.app.Application;

import com.iflytek.cloud.SpeechUtility;

/**
 * Created by ${JT.L} on 2017/10/10.
 */

public class MyApplication extends Application {


    private static final String APPID = "59dc735b";
    @Override
    public void onCreate() {
        super.onCreate();
        SpeechUtility.createUtility(MyApplication.this,"appid=" + getString(R.string.app_id));
    }
}
