package com.yijiu.e520.presenter.home.loginpresenter;



import com.yijiu.e520.base.RxPresenter;
import com.yijiu.e520.base.contract.home.logincontract.UpdatePasswdForMoildeContract;
import com.yijiu.e520.model.DataManager;

import javax.inject.Inject;

/**
 * Created by zcs on 2017/5/26.
 */

public class MobileUpdatePasswdPresenter extends RxPresenter<UpdatePasswdForMoildeContract.View> implements UpdatePasswdForMoildeContract.Presenter {

    private DataManager dataManager;

    @Inject
    public MobileUpdatePasswdPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void forgetPassword(String mobile ,String vaildateCode,String newPwd) {
//        addSubscribe(dataManager.forgetPassword(mobile,vaildateCode ,newPwd)
//                .compose(RxUtil.<PadResultResponse<String>>rxSchedulerHelper())
//                .subscribeWith(new CommonSubscriber<String>(mView, true) {
//                    @Override
//                    public void dataHandle(Boolean aBoolean) {
//                        if (aBoolean) {
//                            mView.updatePasswdSuccess(aBoolean);
//                            ToastUtil.shortShow("修改密码成功");
//                        } else {
//                            mView.showMsgDialog("修改密码", "失败");
//                        }
//                    }
//                }));
    }
}
