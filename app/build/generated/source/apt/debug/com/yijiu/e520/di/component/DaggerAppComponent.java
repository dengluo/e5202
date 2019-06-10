package com.yijiu.e520.di.component;

import com.yijiu.e520.app.App;
import com.yijiu.e520.di.module.AppModule;
import com.yijiu.e520.di.module.AppModule_ProvideApplicationContextFactory;
import com.yijiu.e520.di.module.AppModule_ProvideDBHelperFactory;
import com.yijiu.e520.di.module.AppModule_ProvideDataManagerFactory;
import com.yijiu.e520.di.module.AppModule_ProvideHttpHelperFactory;
import com.yijiu.e520.di.module.AppModule_ProvidePreferencesHelperFactory;
import com.yijiu.e520.di.module.HttpModule;
import com.yijiu.e520.di.module.HttpModule_ProvideCartApiServiceFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideClientFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideGoldRetrofitFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideGoldServiceFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideOkHttpBuilderFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideOrderApiServiceFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideRetrofitBuilderFactory;
import com.yijiu.e520.di.module.HttpModule_ProvideUploadRetrofitFactory;
import com.yijiu.e520.model.DataManager;
import com.yijiu.e520.model.db.DBHelper;
import com.yijiu.e520.model.db.RealmHelper;
import com.yijiu.e520.model.db.RealmHelper_Factory;
import com.yijiu.e520.model.http.HttpHelper;
import com.yijiu.e520.model.http.RetrofitHelper;
import com.yijiu.e520.model.http.RetrofitHelper_Factory;
import com.yijiu.e520.model.http.api.CartApi;
import com.yijiu.e520.model.http.api.OrderApis;
import com.yijiu.e520.model.http.api.UserApis;
import com.yijiu.e520.model.prefs.ImplPreferencesHelper;
import com.yijiu.e520.model.prefs.ImplPreferencesHelper_Factory;
import com.yijiu.e520.model.prefs.PreferencesHelper;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerAppComponent implements AppComponent {
  private Provider<App> provideApplicationContextProvider;
  private Provider<Retrofit.Builder> provideRetrofitBuilderProvider;
  private Provider<OkHttpClient.Builder> provideOkHttpBuilderProvider;
  private Provider<OkHttpClient> provideClientProvider;
  private Provider<Retrofit> provideGoldRetrofitProvider;
  private Provider<UserApis> provideGoldServiceProvider;
  private Provider<Retrofit> provideUploadRetrofitProvider;
  private Provider<OrderApis> provideOrderApiServiceProvider;
  private Provider<CartApi> provideCartApiServiceProvider;
  private Provider<RetrofitHelper> retrofitHelperProvider;
  private Provider<HttpHelper> provideHttpHelperProvider;
  private Provider<DBHelper> provideDBHelperProvider;
  private Provider<PreferencesHelper> providePreferencesHelperProvider;
  private Provider<DataManager> provideDataManagerProvider;

  private DaggerAppComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideApplicationContextProvider = ScopedProvider.create(AppModule_ProvideApplicationContextFactory.create(builder.appModule));
    this.provideRetrofitBuilderProvider = ScopedProvider.create(HttpModule_ProvideRetrofitBuilderFactory.create(builder.httpModule));
    this.provideOkHttpBuilderProvider = ScopedProvider.create(HttpModule_ProvideOkHttpBuilderFactory.create(builder.httpModule));
    this.provideClientProvider = ScopedProvider.create(HttpModule_ProvideClientFactory.create(builder.httpModule, provideOkHttpBuilderProvider));
    this.provideGoldRetrofitProvider = ScopedProvider.create(HttpModule_ProvideGoldRetrofitFactory.create(builder.httpModule, provideRetrofitBuilderProvider, provideClientProvider));
    this.provideGoldServiceProvider = ScopedProvider.create(HttpModule_ProvideGoldServiceFactory.create(builder.httpModule, provideGoldRetrofitProvider));
    this.provideUploadRetrofitProvider = ScopedProvider.create(HttpModule_ProvideUploadRetrofitFactory.create(builder.httpModule, provideRetrofitBuilderProvider, provideClientProvider));
    this.provideOrderApiServiceProvider = ScopedProvider.create(HttpModule_ProvideOrderApiServiceFactory.create(builder.httpModule, provideUploadRetrofitProvider));
    this.provideCartApiServiceProvider = ScopedProvider.create(HttpModule_ProvideCartApiServiceFactory.create(builder.httpModule, provideUploadRetrofitProvider));
    this.retrofitHelperProvider = RetrofitHelper_Factory.create(provideGoldServiceProvider, provideOrderApiServiceProvider, provideCartApiServiceProvider);
    this.provideHttpHelperProvider = ScopedProvider.create(AppModule_ProvideHttpHelperFactory.create(builder.appModule, retrofitHelperProvider));
    this.provideDBHelperProvider = ScopedProvider.create(AppModule_ProvideDBHelperFactory.create(builder.appModule, RealmHelper_Factory.create()));
    this.providePreferencesHelperProvider = ScopedProvider.create(AppModule_ProvidePreferencesHelperFactory.create(builder.appModule, ImplPreferencesHelper_Factory.create()));
    this.provideDataManagerProvider = ScopedProvider.create(AppModule_ProvideDataManagerFactory.create(builder.appModule, provideHttpHelperProvider, provideDBHelperProvider, providePreferencesHelperProvider));
  }

  @Override
  public App getContext() {  
    return provideApplicationContextProvider.get();
  }

  @Override
  public DataManager getDataManager() {  
    return provideDataManagerProvider.get();
  }

  @Override
  public RetrofitHelper retrofitHelper() {  
    return retrofitHelperProvider.get();
  }

  @Override
  public RealmHelper realmHelper() {  
    return RealmHelper_Factory.create().get();
  }

  @Override
  public ImplPreferencesHelper preferencesHelper() {  
    return ImplPreferencesHelper_Factory.create().get();
  }

  public static final class Builder {
    private AppModule appModule;
    private HttpModule httpModule;
  
    private Builder() {  
    }
  
    public AppComponent build() {  
      if (appModule == null) {
        throw new IllegalStateException("appModule must be set");
      }
      if (httpModule == null) {
        this.httpModule = new HttpModule();
      }
      return new DaggerAppComponent(this);
    }
  
    public Builder appModule(AppModule appModule) {  
      if (appModule == null) {
        throw new NullPointerException("appModule");
      }
      this.appModule = appModule;
      return this;
    }
  
    public Builder httpModule(HttpModule httpModule) {  
      if (httpModule == null) {
        throw new NullPointerException("httpModule");
      }
      this.httpModule = httpModule;
      return this;
    }
  }
}

