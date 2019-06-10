package com.yijiu.e520.base;


/**
 * Created by Mr.yang on 2017/12/04
 * Presenter基类
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
