package com.yijiu.e520.model.prefs;


import com.yijiu.e520.model.bean.UserBean;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface PreferencesHelper {

    boolean getNightModeState();

    void setNightModeState(boolean state);

    boolean getNoImageState();

    void setUserInstance(UserBean userBean);

    UserBean getUserInstance();

//    void setNoImageState(boolean state);
//
//    boolean getAutoCacheState();
//
//    void setAutoCacheState(boolean state);
//
//    int getCurrentItem();
//
//    void setCurrentItem(int item);
//
//    boolean getLikePoint();
//
//    void setLikePoint(boolean isFirst);
//
//    boolean getVersionPoint();
//
//    void setVersionPoint(boolean isFirst);
//
//    boolean getManagerPoint();
//
//    void setManagerPoint(boolean isFirst);

}
