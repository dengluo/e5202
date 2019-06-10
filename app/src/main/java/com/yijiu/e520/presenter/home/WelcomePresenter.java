package com.yijiu.e520.presenter.home;

import android.util.Log;

import com.yijiu.e520.app.App;
import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.WelcomeContract;
import com.yijiu.e520.model.bean.UserBean;
import com.yijiu.e520.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @author will on 2017/5/4 09:56
 * @email pengweiqiang64@163.com
 * @description
 * @Version
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    private static final int COUNT_DOWN_TIME = 1000;//欢迎界面等待时间

    @Inject
    public WelcomePresenter() {
    }

    @Override
    public void startMainActivity() {
        startCountDown();
    }

    private void startCountDown() {
        addSubscribe(Flowable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
            @Override
            public void accept(@NonNull Long aLong) throws Exception {
                checkIsLogin();
            }
        }));
    }

    @Override
    public void checkIsLogin() {
        UserBean userBean = App.getInstance().getUserBeanInstance();
        Log.e("userBean",userBean+"");
        if(userBean==null){
            mView.jumpToLogin();
        }else {
            String innerRoleTypeSid = userBean.getLoginName();
            mView.jumpToHome(innerRoleTypeSid);
        }
    }
}
