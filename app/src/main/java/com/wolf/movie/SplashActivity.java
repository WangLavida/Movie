package com.wolf.movie;

import android.Manifest;
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wolf.movie.common.Constants;
import com.wolf.movie.ui.activity.GuideActivity;
import com.wolf.movie.util.MyLog;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.count_text)
    TextView countText;
    @BindView(R.id.count_line)
    LinearLayout countLine;
    private Context mContext;
    private static final int[] SPLASH_IMAGE = {R.mipmap.splash_1, R.mipmap.splash_2, R.mipmap.splash_3, R.mipmap.splash_4, R.mipmap.splash_5};
    @BindView(R.id.splash_image)
    ImageView splashImage;
    @BindView(R.id.logo_image)
    ImageView logoImage;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
        ButterKnife.bind(this);

        Random r = new Random(SystemClock.elapsedRealtime());
        splashImage.setImageResource(SPLASH_IMAGE[r.nextInt(SPLASH_IMAGE.length)]);

        initAnimator();
        initPermissions();
    }

    private void initAnimator() {
        Glide.with(mContext)
                .load(R.mipmap.head_logo).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(logoImage);
        YoYo.with(Techniques.RotateInDownRight).onEnd(new YoYo.AnimatorCallback() {
            @Override
            public void call(Animator animator) {
            }
        }).duration(1200).repeat(0).playOn(logoImage);
    }

    private void initPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                MyLog.s("start");
                initCountView();
            }
        });
    }

    private void initCountView() {
        countLine.setVisibility(View.VISIBLE);
        countText.setText(Constants.SPL_TIME + "");
        YoYo.with(Techniques.ZoomInRight).onEnd(new YoYo.AnimatorCallback() {
            @Override
            public void call(Animator animator) {
                initCount();
            }
        }).duration(1000).repeat(0).playOn(countLine);
    }

    private void initCount() {
        Observable.interval(1, TimeUnit.SECONDS).take(3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(Long aLong) {
                countText.setText(Constants.SPL_TIME - 1 - aLong + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                startMain();
            }
        });
    }

    @OnClick(R.id.count_line)
    public void onViewClicked() {
        startMain();
    }
    private void startMain(){
        startActivity(new Intent(mContext, GuideActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
