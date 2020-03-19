package com.example.erp1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment {
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
         //通过参数中的布局填充获取对应布局
        View view =inflater.inflate(R.layout.fragment_left_layout,container,false);
        return view;
    }
}
