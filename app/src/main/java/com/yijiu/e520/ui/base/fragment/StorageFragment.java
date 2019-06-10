package com.yijiu.e520.ui.base.fragment;


import com.yijiu.e520.R;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.base.contract.home.storage.StorageContract;
import com.yijiu.e520.presenter.home.storage.StoragePresenter;

/**
 * Created by k41 on 2018/1/8.
 */

public class StorageFragment extends RootFragment<StoragePresenter> implements StorageContract.StorageView{


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void stateLoading(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_storage;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
    }

    @Override
    public void onEmptyList() {

    }

    @Override
    public void onEmptyListCrmStorageInfO() {

    }
}
