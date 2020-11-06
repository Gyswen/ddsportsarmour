package com.example.ddsportsarmour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ddsportsarmour.Tool.MyActivity;
import com.example.ddsportsarmour.fragment.CircleFragment;
import com.example.ddsportsarmour.fragment.GameFragment;
import com.example.ddsportsarmour.fragment.HeadlinesFragment;
import com.example.ddsportsarmour.fragment.PersonalFragment;

public class MainActivity extends MyActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;
    private RadioButton rb1;
    private CircleFragment fg1;
    private HeadlinesFragment fg2;
    private GameFragment fg3;
    private PersonalFragment fg4;
    private FragmentManager fManager;
    private View view;
    private TextView ti;
    private FrameLayout headFl;

    @Override
    protected int ContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //白色 View.SYSTEM_UI_FLAG_LAYOUT_STABLE  灰色 View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        setDefaultStatusBar(R.color.color_da7b7b);
        fManager = getSupportFragmentManager();
        view = this.findViewById(R.id.hend);
        headFl = this.findViewById(R.id.head_fl);
        ti = view.findViewById(R.id.title);
        ti.setText("圈子");
        rg = this.findViewById(R.id.rg);
        rb1 = this.findViewById(R.id.rb1);
        rg.setOnCheckedChangeListener(this);
        rb1.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction transaction = fManager.beginTransaction();
        hideAllFragment(transaction);
        switch (i){
            case R.id.rb1:
                if (fg1 == null){
                    fg1 = new CircleFragment();
                    transaction.add(R.id.fl,fg1);
                }else {
                    transaction.show(fg1);
                }
                break;
            case R.id.rb2:
                if (fg2 == null){
                    fg2 = new HeadlinesFragment();
                    transaction.add(R.id.fl,fg2);
                }else {
                    transaction.show(fg2);
                }
                break;
            case R.id.rb3:
                if (fg3 == null){
                    fg3 = new GameFragment();
                    transaction.add(R.id.fl,fg3);
                }else {
                    transaction.show(fg3);
                }
                break;
            case R.id.rb4:
                if (fg4 == null){
                    fg4 = new PersonalFragment();
                    transaction.add(R.id.fl,fg4);
                    headFl.setVisibility(View.GONE);
                }else {
                    headFl.setVisibility(View.GONE);
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        headFl.setVisibility(View.VISIBLE);
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }
}
