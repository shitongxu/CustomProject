package com.example.liudan.customproject.app;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by liudan on 2016/11/16.
 *全局应用程序类:用于保存和调用全局应用配置以及访问网络数据
 */

public class CustomApplication extends Application{
//    private static CustomApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
//        instance=this;
        initImageLoader(getApplicationContext());
        F.init(this);
        OkGo.init(this);
    }

    private void initImageLoader(Context applicationContext) {
        File cacheDir= StorageUtils.getOwnCacheDirectory(applicationContext,"custom/Cache");
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(applicationContext).memoryCacheExtraOptions(480,800).threadPoolSize(3)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new WeakMemoryCache())
                .diskCacheFileCount(100)
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .build();
        ImageLoader.getInstance().init(config);
    }

//    public static CustomApplication getInstance() {
//        return instance;
//    }
}
