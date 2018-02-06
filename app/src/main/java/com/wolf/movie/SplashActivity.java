package com.wolf.movie;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    private Context mContext;
    private static final int[] SPLASH_IMAGE = {R.mipmap.splash_1, R.mipmap.splash_2, R.mipmap.splash_3, R.mipmap.splash_4, R.mipmap.splash_5};
    @BindView(R.id.splash_image)
    ImageView splashImage;
    @BindView(R.id.logo_image)
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
        ButterKnife.bind(this);

        Random r = new Random(SystemClock.elapsedRealtime());
        splashImage.setImageResource(SPLASH_IMAGE[r.nextInt(SPLASH_IMAGE.length)]);
        Glide.with(mContext)
                .load(R.mipmap.head_logo).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(logoImage);
        YoYo.with(Techniques.RotateInDownRight).onEnd(new YoYo.AnimatorCallback() {
            @Override
            public void call(Animator animator) {
                LogUtils.i("加载完成");
            }
        }).duration(1200).repeat(0).playOn(logoImage);
    }
}
