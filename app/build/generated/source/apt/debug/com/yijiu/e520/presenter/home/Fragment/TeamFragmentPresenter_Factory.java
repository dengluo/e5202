package com.yijiu.e520.presenter.home.Fragment;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class TeamFragmentPresenter_Factory implements Factory<TeamFragmentPresenter> {
  private final MembersInjector<TeamFragmentPresenter> membersInjector;
  private final Provider<DataManager> mDataManagerProvider;

  public TeamFragmentPresenter_Factory(MembersInjector<TeamFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  @Override
  public TeamFragmentPresenter get() {  
    TeamFragmentPresenter instance = new TeamFragmentPresenter(mDataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<TeamFragmentPresenter> create(MembersInjector<TeamFragmentPresenter> membersInjector, Provider<DataManager> mDataManagerProvider) {  
    return new TeamFragmentPresenter_Factory(membersInjector, mDataManagerProvider);
  }
}

