package com.example.erp1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class RuleRightFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //通过参数中的布局填充获取对应布局
        View view =inflater.inflate(R.layout.rule_right_layout,container,false);
        return view;
    }
}
