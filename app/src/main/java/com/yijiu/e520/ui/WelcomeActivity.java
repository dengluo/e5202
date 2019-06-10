package com.yijiu.e520.ui;

import android.content.Intent;

import com.yijiu.e520.R;
import com.yijiu.e520.base.BaseActivity;
import com.yijiu.e520.base.contract.home.WelcomeContract;
import com.yijiu.e520.presenter.home.WelcomePresenter;
import com.yijiu.e520.ui.login.LoginActivity;
import com.yijiu.e520.ui.main.MainActivity;


/**
 * Created by Mr.zjx on 2017/12/04
 * @description
 * @Version
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        mPresenter.startMainActivity();
    }

    @Override
    public void showMsgDialog(String title, String msg) {

    }


    @Override
    public void jumpToLogin() {
        Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void jumpToHome(String userName) {
        if (userName!=null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            jumpToLogin();
        }
    }
}
