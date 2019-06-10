package com.yijiu.e520.presenter.home.main;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainPresenter_Factory implements Factory<MainPresenter> {
  private final MembersInjector<MainPresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;

  public MainPresenter_Factory(MembersInjector<MainPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public MainPresenter get() {  
    MainPresenter instance = new MainPresenter(dataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MainPresenter> create(MembersInjector<MainPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    return new MainPresenter_Factory(membersInjector, dataManagerProvider);
  }
}

