package com.wolf.movie.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.bumptech.glide.Glide;
import com.rd.PageIndicatorView;
import com.wolf.movie.R;
import com.wolf.movie.adapter.GuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.page_indicator)
    PageIndicatorView pageIndicator;
    private List<View> views = new ArrayList<View>();
    private static final int[] SPLASH_IMAGE = {R.mipmap.splash_1, R.mipmap.splash_2, R.mipmap.splash_3, R.mipmap.splash_4, R.mipmap.splash_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initGuide();
    }

    private void initGuide() {
        for (int i = 0; i < SPLASH_IMAGE.length; i++) {
            ImageView imageView = new ImageView(this);
            Glide.with(this).load(SPLASH_IMAGE[i]).into(imageView);
            views.add(imageView);
        }
        viewPager.setAdapter(new GuidePagerAdapter(views));
        viewPager.setPageTransformer(true ,new RotateDownTransformer());
        pageIndicator.setCount(SPLASH_IMAGE.length); // specify total count of indicators
        pageIndicator.setSelection(0);
    }
}
