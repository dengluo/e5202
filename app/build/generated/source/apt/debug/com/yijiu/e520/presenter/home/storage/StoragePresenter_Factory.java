package com.yijiu.e520.presenter.home.storage;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class StoragePresenter_Factory implements Factory<StoragePresenter> {
  private final MembersInjector<StoragePresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;

  public StoragePresenter_Factory(MembersInjector<StoragePresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public StoragePresenter get() {  
    StoragePresenter instance = new StoragePresenter(dataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<StoragePresenter> create(MembersInjector<StoragePresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    return new StoragePresenter_Factory(membersInjector, dataManagerProvider);
  }
}

