package com.yijiu.e520.di.module;

import com.yijiu.e520.model.DataManager;
import com.yijiu.e520.model.db.DBHelper;
import com.yijiu.e520.model.http.HttpHelper;
import com.yijiu.e520.model.prefs.PreferencesHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideDataManagerFactory implements Factory<DataManager> {
  private final AppModule module;
  private final Provider<HttpHelper> httpHelperProvider;
  private final Provider<DBHelper> DBHelperProvider;
  private final Provider<PreferencesHelper> preferencesHelperProvider;

  public AppModule_ProvideDataManagerFactory(AppModule module, Provider<HttpHelper> httpHelperProvider, Provider<DBHelper> DBHelperProvider, Provider<PreferencesHelper> preferencesHelperProvider) {  
    assert module != null;
    this.module = module;
    assert httpHelperProvider != null;
    this.httpHelperProvider = httpHelperProvider;
    assert DBHelperProvider != null;
    this.DBHelperProvider = DBHelperProvider;
    assert preferencesHelperProvider != null;
    this.preferencesHelperProvider = preferencesHelperProvider;
  }

  @Override
  public DataManager get() {  
    DataManager provided = module.provideDataManager(httpHelperProvider.get(), DBHelperProvider.get(), preferencesHelperProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<DataManager> create(AppModule module, Provider<HttpHelper> httpHelperProvider, Provider<DBHelper> DBHelperProvider, Provider<PreferencesHelper> preferencesHelperProvider) {  
    return new AppModule_ProvideDataManagerFactory(module, httpHelperProvider, DBHelperProvider, preferencesHelperProvider);
  }
}

