package com.example.benben.thecustomview.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benben.thecustomview.R;
import com.example.benben.thecustomview.model.MainModel;
import com.example.benben.thecustomview.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 主页面
 *
 * 自定义view的步骤
 * 1.自定义view的属性
 * 2.在view的构造方法中获得我们自定义的属性
 * 3.重写onMesure（不一定是必须，大部分情况下还是需要重写的
 * 4.重写onDraw
 */

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.topTitle)
    TextView mTitle;
    @InjectView(R.id.main_recyclerView)
    RecyclerView mRecyclerView;
    private String[] mData = {"view1", "view2"};
    private List<MainModel> mModel;
    private MainAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
        initView();

    }

    private void initData() {
        mModel = new ArrayList<>();
        for (int i = 0; i < mData.length; i++) {
            MainModel model = new MainModel();
            model.setName(mData[i]);
            mModel.add(model);
        }
    }

    private void initView() {
        mTitle.setText("ViewHome");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        FirstActivity.startFirstActivity(MainActivity.this);
                        break;
                    case 1:
                        SecondActivity.startSecondActivity(MainActivity.this);
                        break;
                }
            }
        });
    }
}
