package com.yijiu.e520.base.contract.home;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * @author Created by Mr.yang on 2017/12/04
 * @description
 * @Version
 */

public interface WelcomeContract {

    interface View extends BaseView {
        //        void showContent();
        void jumpToLogin();

        void jumpToHome(String userName);
    }

    interface Presenter extends BasePresenter<View> {
        //        void getWelcomeData();
        void startMainActivity();

        void checkIsLogin();
    }

}
