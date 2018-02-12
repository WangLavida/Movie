package com.wolf.movie.ui.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wolf.movie.R;
import com.wolf.movie.tool.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        View headView = navigationView.getHeaderView(0);
        ImageView headImage = headView.findViewById(R.id.logo_image);
        titleText.setText("电影");
        Glide.with(this)
                .load(R.mipmap.head_logo).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(headImage);
        initDrawer();
    }

    private void initDrawer() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //去除默认Title显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open, R
                .string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        //去阴影
//        drawerLayout.setScrimColor(Color.TRANSPARENT);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
