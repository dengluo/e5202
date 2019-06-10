package com.yijiu.e520.model;


import com.yijiu.e520.app.App;
import com.yijiu.e520.model.bean.UserBean;
import com.yijiu.e520.model.bean.UserLoginVo;
import com.yijiu.e520.model.db.DBHelper;
import com.yijiu.e520.model.http.HttpHelper;
import com.yijiu.e520.model.http.response.PadResultResponse;
import com.yijiu.e520.model.prefs.PreferencesHelper;

import io.reactivex.Flowable;


/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public class DataManager implements HttpHelper, DBHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public boolean getNightModeState() {
        return mPreferencesHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean state) {
        mPreferencesHelper.setNightModeState(state);
    }

    @Override
    public boolean getNoImageState() {
        return mPreferencesHelper.getNoImageState();
    }

    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public Flowable<PadResultResponse<UserLoginVo>> login(String userName, String password) {
        return mHttpHelper.login(userName, password);
    }



    @Override
    public void setUserInstance(UserBean userBean) {
        App.getInstance().setUserInstance(userBean);
        mPreferencesHelper.setUserInstance(userBean);
    }


    @Override
    public UserBean getUserInstance() {
        return mPreferencesHelper.getUserInstance();
    }

}
