package com.yijiu.e520.model.http;

import com.yijiu.e520.model.http.api.CartApi;
import com.yijiu.e520.model.http.api.OrderApis;
import com.yijiu.e520.model.http.api.UserApis;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class RetrofitHelper_Factory implements Factory<RetrofitHelper> {
  private final Provider<UserApis> userApisServiceProvider;
  private final Provider<OrderApis> orderApisProvider;
  private final Provider<CartApi> cartApiProvider;

  public RetrofitHelper_Factory(Provider<UserApis> userApisServiceProvider, Provider<OrderApis> orderApisProvider, Provider<CartApi> cartApiProvider) {  
    assert userApisServiceProvider != null;
    this.userApisServiceProvider = userApisServiceProvider;
    assert orderApisProvider != null;
    this.orderApisProvider = orderApisProvider;
    assert cartApiProvider != null;
    this.cartApiProvider = cartApiProvider;
  }

  @Override
  public RetrofitHelper get() {  
    return new RetrofitHelper(userApisServiceProvider.get(), orderApisProvider.get(), cartApiProvider.get());
  }

  public static Factory<RetrofitHelper> create(Provider<UserApis> userApisServiceProvider, Provider<OrderApis> orderApisProvider, Provider<CartApi> cartApiProvider) {  
    return new RetrofitHelper_Factory(userApisServiceProvider, orderApisProvider, cartApiProvider);
  }
}

