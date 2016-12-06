package com.example.liudan.customproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liudan.customproject.R;
import com.example.liudan.customproject.base.BaseFragment;

/**
 * Created by liudan on 2016/11/28.
 * 发现
 */

public class FindFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.find_fragment,container,false);
    }
}
