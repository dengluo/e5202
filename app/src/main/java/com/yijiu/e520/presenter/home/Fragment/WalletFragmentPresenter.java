package com.yijiu.e520.presenter.home.Fragment;



import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.fragment.WalletFragmentContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2017/12/12.
 */

public class WalletFragmentPresenter extends RxPresenter<WalletFragmentContract.WalletFragmentView> implements WalletFragmentContract.WalletFragmentPresenter {
    private DataManager mDataManager;

    @Inject
    public WalletFragmentPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }
}
