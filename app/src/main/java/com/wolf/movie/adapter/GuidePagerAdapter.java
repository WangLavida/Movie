package com.wolf.movie.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by W.J on 2018/2/7.
 */

public class GuidePagerAdapter extends PagerAdapter{
    private List<View> views;
    public GuidePagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    // PagerAdapter只缓存三张要显示的图片，如果此时滑动到第三页时，第一页就会调用该方法去销毁相应的View。
    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView(views.get(position));
    }

    // 该方法是按需调用，默认情况先调用三次，将三个即将使用View页面添加到ViewGroup中，当你滑动到第二页View时，ViewPager会调用一次该方法将第四个View页面添加到ViewGroup中。该方法返回值作为key和对应位置的View关联起来。用于isViewFromObject方法判断当前View和key是否关联的。
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        view.addView(views.get(position));
        return views.get(position);
    }
}
