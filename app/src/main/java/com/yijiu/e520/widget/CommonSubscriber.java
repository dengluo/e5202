package com.yijiu.e520.widget;

import android.text.TextUtils;


import com.yijiu.e520.app.Constants;
import com.yijiu.e520.base.BaseView;
import com.yijiu.e520.model.http.exception.ApiException;
import com.yijiu.e520.model.http.response.PadResultResponse;
import com.yijiu.e520.util.LogUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by pengweiqiang on 2017/5/7.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<PadResultResponse<T>> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onNext(PadResultResponse<T> response) {
        mErrorMsg = response.getCodeInfo();
        String code = response.getCode();
        if (Constants.CODE_SUCCESS.equals(code)) {
            dataHandle(response.getData());
            return;
        }
        if (Constants.CODE_FAIL.equals(code)) {

        } else if (Constants.CODE_EXCEPTION.equals(code)) {

        } else if (Constants.CODE_INVALID_TOKEN.equals(code)) {
            mView.showErrorMsgToast(mErrorMsg);
            //提示重新登陆
            mView.startLoginActivity();
        } else if (Constants.CODE_EMPTY_DATA.equals(code)) {
            onEmptyList();
        }
        if (isShowErrorState) {
            mView.showErrorMsgToast(mErrorMsg);
        }

        onError(mErrorMsg);
    }

    @Override
    public void onComplete() {
        mView.stateMain();
    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        e.printStackTrace();
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {

        } else if (e instanceof ApiException) {
            mErrorMsg = e.toString();
        } else if (e instanceof HttpException) {
            mErrorMsg ="数据加载失败ヽ(≧Д≦)ノ";
        } else if (e instanceof ConnectException) {
            mView.showErrorMsgToast("请检查网络是否正常ヽ(≧Д≦)ノ");
        } else if (e instanceof SocketTimeoutException) {
            mView.showErrorMsgToast("连接超时，检查网络是否正常ヽ(≧Д≦)ノ");
        } else {
            mView.showErrorMsgToast("未知错误ヽ(≧Д≦)ノ" + e.getMessage());
            LogUtil.d(e.toString());
        }
        if (isShowErrorState) {
//            mView.showErrorMsgToast(mErrorMsg+"");
        }
        onError(mErrorMsg);
    }

    public abstract void dataHandle(T t);

    //获取失败
    public void onError(String msg) {
        mView.cancelDialog();
    }

    //查询结果为空的情况
    public void onEmptyList() {

    }
}
