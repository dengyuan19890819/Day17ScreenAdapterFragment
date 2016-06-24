package com.qf.xs.day17screenadapterfragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //如果是横屏，就默认加载第一电影的内容给ContentFragment ,
        if (ScreenUtils.isLand(this)){
            initContentFragment();
        }
    }

    private void initContentFragment() {

        //添加ContentFragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        ContentFragment contentFragment = new ContentFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title","绣春刀");
        contentFragment.setArguments(bundle);
        transaction.replace(R.id.content_fragment_container,contentFragment);
        transaction.commit();
    }
}
