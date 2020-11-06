package com.example.ddsportsarmour.Tool;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MyActivity extends AppCompatActivity {
    protected abstract int ContentView();
    protected abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ContentView());
        init();
    }

    //默认状态栏
    protected void setDefaultStatusBar(int color){
        StatusBarUtil.updateStatus(this,color);
    }

    /**
     * 状态栏透明
     *
     * @param activity
     */
    protected void setNavigationBarStatusBarTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 状态栏透明
     *
     * @param activity
     * @param flag  字体颜色
     */
    protected void setNavigationBarStatusBarTranslucent(Activity activity,int flag) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | flag;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
