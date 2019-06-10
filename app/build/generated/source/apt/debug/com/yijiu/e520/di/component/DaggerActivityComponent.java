package com.yijiu.e520.di.component;

import android.app.Activity;
import com.yijiu.e520.base.BaseActivity;
import com.yijiu.e520.base.BaseActivity_MembersInjector;
import com.yijiu.e520.base.RootActivity;
import com.yijiu.e520.di.module.ActivityModule;
import com.yijiu.e520.di.module.ActivityModule_ProvideActivityFactory;
import com.yijiu.e520.model.DataManager;
import com.yijiu.e520.presenter.home.WelcomePresenter;
import com.yijiu.e520.presenter.home.WelcomePresenter_Factory;
import com.yijiu.e520.presenter.home.loginpresenter.LoginPresenter;
import com.yijiu.e520.presenter.home.loginpresenter.LoginPresenter_Factory;
import com.yijiu.e520.presenter.home.main.MainPresenter;
import com.yijiu.e520.presenter.home.main.MainPresenter_Factory;
import com.yijiu.e520.ui.WelcomeActivity;
import com.yijiu.e520.ui.login.LoginActivity;
import com.yijiu.e520.ui.main.MainActivity;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Activity> provideActivityProvider;
  private Provider<WelcomePresenter> welcomePresenterProvider;
  private MembersInjector<BaseActivity<WelcomePresenter>> baseActivityMembersInjector;
  private MembersInjector<WelcomeActivity> welcomeActivityMembersInjector;
  private Provider<DataManager> getDataManagerProvider;
  private Provider<MainPresenter> mainPresenterProvider;
  private MembersInjector<BaseActivity<MainPresenter>> baseActivityMembersInjector1;
  private MembersInjector<RootActivity<MainPresenter>> rootActivityMembersInjector;
  private MembersInjector<MainActivity> mainActivityMembersInjector;
  private Provider<LoginPresenter> loginPresenterProvider;
  private MembersInjector<BaseActivity<LoginPresenter>> baseActivityMembersInjector2;
  private MembersInjector<RootActivity<LoginPresenter>> rootActivityMembersInjector1;
  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideActivityProvider = ScopedProvider.create(ActivityModule_ProvideActivityFactory.create(builder.activityModule));
    this.welcomePresenterProvider = WelcomePresenter_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.baseActivityMembersInjector = BaseActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), welcomePresenterProvider);
    this.welcomeActivityMembersInjector = MembersInjectors.delegatingTo(baseActivityMembersInjector);
    this.getDataManagerProvider = new Factory<DataManager>() {
      private final AppComponent appComponent = builder.appComponent;
      @Override public DataManager get() {
        DataManager provided = appComponent.getDataManager();
        if (provided == null) {
          throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        }
        return provided;
      }
    };
    this.mainPresenterProvider = MainPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseActivityMembersInjector1 = BaseActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), mainPresenterProvider);
    this.rootActivityMembersInjector = MembersInjectors.delegatingTo(baseActivityMembersInjector1);
    this.mainActivityMembersInjector = MembersInjectors.delegatingTo(rootActivityMembersInjector);
    this.loginPresenterProvider = LoginPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseActivityMembersInjector2 = BaseActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), loginPresenterProvider);
    this.rootActivityMembersInjector1 = MembersInjectors.delegatingTo(baseActivityMembersInjector2);
    this.loginActivityMembersInjector = MembersInjectors.delegatingTo(rootActivityMembersInjector1);
  }

  @Override
  public Activity getActivity() {  
    return provideActivityProvider.get();
  }

  @Override
  public void inject(WelcomeActivity welcomeActivity) {  
    welcomeActivityMembersInjector.injectMembers(welcomeActivity);
  }

  @Override
  public void inject(MainActivity mainActivity) {  
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  @Override
  public void inject(LoginActivity loginActivity) {  
    loginActivityMembersInjector.injectMembers(loginActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;
    private AppComponent appComponent;
  
    private Builder() {  
    }
  
    public ActivityComponent build() {  
      if (activityModule == null) {
        throw new IllegalStateException("activityModule must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException("appComponent must be set");
      }
      return new DaggerActivityComponent(this);
    }
  
    public Builder activityModule(ActivityModule activityModule) {  
      if (activityModule == null) {
        throw new NullPointerException("activityModule");
      }
      this.activityModule = activityModule;
      return this;
    }
  
    public Builder appComponent(AppComponent appComponent) {  
      if (appComponent == null) {
        throw new NullPointerException("appComponent");
      }
      this.appComponent = appComponent;
      return this;
    }
  }
}

