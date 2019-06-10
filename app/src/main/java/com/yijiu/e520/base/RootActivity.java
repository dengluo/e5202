package com.yijiu.e520.base;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yijiu.e520.widget.LoadingDialog;
import com.yijiu.e520.R;

import org.jsoup.helper.StringUtil;


/**
 * Created by Mr.yang on 2017/12/04
 * @desciption:
 */

public abstract class RootActivity<T extends BasePresenter> extends BaseActivity<T>implements View.OnClickListener{



    private static final int STATE_MAIN = 0x00;
    private static final int STATE_LOADING = 0x01;
    private static final int STATE_ERROR = 0x02;

    //    private ProgressBar ivLoading;
    private LinearLayout viewError;
    private Button mBtnBack,mBtnReload;
    private TextView mTvErrorTips;
    //    private RelativeLayout viewLoading;
    private ViewGroup viewMain;
    private int currentState = STATE_MAIN;

    LoadingDialog loadingDialog;

    @Override
    protected void initEventAndData() {
        viewMain = (ViewGroup) findViewById(R.id.view_main);
        if (viewMain == null) {
            throw new IllegalStateException(
                    "The subclass of RootActivity must contain a View named view_main.");
        }
        if (!(viewMain.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException(
                    "view_main's ParentView should be a ViewGroup");
        }
        ViewGroup parent = (ViewGroup) viewMain.getParent();
        View.inflate(mContext, R.layout.view_error, parent);
//        View.inflate(mContext, R.layout.view_progress, parent);
        viewError = (LinearLayout) parent.findViewById(R.id.view_error);
        initErrorViewListener();
//        viewLoading = (RelativeLayout) parent.findViewById(R.id.view_loading);
//        ivLoading = (ProgressBar) viewLoading.findViewById(R.id.progress_bar);
        viewError.setVisibility(View.GONE);
//        viewLoading.setVisibility(View.GONE);
        viewMain.setVisibility(View.VISIBLE);
    }

    private void initErrorViewListener(){
        mBtnBack = (Button) viewError.findViewById(R.id.btn_back);
        mBtnReload = (Button) viewError.findViewById(R.id.btn_reload);
        mTvErrorTips = (TextView)viewError.findViewById(R.id.tv_error_tips);
        mBtnBack.setOnClickListener(this);
        mBtnReload.setOnClickListener(this);
    }

    @Override
    public void stateError() {
        if (currentState == STATE_ERROR)
            return;
        hideCurrentView();
        currentState = STATE_ERROR;
        if(viewMain!=null)
            viewMain.setVisibility(View.GONE);
        if (viewError != null)
            viewError.setVisibility(View.VISIBLE);
    }

    public void stateHideViewMain(){
        if (currentState == STATE_LOADING)
            return;
        if(viewMain!=null)
            viewMain.setVisibility(View.GONE);
    }

    @Override
    public void stateLoading() {
        if (currentState == STATE_LOADING)
            return;
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this, R.style.LoadingDialog);
        }
        hideCurrentView();
        currentState = STATE_LOADING;
//        viewLoading.setVisibility(View.VISIBLE);
//        ivLoading.show();
        loadingDialog.show();
        if(viewError!=null){
            viewError.setVisibility(View.GONE);
        }
    }

    @Override
    public void cancelDialog() {
        super.cancelDialog();
        currentState = STATE_MAIN;
        if(loadingDialog!=null && loadingDialog.isShowing()){
            loadingDialog.cancel();
        }
    }

    @Override
    public void stateMain() {
        if (currentState == STATE_MAIN)
            return;
        if (loadingDialog != null) {
            loadingDialog.cancel();
        }
        hideCurrentView();
        currentState = STATE_MAIN;
        if (viewMain != null) {
            viewMain.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showViewMain(boolean isShowViewMain,String errorMsg) {
        if(viewMain!=null) {
            if (isShowViewMain) {
                if(viewError!=null)
                    viewError.setVisibility(View.GONE);
                viewMain.setVisibility(View.VISIBLE);
            } else {
                viewMain.setVisibility(View.GONE);
            }
        }
        if(mTvErrorTips!=null && !StringUtil.isBlank(errorMsg)) {
            String tips = getResources().getString(R.string.error_tips);
            mTvErrorTips.setText(tips+"\n"+errorMsg);
        }
        if(loadingDialog!=null){
            loadingDialog.cancel();
        }
    }

    @Override
    public void showMsgDialog(String title, String msg) {
        if (StringUtil.isBlank(msg)) {
            return;
        }
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable());
        dlg.show();
        Window window = dlg.getWindow();
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.dialog_hint);
        // 为确认按钮添加事件,执行退出应用操作
        TextView ok = (TextView) window.findViewById(R.id.btn_yes);
        TextView tv_content = (TextView) window.findViewById(R.id.tv_content);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
        tv_title.setText(title);
        tv_content.setText(msg);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.cancel();
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

    private void hideCurrentView() {
        switch (currentState) {
            case STATE_MAIN:
//                if(viewMain!=null)
//                    viewMain.setVisibility(View.GONE);
                break;
            case STATE_LOADING:
//                ivLoading.hide();
                if (loadingDialog != null) {
                    loadingDialog.cancel();
                }
//                viewLoading.setVisibility(View.GONE);
                break;
            case STATE_ERROR:
                if(viewMain!=null)
                    viewMain.setVisibility(View.GONE);
                if (viewError != null)
                    viewError.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                onBackPressedSupport();
                break;
            case R.id.btn_reload:
                reload();
                break;
        }
    }
}