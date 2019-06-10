package com.yijiu.e520.base;

import android.content.Intent;
import android.support.v7.app.AppCompatDelegate;

import com.yijiu.e520.app.App;
import com.yijiu.e520.app.Constants;
import com.yijiu.e520.di.component.ActivityComponent;
import com.yijiu.e520.di.component.DaggerActivityComponent;
import com.yijiu.e520.di.module.ActivityModule;
import com.yijiu.e520.model.bean.UserBean;
import com.yijiu.e520.ui.login.LoginActivity;
import com.yijiu.e520.util.ToastUtil;

import org.jsoup.helper.StringUtil;

import javax.inject.Inject;

/**
 * Created by Mr.zjx on 2017/12/04
 * MVP activity基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        if(StringUtil.isBlank(msg)){
            return;
        }
//        ToastUtil.show(msg);
//        SnackbarUtil.showShort(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void showErrorMsgToast(String msg) {
        if (msg!=null) {
            if (!msg.equals("查询结果为空！")) {
                ToastUtil.shortShow(msg);
            }else{
                ToastUtil.shortShow(msg);
            }
        }else{
            ToastUtil.shortShow(msg);
        }
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError() {
    }

    @Override
    public void stateLoading() {
    }

    @Override
    public void stateLoading(String msg) {

    }
    @Override
    public void reload(){

    }

    @Override
    public void stateMain() {
    }

    @Override
    public void cancelDialog() {
    }

    @Override
    public void showViewMain(boolean isShowViewMain,String errorMsg){
    }


    @Override
    public void startLoginActivity() {
        //清空登陆数据
        UserBean userBean = App.getInstance().getUserBeanInstance();
        String userName = "";
        if(userBean!=null) {
//            userName = userBean.getLoginName();
        }
        App.getInstance().setUserInstance(null);
        App.getAppComponent().preferencesHelper().setUserInstance(null);
        Intent intent = new Intent(mContext, LoginActivity.class);
        intent.putExtra(Constants.USER_NAME,userName);
        mContext.startActivity(intent);
        finish();
    }

    protected abstract void initInject();
}