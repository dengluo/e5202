package com.yijiu.e520.di.component;

import android.app.Activity;

import com.yijiu.e520.di.scope.ActivityScope;
import com.yijiu.e520.di.module.ActivityModule;
import com.yijiu.e520.ui.WelcomeActivity;
import com.yijiu.e520.ui.login.LoginActivity;
import com.yijiu.e520.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    /**
     * 欢迎界面
     * @param welcomeActivity
     */
    void inject(WelcomeActivity welcomeActivity);

    /**
     * 主界面
     * @param mainActivity
     */
    void inject(MainActivity mainActivity);

    /**
     * 登录界面
     * @param loginActivity
     */
    void inject(LoginActivity loginActivity);
}
