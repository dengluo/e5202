package com.yijiu.e520.di.module;

import com.yijiu.e520.model.http.HttpHelper;
import com.yijiu.e520.model.http.RetrofitHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideHttpHelperFactory implements Factory<HttpHelper> {
  private final AppModule module;
  private final Provider<RetrofitHelper> retrofitHelperProvider;

  public AppModule_ProvideHttpHelperFactory(AppModule module, Provider<RetrofitHelper> retrofitHelperProvider) {  
    assert module != null;
    this.module = module;
    assert retrofitHelperProvider != null;
    this.retrofitHelperProvider = retrofitHelperProvider;
  }

  @Override
  public HttpHelper get() {  
    HttpHelper provided = module.provideHttpHelper(retrofitHelperProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<HttpHelper> create(AppModule module, Provider<RetrofitHelper> retrofitHelperProvider) {  
    return new AppModule_ProvideHttpHelperFactory(module, retrofitHelperProvider);
  }
}

