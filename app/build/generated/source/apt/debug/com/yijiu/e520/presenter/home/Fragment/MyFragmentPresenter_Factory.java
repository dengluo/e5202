package com.yijiu.e520.presenter.home.Fragment;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MyFragmentPresenter_Factory implements Factory<MyFragmentPresenter> {
  private final MembersInjector<MyFragmentPresenter> membersInjector;
  private final Provider<DataManager> mDataManagerProvider;

  public MyFragmentPresenter_Factory(MembersInjector<MyFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  @Override
  public MyFragmentPresenter get() {  
    MyFragmentPresenter instance = new MyFragmentPresenter(mDataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MyFragmentPresenter> create(MembersInjector<MyFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    return new MyFragmentPresenter_Factory(membersInjector, mDataManagerProvider);
  }
}

