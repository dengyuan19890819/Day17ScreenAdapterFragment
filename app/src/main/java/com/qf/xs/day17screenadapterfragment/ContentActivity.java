package com.qf.xs.day17screenadapterfragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Bundle bundle = getIntent().getExtras();

        //添加ContentFragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        ContentFragment contentFragment = new ContentFragment();

        contentFragment.setArguments(bundle);
        transaction.replace(R.id.content_fragment_container2,contentFragment);
        transaction.commit();

    }
}
