package com.yijiu.e520.presenter.home.Fragment;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ReceiptFragmentPresenter_Factory implements Factory<ReceiptFragmentPresenter> {
  private final MembersInjector<ReceiptFragmentPresenter> membersInjector;
  private final Provider<DataManager> mDataManagerProvider;

  public ReceiptFragmentPresenter_Factory(MembersInjector<ReceiptFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  @Override
  public ReceiptFragmentPresenter get() {  
    ReceiptFragmentPresenter instance = new ReceiptFragmentPresenter(mDataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<ReceiptFragmentPresenter> create(MembersInjector<ReceiptFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    return new ReceiptFragmentPresenter_Factory(membersInjector, mDataManagerProvider);
  }
}

