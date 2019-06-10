package com.yijiu.e520.di.module;

import com.yijiu.e520.model.db.DBHelper;
import com.yijiu.e520.model.db.RealmHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideDBHelperFactory implements Factory<DBHelper> {
  private final AppModule module;
  private final Provider<RealmHelper> realmHelperProvider;

  public AppModule_ProvideDBHelperFactory(AppModule module, Provider<RealmHelper> realmHelperProvider) {  
    assert module != null;
    this.module = module;
    assert realmHelperProvider != null;
    this.realmHelperProvider = realmHelperProvider;
  }

  @Override
  public DBHelper get() {  
    DBHelper provided = module.provideDBHelper(realmHelperProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<DBHelper> create(AppModule module, Provider<RealmHelper> realmHelperProvider) {  
    return new AppModule_ProvideDBHelperFactory(module, realmHelperProvider);
  }
}

