package com.yijiu.e520.presenter.home;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class WelcomePresenter_Factory implements Factory<WelcomePresenter> {
  private final MembersInjector<WelcomePresenter> membersInjector;

  public WelcomePresenter_Factory(MembersInjector<WelcomePresenter> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public WelcomePresenter get() {  
    WelcomePresenter instance = new WelcomePresenter();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<WelcomePresenter> create(MembersInjector<WelcomePresenter> membersInjector) {  
    return new WelcomePresenter_Factory(membersInjector);
  }
}

