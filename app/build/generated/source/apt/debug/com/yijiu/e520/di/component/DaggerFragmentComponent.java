package com.yijiu.e520.di.component;

import android.app.Activity;
import com.yijiu.e520.base.BaseFragment;
import com.yijiu.e520.base.BaseFragment_MembersInjector;
import com.yijiu.e520.base.RootFragment;
import com.yijiu.e520.di.module.FragmentModule;
import com.yijiu.e520.di.module.FragmentModule_ProvideActivityFactory;
import com.yijiu.e520.model.DataManager;
import com.yijiu.e520.presenter.home.Fragment.MyFragmentPresenter;
import com.yijiu.e520.presenter.home.Fragment.MyFragmentPresenter_Factory;
import com.yijiu.e520.presenter.home.Fragment.ReceiptFragmentPresenter;
import com.yijiu.e520.presenter.home.Fragment.ReceiptFragmentPresenter_Factory;
import com.yijiu.e520.presenter.home.Fragment.TeamFragmentPresenter;
import com.yijiu.e520.presenter.home.Fragment.TeamFragmentPresenter_Factory;
import com.yijiu.e520.presenter.home.Fragment.WalletFragmentPresenter;
import com.yijiu.e520.presenter.home.Fragment.WalletFragmentPresenter_Factory;
import com.yijiu.e520.presenter.home.plant.PlantPresenter;
import com.yijiu.e520.presenter.home.plant.PlantPresenter_Factory;
import com.yijiu.e520.presenter.home.storage.StoragePresenter;
import com.yijiu.e520.presenter.home.storage.StoragePresenter_Factory;
import com.yijiu.e520.ui.base.fragment.MyPlantFragment;
import com.yijiu.e520.ui.base.fragment.StorageFragment;
import com.yijiu.e520.ui.fragment.MyFragment;
import com.yijiu.e520.ui.fragment.ReceiptFragment;
import com.yijiu.e520.ui.fragment.TeamFragment;
import com.yijiu.e520.ui.fragment.WalletFragment;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerFragmentComponent implements FragmentComponent {
  private Provider<Activity> provideActivityProvider;
  private Provider<DataManager> getDataManagerProvider;
  private Provider<ReceiptFragmentPresenter> receiptFragmentPresenterProvider;
  private MembersInjector<BaseFragment<ReceiptFragmentPresenter>> baseFragmentMembersInjector;
  private MembersInjector<RootFragment<ReceiptFragmentPresenter>> rootFragmentMembersInjector;
  private MembersInjector<ReceiptFragment> receiptFragmentMembersInjector;
  private Provider<TeamFragmentPresenter> teamFragmentPresenterProvider;
  private MembersInjector<BaseFragment<TeamFragmentPresenter>> baseFragmentMembersInjector1;
  private MembersInjector<RootFragment<TeamFragmentPresenter>> rootFragmentMembersInjector1;
  private MembersInjector<TeamFragment> teamFragmentMembersInjector;
  private Provider<WalletFragmentPresenter> walletFragmentPresenterProvider;
  private MembersInjector<BaseFragment<WalletFragmentPresenter>> baseFragmentMembersInjector2;
  private MembersInjector<RootFragment<WalletFragmentPresenter>> rootFragmentMembersInjector2;
  private MembersInjector<WalletFragment> walletFragmentMembersInjector;
  private Provider<StoragePresenter> storagePresenterProvider;
  private MembersInjector<BaseFragment<StoragePresenter>> baseFragmentMembersInjector3;
  private MembersInjector<RootFragment<StoragePresenter>> rootFragmentMembersInjector3;
  private MembersInjector<StorageFragment> storageFragmentMembersInjector;
  private Provider<PlantPresenter> plantPresenterProvider;
  private MembersInjector<BaseFragment<PlantPresenter>> baseFragmentMembersInjector4;
  private MembersInjector<RootFragment<PlantPresenter>> rootFragmentMembersInjector4;
  private MembersInjector<MyPlantFragment> myPlantFragmentMembersInjector;
  private Provider<MyFragmentPresenter> myFragmentPresenterProvider;
  private MembersInjector<BaseFragment<MyFragmentPresenter>> baseFragmentMembersInjector5;
  private MembersInjector<RootFragment<MyFragmentPresenter>> rootFragmentMembersInjector5;
  private MembersInjector<MyFragment> myFragmentMembersInjector;

  private DaggerFragmentComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideActivityProvider = ScopedProvider.create(FragmentModule_ProvideActivityFactory.create(builder.fragmentModule));
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
    this.receiptFragmentPresenterProvider = ReceiptFragmentPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseFragmentMembersInjector = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), receiptFragmentPresenterProvider);
    this.rootFragmentMembersInjector = MembersInjectors.delegatingTo(baseFragmentMembersInjector);
    this.receiptFragmentMembersInjector = MembersInjectors.delegatingTo(rootFragmentMembersInjector);
    this.teamFragmentPresenterProvider = TeamFragmentPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseFragmentMembersInjector1 = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), teamFragmentPresenterProvider);
    this.rootFragmentMembersInjector1 = MembersInjectors.delegatingTo(baseFragmentMembersInjector1);
    this.teamFragmentMembersInjector = MembersInjectors.delegatingTo(rootFragmentMembersInjector1);
    this.walletFragmentPresenterProvider = WalletFragmentPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseFragmentMembersInjector2 = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), walletFragmentPresenterProvider);
    this.rootFragmentMembersInjector2 = MembersInjectors.delegatingTo(baseFragmentMembersInjector2);
    this.walletFragmentMembersInjector = MembersInjectors.delegatingTo(rootFragmentMembersInjector2);
    this.storagePresenterProvider = StoragePresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseFragmentMembersInjector3 = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), storagePresenterProvider);
    this.rootFragmentMembersInjector3 = MembersInjectors.delegatingTo(baseFragmentMembersInjector3);
    this.storageFragmentMembersInjector = MembersInjectors.delegatingTo(rootFragmentMembersInjector3);
    this.plantPresenterProvider = PlantPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseFragmentMembersInjector4 = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), plantPresenterProvider);
    this.rootFragmentMembersInjector4 = MembersInjectors.delegatingTo(baseFragmentMembersInjector4);
    this.myPlantFragmentMembersInjector = MembersInjectors.delegatingTo(rootFragmentMembersInjector4);
    this.myFragmentPresenterProvider = MyFragmentPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), getDataManagerProvider);
    this.baseFragmentMembersInjector5 = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), myFragmentPresenterProvider);
    this.rootFragmentMembersInjector5 = MembersInjectors.delegatingTo(baseFragmentMembersInjector5);
    this.myFragmentMembersInjector = MembersInjectors.delegatingTo(rootFragmentMembersInjector5);
  }

  @Override
  public Activity getActivity() {  
    return provideActivityProvider.get();
  }

  @Override
  public void inject(ReceiptFragment myClientFragment) {  
    receiptFragmentMembersInjector.injectMembers(myClientFragment);
  }

  @Override
  public void inject(TeamFragment orderListFragment) {  
    teamFragmentMembersInjector.injectMembers(orderListFragment);
  }

  @Override
  public void inject(WalletFragment customerServiceFragment) {  
    walletFragmentMembersInjector.injectMembers(customerServiceFragment);
  }

  @Override
  public void inject(StorageFragment storageFragment) {  
    storageFragmentMembersInjector.injectMembers(storageFragment);
  }

  @Override
  public void inject(MyPlantFragment myPlantFragment) {  
    myPlantFragmentMembersInjector.injectMembers(myPlantFragment);
  }

  @Override
  public void inject(MyFragment myFragment) {  
    myFragmentMembersInjector.injectMembers(myFragment);
  }

  public static final class Builder {
    private FragmentModule fragmentModule;
    private AppComponent appComponent;
  
    private Builder() {  
    }
  
    public FragmentComponent build() {  
      if (fragmentModule == null) {
        throw new IllegalStateException("fragmentModule must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException("appComponent must be set");
      }
      return new DaggerFragmentComponent(this);
    }
  
    public Builder fragmentModule(FragmentModule fragmentModule) {  
      if (fragmentModule == null) {
        throw new NullPointerException("fragmentModule");
      }
      this.fragmentModule = fragmentModule;
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

