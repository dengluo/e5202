package com.yijiu.e520.model.bean;

/**
 * Created by zcs on 2017/5/8.
 */

public class UserLoginVo {
    private int expires_in; //token失效时间 单位秒
    private UserBean userBean;
    private String token;

    public String getYeepay() {
        return yeepay;
    }

    public void setYeepay(String yeepay) {
        this.yeepay = yeepay;
    }

    private String yeepay;//易宝是否显示 0不显示 1显示

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
