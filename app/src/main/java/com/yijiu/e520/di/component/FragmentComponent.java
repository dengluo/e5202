package com.yijiu.e520.di.component;

import android.app.Activity;

import com.yijiu.e520.di.module.FragmentModule;
import com.yijiu.e520.di.scope.FragmentScope;
import com.yijiu.e520.ui.base.fragment.MyPlantFragment;
import com.yijiu.e520.ui.base.fragment.StorageFragment;
import com.yijiu.e520.ui.fragment.WalletFragment;
import com.yijiu.e520.ui.fragment.ReceiptFragment;
import com.yijiu.e520.ui.fragment.MyFragment;
import com.yijiu.e520.ui.fragment.TeamFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    /**
     * 我的客戶
     * @param myClientFragment
     */
    void inject(ReceiptFragment myClientFragment);
    /**
     * 我的订单
     */
    void inject(TeamFragment orderListFragment);
    /**
     * 我的客服
     */
    void inject(WalletFragment customerServiceFragment);
    /**
     * 我的仓储
     */
    void inject(StorageFragment storageFragment);
    /**
     * 我的厂区
     */
    void inject(MyPlantFragment myPlantFragment);
    /**
     * 我的
     */
    void inject(MyFragment myFragment);
}
