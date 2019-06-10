package com.yijiu.e520.ui.fragment;

import com.yijiu.e520.R;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.base.contract.home.fragment.TeamFragmentContract;
import com.yijiu.e520.presenter.home.Fragment.TeamFragmentPresenter;

/**
 * Creatd by k41 on 2017/12/12.
 */

public class TeamFragment extends RootFragment<TeamFragmentPresenter> implements TeamFragmentContract.TeamtFragmentView{


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void stateLoading(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
    }

    @Override
    public void getOrderDate() {

    }

    @Override
    public void onEmptyList() {

    }
}
