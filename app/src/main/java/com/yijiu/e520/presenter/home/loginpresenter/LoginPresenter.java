package com.yijiu.e520.presenter.home.loginpresenter;


import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.logincontract.LoginContract;
import com.yijiu.e520.model.DataManager;
import com.yijiu.e520.model.bean.UserLoginVo;
import com.yijiu.e520.model.http.response.PadResultResponse;
import com.yijiu.e520.util.RxUtil;
import com.yijiu.e520.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by Mr.yang
 * on 2017/12/8
 *
 * @description.
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void login(final String userName, String password) {
        addSubscribe(mDataManager.login(userName, password)
                .compose(RxUtil.<PadResultResponse<UserLoginVo>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<UserLoginVo>(mView, true) {
                    @Override
                    public void dataHandle(UserLoginVo userBean) {
                        setUserData(userBean);
                        mDataManager.setUserInstance(userBean.getUserBean());//存储全局 user 对象
                        mView.loginSuccess(userBean.getUserBean().getServicerType());
                    }

                    @Override
                    public void onError(String msg) {
                        super.onError(msg);
                        mView.stateMain();
                        mView.loginFail(msg);
                    }
                }));

    }


    /**
     * 添加PAD端需要的变量
     *
     * @param userBean
     */
    private void setUserData(UserLoginVo userBean) {
//        userBean.getUserBean().setIpAddress(SystemUtil.getLocalIpAddress());
//        userBean.getUserBean().setMacAddress(SystemUtil.getMacAddress());
//        userBean.getUserBean().setAppVersionName(SystemUtil.getAppVersionName());
        userBean.setToken(userBean.getToken());
//        userBean.getUserBean().setExpires_in(userBean.getExpires_in());
//        userBean.getUserBean().setYeePay(userBean.getYeepay());
    }
}
