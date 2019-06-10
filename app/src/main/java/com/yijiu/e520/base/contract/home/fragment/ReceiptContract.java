package com.yijiu.e520.base.contract.home.fragment;

import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by k41 on 2017/12/12.
 */

public interface ReceiptContract {
    interface ReceiptView extends BaseView {

        void getData(String supplyName);

        void onEmptyList();

        //查询数据为空
        void onDateEmptyList();
    }

    interface ReceiptFragmentPresenter extends BasePresenter<ReceiptView> {
        void getSupplyPageList(Long userSid, String empno, Integer servicerType, Integer curPage, Integer pageSize, String supplyName);

        void getCrmSupplyCustomerInfo(Long userSid, Long supplySid);
    }
}
