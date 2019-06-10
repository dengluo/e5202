package com.yijiu.e520.presenter.home.storage;

import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.storage.StorageContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2018/1/8.
 * 我的仓储
 */

public class StoragePresenter extends RxPresenter<StorageContract.StorageView> implements StorageContract.StoragePresenter {
    private DataManager dataManager;

    @Inject
    public StoragePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getShopPageList(Long userSid, String shopName, Integer curPage, Integer pageSize) {

    }

    /**
     * 获取指定仓库的CRM配置属性值信息和客情记录信息
     *
     * @param userSid
     * @param shopSid
     */
    @Override
    public void getCrmStorageInfo(Long userSid, Long shopSid) {

    }
}
