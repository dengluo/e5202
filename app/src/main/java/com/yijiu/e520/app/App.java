package com.yijiu.e520.app;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.yijiu.e520.component.InitializeService;
import com.yijiu.e520.di.component.AppComponent;
import com.yijiu.e520.di.component.DaggerAppComponent;
import com.yijiu.e520.di.module.AppModule;
import com.yijiu.e520.di.module.HttpModule;
import com.yijiu.e520.model.bean.UserBean;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;

public class App extends Application {

    private static App instance;
    public static AppComponent appComponent;
    private Set<Activity> allActivities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    private UserBean userBean;

    public static synchronized App getInstance() {
        return instance;
    }

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //初始化屏幕宽高
        getScreenSize();

        //初始化数据库
        Realm.init(getApplicationContext());

        //在子线程中完成其他初始化
        InitializeService.start(this);
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public void getScreenSize() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }


    public void setUserInstance(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBeanInstance() {
        if (userBean == null) {
            userBean = App.getAppComponent().preferencesHelper().getUserInstance();
            if(userBean!=null){
//                userBean.setIpAddress(SystemUtil.getLocalIpAddress());
//                userBean.setMacAddress(SystemUtil.getMacAddress());
//                userBean.setAppVersionName(SystemUtil.getAppVersionName());
            }
        }
        return userBean;
    }
}
