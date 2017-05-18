package com.example.zhaoqiang.ifservice;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * 判断一个指定的Service是否存在的方法
 */
public class MainActivity extends AppCompatActivity {

//    private static  Context context;
//    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public static boolean isServiceExisted(Context content, String className) {
        ActivityManager activityManager = (ActivityManager) content.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> servicelist = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (!(servicelist.size() > 0)) {
            return false;
        }

        for (int i = 0; i < servicelist.size(); i++) {
            ActivityManager.RunningServiceInfo serviceInfo = servicelist.get(i);
            ComponentName serviceName = serviceInfo.service;
            if (serviceName.getClassName().equals(className)) {
                return true;
            }
        }

        return false;

    }

}
