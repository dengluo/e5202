package com.yijiu.e520.di.module;

import com.yijiu.e520.model.http.api.OrderApis;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HttpModule_ProvideOrderApiServiceFactory implements Factory<OrderApis> {
  private final HttpModule module;
  private final Provider<Retrofit> retrofitProvider;

  public HttpModule_ProvideOrderApiServiceFactory(HttpModule module, Provider<Retrofit> retrofitProvider) {  
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public OrderApis get() {  
    OrderApis provided = module.provideOrderApiService(retrofitProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OrderApis> create(HttpModule module, Provider<Retrofit> retrofitProvider) {  
    return new HttpModule_ProvideOrderApiServiceFactory(module, retrofitProvider);
  }
}

