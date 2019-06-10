package com.yijiu.e520.presenter.home.plant;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class EditPresenter_Factory implements Factory<EditPresenter> {
  private final MembersInjector<EditPresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;

  public EditPresenter_Factory(MembersInjector<EditPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public EditPresenter get() {  
    EditPresenter instance = new EditPresenter(dataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<EditPresenter> create(MembersInjector<EditPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    return new EditPresenter_Factory(membersInjector, dataManagerProvider);
  }
}

