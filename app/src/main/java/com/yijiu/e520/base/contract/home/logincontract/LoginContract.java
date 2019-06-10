package com.yijiu.e520.base.contract.home.logincontract;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by Mr.yang
 * on 2017/12/8
 *
 * @description.
 */

public interface LoginContract {
    interface View extends BaseView {
        //登录成功
        void loginSuccess(Integer servicerType);
        //登录失败提示信息
        void loginFail(String msg);

    }

    interface Presenter extends BasePresenter<View> {
        void login(String userName, String password);
    }
}
