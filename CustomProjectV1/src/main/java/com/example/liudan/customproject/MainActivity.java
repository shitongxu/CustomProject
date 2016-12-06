package com.example.liudan.customproject;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.example.liudan.customproject.base.BaseFragmentActivity;
import com.example.liudan.customproject.fragment.CommunityFragment;
import com.example.liudan.customproject.fragment.FindFragment;
import com.example.liudan.customproject.fragment.HomeFragment;
import com.example.liudan.customproject.fragment.MineFragment;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {
    private ImageView tab1, tab2, tab3, tab4;
    private HomeFragment homefragment;
    private FindFragment findfragment;
    private CommunityFragment communityfragment;
    private MineFragment minefragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        homefragment = (HomeFragment) manager.findFragmentByTag("homefragment");
        findfragment = (FindFragment) manager.findFragmentByTag("findfragment");
        communityfragment = (CommunityFragment) manager.findFragmentByTag("communityfragment");
        minefragment = (MineFragment) manager.findFragmentByTag("minefragment");
        initWidget();
        initSelect();
        setSelect(0);
    }

    private void initSelect() {
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);
    }

    private void initWidget() {
        tab1 = (ImageView) findViewById(R.id.tab1);
        tab2 = (ImageView) findViewById(R.id.tab2);
        tab3 = (ImageView) findViewById(R.id.tab3);
        tab4 = (ImageView) findViewById(R.id.tab4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab1:
                setSelect(0);
                break;
            case R.id.tab2:
                setSelect(1);
                break;
            case R.id.tab3:
                setSelect(2);
                break;
            case R.id.tab4:
                setSelect(3);
                break;
        }
    }

    private void setSelect(int i) {
        FragmentTransaction transaction = manager.beginTransaction();
        hide(transaction);
        switch (i) {
            case 0:
                homefragment = (HomeFragment) manager.findFragmentByTag("homefragment");
                if (homefragment == null) {
                    homefragment = new HomeFragment();
                    transaction.add(R.id.content, homefragment, "homefragment");
                } else {
                    transaction.show(homefragment);
                }
                break;
            case 1:
                findfragment = (FindFragment) manager.findFragmentByTag("findfragment");
                if (findfragment == null) {
                    findfragment = new FindFragment();
                    transaction.add(R.id.content, findfragment, "findfragment");
                } else {
                    transaction.show(findfragment);
                }
                break;
            case 2:
                communityfragment = (CommunityFragment) manager.findFragmentByTag("communityfragment");
                if (communityfragment == null) {
                    communityfragment = new CommunityFragment();
                    transaction.add(R.id.content, communityfragment, "communityfragment");
                } else {
                    transaction.show(communityfragment);
                }
                break;
            case 3:
                minefragment = (MineFragment) manager.findFragmentByTag("minefragment");
                if (minefragment == null) {
                    minefragment = new MineFragment();
                    transaction.add(R.id.content, minefragment, "minefragment");
                } else {
                    transaction.show(minefragment);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hide(FragmentTransaction transaction) {
        if (homefragment != null) {
            transaction.hide(homefragment);
        }
        if (communityfragment != null) {
            transaction.hide(communityfragment);
        }
        if (findfragment != null) {
            transaction.hide(findfragment);
        }
        if (minefragment != null) {
            transaction.hide(minefragment);
        }

    }
}
