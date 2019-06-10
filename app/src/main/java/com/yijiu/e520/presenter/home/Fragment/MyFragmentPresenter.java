package com.yijiu.e520.presenter.home.Fragment;


import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.fragment.MyFragmentContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2018/1/19.
 */

public class MyFragmentPresenter extends RxPresenter<MyFragmentContract.MyFragmentView> implements MyFragmentContract.MyFragmentPresenter {
    private DataManager mDataManager;

    @Inject
    public MyFragmentPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getCrmOmsOrderReport(Long userSid, String empno, String servicerType) {

    }
}
