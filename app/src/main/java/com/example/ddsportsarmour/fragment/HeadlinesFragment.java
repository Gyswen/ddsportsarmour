package com.example.ddsportsarmour.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ddsportsarmour.R;
import com.example.ddsportsarmour.Tool.MyFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;

public class HeadlinesFragment extends MyFragment {
    private SmartRefreshLayout srl;

    @Override
    protected int ContentView() {
        return R.layout.headlinesfragment_layout;
    }

    @Override
    protected void init(View view) {
        srl = view.findViewById(R.id.srl);
        srl.setRefreshHeader(new TwoLevelHeader(getContext()).setFloorRage(2000));
    }
}
