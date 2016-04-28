package com.example.benben.thecustomview.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.thecustomview.R;

/**
 * Created by tangjunjie on 2016/4/28.
 */
public class SecondActivity extends BaseActivity {
    public static void startSecondActivity(Activity activity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
