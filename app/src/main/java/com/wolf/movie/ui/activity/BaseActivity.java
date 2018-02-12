package com.wolf.movie.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by W.J on 2018/2/12.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private Context mContext;
    public abstract int getLayoutId();

    public abstract void initViews();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        int layoutId = getLayoutId();
        setContentView(layoutId);
        ButterKnife.bind(this);
        initViews();

    }
}
