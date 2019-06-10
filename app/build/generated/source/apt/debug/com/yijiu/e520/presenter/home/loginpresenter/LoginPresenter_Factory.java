package com.yijiu.e520.presenter.home.loginpresenter;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginPresenter_Factory implements Factory<LoginPresenter> {
  private final MembersInjector<LoginPresenter> membersInjector;
  private final Provider<DataManager> mDataManagerProvider;

  public LoginPresenter_Factory(MembersInjector<LoginPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  @Override
  public LoginPresenter get() {  
    LoginPresenter instance = new LoginPresenter(mDataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<LoginPresenter> create(MembersInjector<LoginPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    return new LoginPresenter_Factory(membersInjector, mDataManagerProvider);
  }
}

