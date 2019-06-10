package com.yijiu.e520.di.component;

import com.yijiu.e520.app.App;
import com.yijiu.e520.di.module.AppModule;
import com.yijiu.e520.di.module.HttpModule;
import com.yijiu.e520.model.DataManager;
import com.yijiu.e520.model.db.RealmHelper;
import com.yijiu.e520.model.http.RetrofitHelper;
import com.yijiu.e520.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
