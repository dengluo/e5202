package com.yijiu.e520.di.module;

import com.yijiu.e520.model.prefs.ImplPreferencesHelper;
import com.yijiu.e520.model.prefs.PreferencesHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvidePreferencesHelperFactory implements Factory<PreferencesHelper> {
  private final AppModule module;
  private final Provider<ImplPreferencesHelper> implPreferencesHelperProvider;

  public AppModule_ProvidePreferencesHelperFactory(AppModule module, Provider<ImplPreferencesHelper> implPreferencesHelperProvider) {  
    assert module != null;
    this.module = module;
    assert implPreferencesHelperProvider != null;
    this.implPreferencesHelperProvider = implPreferencesHelperProvider;
  }

  @Override
  public PreferencesHelper get() {  
    PreferencesHelper provided = module.providePreferencesHelper(implPreferencesHelperProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<PreferencesHelper> create(AppModule module, Provider<ImplPreferencesHelper> implPreferencesHelperProvider) {  
    return new AppModule_ProvidePreferencesHelperFactory(module, implPreferencesHelperProvider);
  }
}

