package com.yijiu.e520.model.http;


import com.yijiu.e520.model.bean.UserLoginVo;
import com.yijiu.e520.model.http.response.PadResultResponse;

import io.reactivex.Flowable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {
    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    Flowable<PadResultResponse<UserLoginVo>> login(String userName, String password);


}

