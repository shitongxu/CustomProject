package com.example.liudan.customproject.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.example.liudan.customproject.app.AppManager;

/**
 * Created by liudan on 2016/11/16.
 * fragment公用
 */

public abstract class BaseFragmentActivity  extends FragmentActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        AppManager.getAppManager().addActivity(this);
    }
}
