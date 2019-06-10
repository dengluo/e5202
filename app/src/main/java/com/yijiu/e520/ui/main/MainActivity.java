package com.yijiu.e520.ui.main;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.yijiu.e520.R;
import com.yijiu.e520.app.App;
import com.yijiu.e520.base.RootActivity;
import com.yijiu.e520.base.contract.home.main.MainContract;
import com.yijiu.e520.model.bean.UserBean;
import com.yijiu.e520.presenter.home.main.MainPresenter;
import com.yijiu.e520.ui.fragment.WalletFragment;
import com.yijiu.e520.ui.fragment.ReceiptFragment;
import com.yijiu.e520.ui.fragment.MyFragment;
import com.yijiu.e520.ui.fragment.TeamFragment;
import com.yijiu.e520.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by k41 on 2017/12/12.
 */

public class MainActivity extends RootActivity<MainPresenter> implements MainContract.IMainView {
    //接单
    @BindView(R.id.tab_receipt)
    TextView tab_receipt;
    private ReceiptFragment receiptFragment;
    //团队
    @BindView(R.id.tab_team)
    TextView tab_team;
    private TeamFragment teamFragment;
    //钱包
    @BindView(R.id.tab_wallet)
    TextView tab_wallet;
    private WalletFragment walletFragment;
    //我的
    @BindView(R.id.tab_my)
    TextView tab_my;
    private MyFragment myFragment;

    private FragmentTransaction mTransaction;
    private int tag = -1;//默认选中的

    private SparseArray<Fragment> frags = new SparseArray<>();
    private SparseArray<TextView> textViews = new SparseArray<>();
    //两秒内按返回键两次退出程序
    private long exitTime = 0;
    private UserBean userBean;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    public static void verifyStoragePermissions(Activity activity) {

        try {
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        userBean = App.getInstance().getUserBeanInstance();
        mTransaction = getSupportFragmentManager().beginTransaction();
        initFrags();
        setDefaultFrag(tag);
    }

    @Override
    public void setDefaultFrag(int tag) {
        switchFrag(tag);
    }

    @Override
    public void switchFrag(int tag) {
        mTransaction = getSupportFragmentManager().beginTransaction();
        if (tag == -1) {//第一次进入时，没有需要隐藏的Frag
            tag = 0;
            mTransaction.add(R.id.container, frags.get(tag)).commit();
        } else {
            if (frags.get(tag).isAdded()) {
                mTransaction.hide(frags.get(this.tag)).show(frags.get(tag)).commit();
            } else {
                mTransaction.hide(frags.get(this.tag)).add(R.id.container, frags.get(tag)).commit();
            }
        }
        textViews.get(tag).setSelected(true);
        textViews.get(tag).setTextColor(mContext.getResources().getColor(R.color.text_color_bg));
        this.tag = tag;
    }


    @Override
    public void initFrags() {
        //接单
        receiptFragment = new ReceiptFragment();
        frags.put(0, receiptFragment);
        //团队
        teamFragment = new TeamFragment();
        frags.put(1, teamFragment);
        //钱包
        walletFragment = new WalletFragment();
        frags.put(2, walletFragment);
        //我的
        myFragment = new MyFragment();
        frags.put(3, myFragment);

        textViews.put(0, tab_receipt);
        textViews.put(1, tab_team);
        textViews.put(2, tab_wallet);
        textViews.put(3, tab_my);
        for (int i = 0; i < frags.size(); i++) {
            mTransaction.add(R.id.container, frags.get(i));
        }
    }

    @OnClick({R.id.tab_receipt, R.id.tab_team, R.id.tab_wallet, R.id.tab_my})
    public void click(View view) {
        int tag = Integer.valueOf(view.getTag().toString());
        if (tag != this.tag) {
            resetSelected();
            switchFrag(tag);
        }
    }

    /**
     * 根据tag切换指定 frag
     *
     * @param tag
     */
    public void swatch(int tag) {
        click(textViews.get(tag));
    }

    private void resetSelected() {
        tab_receipt.setSelected(false);
        tab_team.setSelected(false);
        tab_wallet.setSelected(false);
        tab_my.setSelected(false);
        for (int i = 0; i < textViews.size(); i++) {
            textViews.get(i).setTextColor(mContext.getResources().getColor(R.color.tab_text_color_unselected));
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                exitTime = System.currentTimeMillis();
                ToastUtil.shortShow("再按一次退出程序");
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
