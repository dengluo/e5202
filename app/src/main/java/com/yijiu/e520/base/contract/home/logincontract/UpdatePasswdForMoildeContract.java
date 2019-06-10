package com.yijiu.e520.base.contract.home.logincontract;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by zcs on 2017/5/26.
 */

public interface UpdatePasswdForMoildeContract {
    interface View extends BaseView {
        void updatePasswdSuccess(boolean isboolean);
    }

    interface Presenter extends BasePresenter<View> {
        void forgetPassword(String mobile, String vaildateCodes, String newPwd);
    }
}
