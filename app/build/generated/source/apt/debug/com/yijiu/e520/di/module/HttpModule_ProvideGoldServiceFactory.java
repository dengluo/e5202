package com.yijiu.e520.di.module;

import com.yijiu.e520.model.http.api.UserApis;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HttpModule_ProvideGoldServiceFactory implements Factory<UserApis> {
  private final HttpModule module;
  private final Provider<Retrofit> retrofitProvider;

  public HttpModule_ProvideGoldServiceFactory(HttpModule module, Provider<Retrofit> retrofitProvider) {  
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public UserApis get() {  
    UserApis provided = module.provideGoldService(retrofitProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<UserApis> create(HttpModule module, Provider<Retrofit> retrofitProvider) {  
    return new HttpModule_ProvideGoldServiceFactory(module, retrofitProvider);
  }
}

