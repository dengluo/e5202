package com.yijiu.e520.base.contract.home.storage;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by k41 on 2018/1/8.
 * 我的仓储
 */

public interface StorageContract {
    interface StorageView extends BaseView {
        void onEmptyList();
        void onEmptyListCrmStorageInfO();
    }

    interface StoragePresenter extends BasePresenter<StorageView> {
        void getShopPageList(Long userSid, String shopName, Integer curPage, Integer pageSize);
        /**
         * 获取指定仓库的CRM配置属性值信息和客情记录信息
         */
        void getCrmStorageInfo(Long userSid, Long shopSid);
    }
}
