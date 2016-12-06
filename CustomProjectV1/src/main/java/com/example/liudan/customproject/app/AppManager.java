package com.example.liudan.customproject.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by liudan on 2016/11/16.
 * 应用程序Activity管理类:用于activity管理和应用程序退出
 */

public class AppManager {
    private static Stack<Activity> activityStack;
private static AppManager instance=new AppManager();
    public AppManager() {
        activityStack=new Stack<>();
    }

    /**
     * 单一实例
     * @return
     */
    public  static AppManager getAppManager(){
        return instance;
    }
    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity){
        activityStack.add(activity);
    }
    /**
     * 结束所有的activity
     */
    private void finishAllActivity(){
        for (Activity activity:activityStack) {
            if (activity!=null){
                activity.finish();
            }
        }
        activityStack.clear();
    }
    /**
     * 退出应用程序
     */
    public void AppExit(Context context){
        finishAllActivity();
        ActivityManager activityMgr = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        activityMgr.killBackgroundProcesses(context.getPackageName());
    }
    public void removeActivity(Activity activity){
        activityStack.remove(activity);
    }
}
