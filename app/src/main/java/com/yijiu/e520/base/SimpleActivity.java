package com.yijiu.e520.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.yijiu.e520.R;
import com.yijiu.e520.app.App;
import com.yijiu.e520.ui.login.LoginActivity;

import org.jsoup.helper.StringUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Mr.yang on 2017/12/04
 * 无MVP的activity基类
 */

public abstract class SimpleActivity extends SupportActivity {

    protected Activity mContext;
    private Unbinder mUnBinder;
    protected int currentPage = 1;
    protected int pageSize = 10;


    private MyBaseActiviy_Broad oBaseActiviy_Broad;


    public class MyBaseActiviy_Broad extends BroadcastReceiver {

        public void onReceive(Context arg0, Intent intent) {
//接收发送过来的广播内容
            int closeAll = intent.getIntExtra("closeAll", 0);
            if (closeAll == 1) {
                finish();//销毁BaseActivity
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initEventAndData();

        //动态注册广播
        oBaseActiviy_Broad = new MyBaseActiviy_Broad();
        IntentFilter intentFilter = new IntentFilter("drc.xxx.yyy.baseActivity");
        registerReceiver(oBaseActiviy_Broad, intentFilter);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        setToolBar(toolbar, title, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }

    protected void setToolBar(Toolbar toolbar, String title, View.OnClickListener onClickListener) {
        setToolBar(toolbar, title, "", onClickListener, null);
    }

    protected void setToolBar(Toolbar toolbar, String title, String rightTitle, View.OnClickListener backOnclickListener, View.OnClickListener rightOnclickListener) {
        toolbar.setTitle("");
        TextView mTvTitlte = (TextView) toolbar.findViewById(R.id.tv_header_title);
        TextView mTvRight = (TextView) toolbar.findViewById(R.id.tv_right);
        mTvTitlte.setText(title);
        if (StringUtil.isBlank(rightTitle)) {
            mTvRight.setVisibility(View.GONE);
        } else {
            mTvRight.setText(rightTitle);
            mTvRight.setVisibility(View.VISIBLE);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.ic_back_arrow);
        toolbar.setNavigationOnClickListener(backOnclickListener);
        mTvRight.setOnClickListener(rightOnclickListener);
    }

    protected void setToolBarTitle(Toolbar toolbar, String title, String rightTitle) {
        TextView mTvTitlte = (TextView) toolbar.findViewById(R.id.tv_header_title);
        mTvTitlte.setText(title);

        TextView mTvRight = (TextView) toolbar.findViewById(R.id.tv_right);
        if (StringUtil.isBlank(rightTitle)) {
            mTvRight.setVisibility(View.GONE);
        } else {
            mTvRight.setVisibility(View.VISIBLE);
            mTvRight.setText(rightTitle);
        }
    }

    protected void setToolBarTitle(Toolbar toolbar, String title) {
        TextView mTvTitlte = (TextView) toolbar.findViewById(R.id.tv_header_title);
        mTvTitlte.setText(title);

        TextView mTvRight = (TextView) toolbar.findViewById(R.id.tv_right);

        mTvRight.setVisibility(View.GONE);

        mTvRight.setVisibility(View.GONE);

    }

    protected void onViewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginOutDialog != null) {
            loginOutDialog.dismiss();
            loginOutDialog = null;
        }
        App.getInstance().removeActivity(this);
        mUnBinder.unbind();
        unregisterReceiver(oBaseActiviy_Broad);//注销广播
    }

    /**
     * 退出登陆
     */
    AlertDialog loginOutDialog = null;

    public void loginOut() {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable());
        dlg.show();
        Window window = dlg.getWindow();
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.dialog_down_frame);
        // 为确认按钮添加事件,执行退出应用操作
        TextView ok = (TextView) window.findViewById(R.id.btn_yes);
        TextView tv_content = (TextView) window.findViewById(R.id.tv_content);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
        tv_title.setText("注销");
        tv_content.setText("是否退出登陆?");
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                App.getInstance().setUserInstance(null);
                App.getAppComponent().preferencesHelper().setUserInstance(null);
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                sendBroadcast(intent);//发送广播
                dlg.cancel();
                finish();
            }
        });

        // 关闭alert对话框架
        TextView cancel = (TextView) window.findViewById(R.id.btn_no);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.cancel();
            }
        });
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();
}
