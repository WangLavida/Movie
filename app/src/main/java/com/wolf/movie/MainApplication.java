package com.wolf.movie;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.wolf.movie.common.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by W.J on 2018/2/6.
 */

public class MainApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

    }
    private void initLog(){
        Utils.init(this);
        LogUtils.Config config = LogUtils.getConfig();
        config.setLogSwitch(Constants.isDebug);
        config.setLog2FileSwitch(Constants.isDebug);
        config.setDir(getExternalFilesDir(null));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        config.setFilePrefix(df.format(new Date()));
    }
}
