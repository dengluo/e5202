package com.yijiu.e520.presenter.home.plant;


import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.plant.PlantContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2018/1/8.
 * 我的厂区
 */

public class PlantPresenter extends RxPresenter<PlantContract.PlantView> implements PlantContract.PlantPresenter {
    private DataManager dataManager;

    @Inject
    public PlantPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getProductRegionPageList(Long userSid, String regionName, Integer curPage, Integer pageSize) {

    }
}
