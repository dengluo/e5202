package com.yijiu.e520.ui.fragment;

import android.widget.TextView;


import com.yijiu.e520.R;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.base.contract.home.fragment.WalletFragmentContract;
import com.yijiu.e520.presenter.home.Fragment.WalletFragmentPresenter;

import butterknife.BindView;

/**
 * Creatd by k41 on 2017/12/12.
 */

public class WalletFragment extends RootFragment<WalletFragmentPresenter> implements WalletFragmentContract.WalletFragmentView{
    @BindView(R.id.tv_header_title)
    TextView tv_header_title;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void stateLoading(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_service;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        tv_header_title.setText("客服服务");
    }
}
