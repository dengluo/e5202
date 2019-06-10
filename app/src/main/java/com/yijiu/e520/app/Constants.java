package com.yijiu.e520.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by codeest on 2016/8/3.
 */
public class Constants {



    //================= TYPE ====================

    //测试地址
//    public static final String HOST_URL = "http://192.168.1.11:9420/hmt-crm/";
//    public static final String HOST_URL = "http://192.168.1.55:9420/hmt-crm/111";
      public static final String HOST_URL = "http://123.57.7.113:9420/hmt-crm/";
    //================= KEY ====================


    public static final String BUGLY_ID = "01faf8d596";//BUGLY 官网申请

    //升级地址
    public static final String APK_DOWNLOAD_URL = "http://codeest.me/apk/geeknews.apk";


    //================= KEY ====================
    public static final String CODE_SUCCESS = "SUCCESS";
    public static final String CODE_FAIL = "FAIL";
    public static final String CODE_EXCEPTION = "EXCEPTION";

    public static final String CODE_INVALID_TOKEN = "INVALID_TOKEN";//无效的token,需要重新登录
    public static final String CODE_EMPTY_DATA = "EMPTY";

    public static final int START_PAGE = 0;//开始页码
    public static final int PAGE_SIZE = 10;//每页显示条数

    //================= PATH ====================

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "huamenttong" + File.separator + "hmtapp";

    //================= PREFERENCE ====================

    public static final String SP_NIGHT_MODE = "night_mode";

    public static final String SP_NO_IMAGE = "no_image";

    public static final String SP_AUTO_CACHE = "auto_cache";

    public static final String SP_CURRENT_ITEM = "current_item";

    public static final String SP_LIKE_POINT = "like_point";

    public static final String SP_VERSION_POINT = "version_point";

    public static final String SP_MANAGER_POINT = "manager_point";

    public static final String USER_NAME = "userName";

    public static final String SP_USER_INSTANCE_STR = "";

    //================= INTENT ====================
    public static final String IT_GANK_TYPE = "type";

    public static final String IT_GANK_TYPE_CODE = "type_code";

    public static final String IT_DETAIL_TITLE = "title";

    public static final String IT_DETAIL_URL = "url";

    public static final String IT_DETAIL_IMG_URL = "img_url";

    public static final String IT_DETAIL_ID = "id";

    public static final String IT_DETAIL_TYPE = "type";

    public static final String IT_GOLD_TYPE = "type";

    public static final String IT_GOLD_TYPE_STR = "type_str";

    public static final String IT_GOLD_MANAGER = "manager";

    public static final String IT_VTEX_TYPE = "type";

    public static final String IT_VTEX_TOPIC_ID = "id";

    public static final String IT_VTEX_REPLIES_TOP = "top_info";

    public static final String IT_VTEX_NODE_NAME = "node_name";

    /****************************20171212***********************************/
    public static final String VAILDATE_CODE = "vaildateCode";


    //===================正式图片服务器地址============================
    public static final String REMOTE_FTP_ADDRESS = "47.93.151.7";
    public static final String REMOTE_FTP_PORT = "21";
    public static final String REMOTE_FTP_USER = "wwwftp";
    public static final String REMOTE_FTP_PASS = "hmt4006608258";
    public static final String REMOTE_FTP_DIRECTORY_PROMOTION = "/var/ftp/PictureServer/images";
    public static final String FTP_ADDRESS = "image.huamengtong.com/images/";


}
