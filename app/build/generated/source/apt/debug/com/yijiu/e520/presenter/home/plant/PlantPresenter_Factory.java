package com.yijiu.e520.presenter.home.plant;

import com.yijiu.e520.model.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PlantPresenter_Factory implements Factory<PlantPresenter> {
  private final MembersInjector<PlantPresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;

  public PlantPresenter_Factory(MembersInjector<PlantPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public PlantPresenter get() {  
    PlantPresenter instance = new PlantPresenter(dataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<PlantPresenter> create(MembersInjector<PlantPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    return new PlantPresenter_Factory(membersInjector, dataManagerProvider);
  }
}

