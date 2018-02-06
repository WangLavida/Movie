# Movie
一直想写一个项目，整理下Android开发常用框架技术，从现在开始

# 感谢
- [Android View Animations](https://github.com/daimajia/AndroidViewAnimations)
- [Glide](https://github.com/bumptech/glide)
- [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [RxPermissions](https://github.com/tbruyelle/RxPermissions)

###Android Butterknife 8.4.0 使用方法
1. 在项目的project 的build.gredle 文件中的dependencies标签下添加。(3.0不需要)

        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
2. 在module的build.gredle 文件中添加(3.0以下版本)

        compile 'com.jakewharton:butterknife:8.4.0'
        apt 'com.jakewharton:butterknife-compiler:8.4.0'
3. 在module的build.gredle 文件中添加(3.0以上版本)

         implementation 'com.jakewharton:butterknife:8.4.0'
         annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'

###Glide加载图片

         Glide.with(mContext)
                        .load(R.mipmap.head_logo)
                        .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                        .into(logoImage);