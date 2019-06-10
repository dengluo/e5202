package com.yijiu.e520.ui.fragment;


import com.yijiu.e520.R;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.base.contract.home.fragment.MyFragmentContract;
import com.yijiu.e520.presenter.home.Fragment.MyFragmentPresenter;

/**
 * Creatd by k41 on 2017/12/12.
 * 我的
 */

public class MyFragment extends RootFragment<MyFragmentPresenter> implements MyFragmentContract.MyFragmentView {

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void stateLoading(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment_my;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();

    }


}
