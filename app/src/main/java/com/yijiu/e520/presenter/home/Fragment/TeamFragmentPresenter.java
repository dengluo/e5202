package com.yijiu.e520.presenter.home.Fragment;


import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.fragment.TeamFragmentContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by k41 on 2017/12/12.
 */

public class TeamFragmentPresenter extends RxPresenter<TeamFragmentContract.TeamtFragmentView> implements TeamFragmentContract.TeamFragmentPresenter {
    private DataManager mDataManager;

    @Inject
    public TeamFragmentPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


}
