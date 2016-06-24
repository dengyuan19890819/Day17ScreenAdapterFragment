package com.qf.xs.day17screenadapterfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by asus on 2016/6/7.
 * 继承的是ListFragment，这个类自己会有一个布局，布局中自己含有一个listview
 * 只要重写onActivityCreated即可
 */
public class TitleFragment extends ListFragment {


    private String[] titles;
    private FragmentManager fragmentManager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentManager = getActivity().getSupportFragmentManager();


        titles = new String[]{"绣春刀","变形金刚4","后会无期2","北京遇上西雅图"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, titles);
        //给默认的Listview设置数据适配器
        setListAdapter(adapter);
    }

    //当默认添加的Listview的item被点击的时候回调
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString("title",titles[position]);

        //判断如果是横屏，直接动态加载内容碎片到当前Activity中
        if (ScreenUtils.isLand(getActivity()))
        {
            ContentFragment contentFragment = new ContentFragment();

            contentFragment.setArguments(bundle);

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content_fragment_container,contentFragment);
            transaction.commit();


        }else {
            //如果是竖屏，切换ContentActivity,在ContentActivity中加载内容碎片
            Intent intent = new Intent(getActivity(),ContentActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
