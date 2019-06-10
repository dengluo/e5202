package com.yijiu.e520.base.contract.home.main;


import com.yijiu.e520.base.BasePresenter;
import com.yijiu.e520.base.BaseView;

/**
 * Created by zcs on 2017/5/8.
 */

public interface MainContract {
    interface IMainView extends BaseView {
        void initFrags();
        void setDefaultFrag(int tag);
        void switchFrag(int tag);
    }

    interface IMainPresenter extends BasePresenter<IMainView> {
    }
}
