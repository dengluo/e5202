package com.yijiu.e520.ui.login;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.gyf.immersionbar.ImmersionBar;
import com.yijiu.e520.R;
import com.yijiu.e520.app.Constants;
import com.yijiu.e520.base.RootActivity;
import com.yijiu.e520.base.contract.home.logincontract.LoginContract;
import com.yijiu.e520.presenter.home.loginpresenter.LoginPresenter;
import com.yijiu.e520.ui.main.MainActivity;
import com.yijiu.e520.util.ToastUtil;

import org.jsoup.helper.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author Danny
 * @Date 2019/6/6 16:28
 * @Des 登录
 */

public class LoginActivity extends RootActivity<LoginPresenter> implements LoginContract.View{
    @BindView(R.id.et_user_name)
    EditText mEtUserName;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    //两秒内按返回键两次退出程序
    private long exitTime = 0;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        ImmersionBar.with(this).init();
        String userName = this.getIntent().getStringExtra(Constants.USER_NAME);
        if(!StringUtil.isBlank(userName)) {
            mEtUserName.setText(userName);
        }
    }

    @OnClick(R.id.btn_login)
    public void login(View view) {
        String userName = mEtUserName.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        if (StringUtil.isBlank(userName)) {
            mEtUserName.requestFocus();
            ToastUtil.shortShow(getResources().getString(R.string.qingshuruyonghuming));
            return;
        }
        if (StringUtil.isBlank(password)) {
            mEtPassword.requestFocus();
            ToastUtil.shortShow(getResources().getString(R.string.qingshurudenglumima));
            return;
        }
        stateLoading();//使用进度条
        mPresenter.login(userName, password);

    }

    @Override
    public void loginSuccess(Integer servicerType) {
            //登录成功
            Intent intent =new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
    }

    @Override
    public void loginFail(String msg) {
        ToastUtil.shortShow(msg);
    }

    @Override
    public void stateMain() {
        super.stateMain();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                exitTime = System.currentTimeMillis();
                ToastUtil.shortShow("再按一次退出程序");
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void showMsgDialog(String title, String msg) {

    }
}
