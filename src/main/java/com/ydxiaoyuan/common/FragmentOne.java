package com.ydxiaoyuan.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdkj on 2016/7/22.
 */
public class FragmentOne extends Fragment {
    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Bind(R.id.btn_pre_order)
    LinearLayout btn_pre_order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_mainpage, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("arilpan", "onAttach");
        mContext = context;
    }

    Context mContext;

    @Bind(R.id.index_list)
    RecyclerView mRecyclerView;

    List<String> mDatas;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDatas = new ArrayList<>();
        mDatas.add("1北京烤鸭");
        mDatas.add("2江西烤猪");
        mRecyclerView.setAdapter(new CommonAdapter<String>(getContext(),
                R.layout.index_list_item, mDatas) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                Log.e("arilpan", "CommonAdapter  convert");
                holder.setText(R.id.dish_name, s);
            }


        });

    }

    @OnClick(R.id.btn_pre_order)
    void pro_order(View view) {
        startActivity(new Intent(getActivity(),
                cn.studyou.doublelistviewlinkage.Activity.MainActivity.class));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }
}
