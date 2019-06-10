package com.yijiu.e520.base.contract.home.plant;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by k41 on 2018/1/8.
 * 我的厂区
 */

public interface PlantContract {
    interface PlantView extends BaseView {
        /**
         * 数据为空处理
         */
        void onEmptyList();
    }

    interface PlantPresenter extends BasePresenter<PlantView> {
        /**
         * 查询业务员关联的产区信息列表页
         * @param userSid
         * @param regionName
         * @param curPage
         * @param pageSize
         */
        void getProductRegionPageList(Long userSid, String regionName, Integer curPage, Integer pageSize);
    }
}
