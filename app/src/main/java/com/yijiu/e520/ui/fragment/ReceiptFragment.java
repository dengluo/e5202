package com.yijiu.e520.ui.fragment;


import com.yijiu.e520.R;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.base.contract.home.fragment.ReceiptContract;
import com.yijiu.e520.presenter.home.Fragment.ReceiptFragmentPresenter;

/**
 * Creatd by k41 on 2017/12/12.
 */

public class ReceiptFragment extends RootFragment<ReceiptFragmentPresenter> implements ReceiptContract.ReceiptView{


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void stateLoading(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment_my_client;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
    }


    @Override
    public void getData(String supplyName) {

    }

    @Override
    public void onEmptyList() {

    }

    @Override
    public void onDateEmptyList() {

    }
}
