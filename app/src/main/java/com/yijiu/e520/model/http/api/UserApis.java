package com.yijiu.e520.model.http.api;

import com.yijiu.e520.model.bean.UserLoginVo;
import com.yijiu.e520.model.http.response.PadResultResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mr.yang
 * on 2017/12/5
 *
 * @description 用户相关api
 * @Version
 */

public interface UserApis {

    /**
     * 用户登录
     */
    @GET("crmlogin/login/{userName}/{password}")
    Flowable<PadResultResponse<UserLoginVo>> login(@Path("userName") String userName, @Path("password") String password);

    /**
     * 修改密码
     */
    @GET("crmlogin/updatePwd/{userSid}/{oldPassword}/{newPassword}")
    Flowable<PadResultResponse<String>> updatePwd(@Path("userSid") Long userSid, @Path("oldPassword") String oldPassword, @Path("newPassword") String newPassword);

    }

