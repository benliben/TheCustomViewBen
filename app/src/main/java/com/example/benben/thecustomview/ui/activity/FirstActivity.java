package com.example.benben.thecustomview.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.AttributeSet;

import com.example.benben.thecustomview.R;

/**
 * Created by benben on 2016/4/27.
 */
public class FirstActivity extends BaseActivity {
    public static void startFirstActivity(Activity activity) {
        Intent intent = new Intent(activity, FirstActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
/**文本*/
    private String mTitleText;
    /**文本颜色*/
    private int mTitelTextColor;
    /**文本的大小*/
    private int mTitleTextSize;
    /**绘制时控制文本绘制的范围*/
    private Rect mBound;
    private Paint mpaint;

//    public CustomTitleView(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//    public CustomTitleView(Context context ) {
//        this(context,null);
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
}
