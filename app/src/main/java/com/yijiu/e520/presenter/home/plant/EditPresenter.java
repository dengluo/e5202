package com.yijiu.e520.presenter.home.plant;


import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.plant.EditContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2018/1/8.
 */

public class EditPresenter extends RxPresenter<EditContract.EditView> implements EditContract.EditPresenter {
    private DataManager dataManager;

    @Inject
    public EditPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void updateRegionHarvest(Long userSid, Long regionCategorySid, String harvest) {

    }
}
