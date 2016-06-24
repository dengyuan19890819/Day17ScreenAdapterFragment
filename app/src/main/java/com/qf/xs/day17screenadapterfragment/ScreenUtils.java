package com.qf.xs.day17screenadapterfragment;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;

/**
 * Created by asus on 2016/6/7.
 */
public class ScreenUtils {

    public static boolean isLand(Context context) {
       return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}
