package com.qf.xs.day17screenadapterfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by asus on 2016/6/7.
 */
public class ContentFragment extends Fragment {

    private TextView contentTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_layout,null);
        contentTextView = (TextView) view.findViewById(R.id.content_text);

        //获得电影的内容
        String title = getArguments().getString("title");
        contentTextView.setText(title);
        return view;
    }
}
