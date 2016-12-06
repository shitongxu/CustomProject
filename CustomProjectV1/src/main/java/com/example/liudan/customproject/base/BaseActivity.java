package com.example.liudan.customproject.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.liudan.customproject.app.AppManager;

/**
 * Created by liudan on 2016/11/16.
 * activity公用
 */

public abstract class BaseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        AppManager.getAppManager().addActivity(this);
    }
}
