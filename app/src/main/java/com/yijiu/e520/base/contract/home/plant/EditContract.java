package com.yijiu.e520.base.contract.home.plant;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by k41 on 2018/1/8.
 * 编辑
 */

public interface EditContract {
    interface EditView extends BaseView {
        void updateRegionHarvestResult(String result);
    }

    interface EditPresenter extends BasePresenter<EditView> {
        /**
         * 修改产区产品产量
         */
        void updateRegionHarvest(Long userSid, Long regionCategorySid, String harvest);
    }
}
