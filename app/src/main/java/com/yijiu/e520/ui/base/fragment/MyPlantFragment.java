package com.yijiu.e520.ui.base.fragment;

import android.content.IntentFilter;
import android.widget.RelativeLayout;

import com.yijiu.e520.presenter.home.plant.PlantPresenter;
import com.yijiu.e520.R;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.base.contract.home.plant.PlantContract;

import butterknife.BindView;

/**
 * Created by k41 on 2018/1/8.
 */

public class MyPlantFragment extends RootFragment<PlantPresenter> implements PlantContract.PlantView {

    //定义意图过滤器
    private IntentFilter filter;
    @BindView(R.id.ll_no_date_img)
    RelativeLayout ll_no_date_img;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void stateLoading(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_plant;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();


    }


    @Override
    public void onEmptyList() {

    }
}
