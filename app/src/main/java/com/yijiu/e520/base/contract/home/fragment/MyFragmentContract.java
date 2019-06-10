package com.yijiu.e520.base.contract.home.fragment;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by k41 on 2018/1/19.
 */

public interface MyFragmentContract {
    interface MyFragmentView extends BaseView {
    }

    interface MyFragmentPresenter extends BasePresenter<MyFragmentView> {
        void getCrmOmsOrderReport(Long userSid,String empno,String servicerType);
    }
}
