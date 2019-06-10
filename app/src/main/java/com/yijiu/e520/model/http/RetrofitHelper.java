package com.yijiu.e520.model.http;


import com.yijiu.e520.model.bean.UserLoginVo;
import com.yijiu.e520.model.http.api.CartApi;
import com.yijiu.e520.model.http.api.OrderApis;
import com.yijiu.e520.model.http.api.UserApis;
import com.yijiu.e520.model.http.response.PadResultResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;


/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper implements HttpHelper {

    private UserApis mUserApisService;
    private OrderApis orderApis;
    private CartApi cartApi;


    @Inject
    public RetrofitHelper(UserApis userApisService, OrderApis orderApis, CartApi cartApi) {
        this.mUserApisService = userApisService;
        this.orderApis = orderApis;
        this.cartApi = cartApi;
    }

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Flowable<PadResultResponse<UserLoginVo>> login(String userName, String password) {
        return mUserApisService.login(userName, password);
    }

}
