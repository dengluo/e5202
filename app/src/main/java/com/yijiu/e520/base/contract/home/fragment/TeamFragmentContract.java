package com.yijiu.e520.base.contract.home.fragment;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by k41 on 2017/12/12.
 */

public interface TeamFragmentContract {
    interface TeamtFragmentView extends BaseView {
        void getOrderDate();
        void onEmptyList();
    }

    interface TeamFragmentPresenter extends BasePresenter<TeamtFragmentView> {
        }
}
