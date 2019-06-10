package com.yijiu.e520.presenter.home.main;



import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.main.MainContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by zcs on 2017/5/8.
 */

public class MainPresenter extends RxPresenter<MainContract.IMainView> implements MainContract.IMainPresenter {
    private DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

}
