package com.example.liudan.customproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.liudan.customproject.R;
import com.example.liudan.customproject.base.BaseFragment;
import com.example.liudan.customproject.util.SimpleHolder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liudan on 2016/11/28.
 * 首页:漫画
 */

public class HomeFragment extends BaseFragment {
    private RecyclerView.Adapter adapter;
    private List<JSONObject> dataList;
    private RecyclerView recyclerview;
    private Map<String, Object> map = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
    }

    private void initData() {
        Observable.<String>create(subscriber -> {
            OkGo.get("http://172.16.9.15:8080/Text/activityList.action")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            subscriber.onNext(s);
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);

                        }
                    });
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    List<JSONArray> list = new ArrayList<>();
                    List<String> list1 = new ArrayList<String>();

                    try {
                        JSONObject object = new JSONObject(s);
                        JSONObject data = object.optJSONObject("data");
                        list.add(data.optJSONArray("list"));
                        list.add(data.optJSONArray("list2"));
                        list1.add("list");
                        list1.add("list2");
                        if (!list.isEmpty()) {
                            for (int i = 0; i < list.size(); i++) {
                                JSONArray array = list.get(i);
                                for (int j = 0; j < array.length(); j++) {
                                    JSONObject object1 = array.optJSONObject(j);
                                    object1.put("isFrist", list1.get(i));
                                    dataList.add(object1);
                                }
                            }
                        }
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                });


    }

    private void initView(View view) {
        recyclerview = (RecyclerView) view.findViewById(R.id.re);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        dataList = new ArrayList<>();
//        arrayCheck=new boolean[dataList.isEmpty()?0:dataList.size()];
        adapter = new RecyclerView.Adapter<SimpleHolder>() {
            @Override
            public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.home_item, parent, false);
                SimpleHolder holder = new SimpleHolder(view1);
                holder.find(R.id.checkbox).setOnClickListener(view2 -> {
                    System.out.println("前===" + map.size());
                    int po = (int) view1.getTag();
                    CheckBox checkBox = (CheckBox) view2;
                    JSONObject object = dataList.get(po);
                    String state = (String) view2.getTag();
                    if (map.containsValue(state) && !map.containsKey("" + po)) {
                        map.remove(state);
                        System.out.println("中===" + map.size());
                        map.put("" + po, object.optString("state"));
                        System.out.println("中===" + map.size());
                        adapter.notifyDataSetChanged();
                    } else {
                        map.put("" + po, object.optString("state"));
                        adapter.notifyDataSetChanged();

                    }
                    Set set = map.keySet();

                    for (Object key : set) {

                        System.out.println("键:" + key + "  值:" + map.get(key));

                    }
                    System.out.println("后===" + map.size());
                });
                return holder;
            }

            @Override
            public void onBindViewHolder(SimpleHolder holder, int position) {
                holder.itemView.setTag(position);
                JSONObject object = dataList.get(position);
                holder.<TextView>find(R.id.text).setText(object.optString("isFrist"));
                holder.<CheckBox>find(R.id.checkbox).setTag(object.optString("state"));
                if (map.containsKey("" + position)) {
                    holder.<CheckBox>find(R.id.checkbox).setChecked(true);
                } else {
                    holder.<CheckBox>find(R.id.checkbox).setChecked(false);
                }
            }

            @Override
            public int getItemCount() {
                return dataList.size();
            }
        };

        recyclerview.setAdapter(adapter);
    }

}
