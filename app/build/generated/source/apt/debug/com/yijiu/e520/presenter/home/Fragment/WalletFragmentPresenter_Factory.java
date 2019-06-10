package com.yijiu.e520.presenter.home.Fragment;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class WalletFragmentPresenter_Factory implements Factory<WalletFragmentPresenter> {
  private final MembersInjector<WalletFragmentPresenter> membersInjector;
  private final Provider<DataManager> mDataManagerProvider;

  public WalletFragmentPresenter_Factory(MembersInjector<WalletFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  @Override
  public WalletFragmentPresenter get() {  
    WalletFragmentPresenter instance = new WalletFragmentPresenter(mDataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<WalletFragmentPresenter> create(MembersInjector<WalletFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    return new WalletFragmentPresenter_Factory(membersInjector, mDataManagerProvider);
  }
}

