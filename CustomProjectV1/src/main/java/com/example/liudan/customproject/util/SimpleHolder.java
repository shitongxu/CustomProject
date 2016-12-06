package com.example.liudan.customproject.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liudan on 2016/11/29.
 */

public class SimpleHolder extends RecyclerView.ViewHolder {
    public SimpleHolder(View itemView) {
        super(itemView);
    }
    public <T extends View> T find(int id){
        return (T) itemView.findViewById(id);
    }
}
