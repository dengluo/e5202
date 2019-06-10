package com.yijiu.e520.presenter.home.Fragment;


import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.fragment.ReceiptContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2017/12/12.
 */

public class ReceiptFragmentPresenter extends RxPresenter<ReceiptContract.ReceiptView> implements ReceiptContract.ReceiptFragmentPresenter {
    private DataManager mDataManager;

    @Inject
    public ReceiptFragmentPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getSupplyPageList(Long userSid, String empno, Integer servicerType, Integer curPage, Integer pageSize, String supplyName) {

    }

    @Override
    public void getCrmSupplyCustomerInfo(Long userSid, Long supplySid) {

    }
}
