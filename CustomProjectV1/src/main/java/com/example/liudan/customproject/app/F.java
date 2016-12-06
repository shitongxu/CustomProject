package com.example.liudan.customproject.app;

import android.app.Application;
import android.support.annotation.NonNull;

/**
 * Created by liudan on 2016/11/16.
 *
 */

public class F {
    private static Application application;
    public static void init(@NonNull Application a){
        application=a;
    }

    public static Application getApplication() {
        return application;
    }
}
