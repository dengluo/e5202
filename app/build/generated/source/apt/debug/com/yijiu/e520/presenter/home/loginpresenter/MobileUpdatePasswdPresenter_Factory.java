package com.yijiu.e520.presenter.home.loginpresenter;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MobileUpdatePasswdPresenter_Factory implements Factory<MobileUpdatePasswdPresenter> {
  private final MembersInjector<MobileUpdatePasswdPresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;

  public MobileUpdatePasswdPresenter_Factory(MembersInjector<MobileUpdatePasswdPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public MobileUpdatePasswdPresenter get() {  
    MobileUpdatePasswdPresenter instance = new MobileUpdatePasswdPresenter(dataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<MobileUpdatePasswdPresenter> create(MembersInjector<MobileUpdatePasswdPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    return new MobileUpdatePasswdPresenter_Factory(membersInjector, dataManagerProvider);
  }
}

