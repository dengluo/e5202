package com.yijiu.e520.di.module;


import android.util.Log;


import com.yijiu.e520.BuildConfig;
import com.yijiu.e520.app.App;
import com.yijiu.e520.app.Constants;
import com.yijiu.e520.di.qualifier.BaseUrl;
import com.yijiu.e520.di.qualifier.UserUrl;
import com.yijiu.e520.model.bean.UserBean;
import com.yijiu.e520.model.http.api.CartApi;
import com.yijiu.e520.model.http.api.OrderApis;
import com.yijiu.e520.model.http.api.UserApis;
import com.yijiu.e520.util.LogUtil;
import com.yijiu.e520.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by codeest on 2017/2/26.
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

//    @Singleton
//    @Provides
//    @ZhihuUrl
//    Retrofit provideZhihuRetrofit(Retrofit.Builder builder, OkHttpClient client) {
//        return createRetrofit(builder, client, ZhihuApis.HOST);
//    }
//
//    @Singleton
//    @Provides
//    @WechatUrl
//    Retrofit provideWechatRetrofit(Retrofit.Builder builder, OkHttpClient client) {
//        return createRetrofit(builder, client, WeChatApis.HOST);
//    }
//
//    @Singleton
//    @Provides
//    @GankUrl
//    Retrofit provideGankRetrofit(Retrofit.Builder builder, OkHttpClient client) {
//        return createRetrofit(builder, client, GankApis.HOST);
//    }

    @Singleton
    @Provides
    @UserUrl
    Retrofit provideGoldRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Constants.HOST_URL);
    }

    @Singleton
    @Provides
    @BaseUrl
    Retrofit provideUploadRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        Log.d("URL", "provideGoldRetrofit");
        return createRetrofit(builder, client, Constants.HOST_URL);
    }


    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        //TODO 设置统一的请求头部参数
        Interceptor apikey = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                long startTime = System.currentTimeMillis();
                Request request = chain.request();
                String ipAddress;
                String macAddress;
                String appVersionName;
                String optUserSid = "";
                String userName = "";
                String token = "";
                UserBean userBean = App.getInstance().getUserBeanInstance();
                if (userBean == null) {
//                    ipAddress = SystemUtil.getLocalIpAddress();
//                    macAddress = SystemUtil.getMacAddress();
//                    appVersionName = SystemUtil.getAppVersionName();
                } else {
//                    ipAddress = userBean.getIpAddress();
//                    macAddress = userBean.getMacAddress();
//                    appVersionName = userBean.getAppVersionName();
//                    optUserSid = String.valueOf(userBean.getSid());
//                    userName = userBean.getUserName();
                    token = userBean.getToken();
                }
                HttpUrl.Builder builder = request.url().newBuilder()
                        .scheme(request.url().scheme())
                        .host(request.url().host())
//                        .addQueryParameter("ipAddress", ipAddress)
//                        .addQueryParameter("macAddress", macAddress)
//                        .addQueryParameter("appVersionName", appVersionName)
                        .addQueryParameter("optUserSid", optUserSid)
                        .addQueryParameter("userName", userName)
                        .addQueryParameter("token", token);
                Request newRequest = request.newBuilder()
                        .method(request.method(), request.body())
                        .url(builder.build())
                        .build();

                Response response = chain.proceed(newRequest);
                MediaType mediaType = response.body().contentType();
                String content = response.body().string();
                LogUtil.d("------------------Start-----------------");
                LogUtil.d("URL:"+newRequest.url().toString());
                LogUtil.d("request: "+newRequest.toString());

                String method = request.method();
                if("POST".equals(method)){
                    StringBuilder sb = new StringBuilder();
                    if (request.body() instanceof FormBody) {
                        FormBody body = (FormBody) request.body();
                        for (int i = 0; i < body.size(); i++) {
                            sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                        }
                        if(sb.length()!=0){
                            sb.delete(sb.length() - 1, sb.length());
                        }
                        LogUtil.d("| RequestParams:{"+sb.toString()+"}");
                    }
                }
                long endTime = System.currentTimeMillis();
                long duration=endTime-startTime;
                LogUtil.d("response: "+content);
                LogUtil.d("-------------End：costs="+duration+"毫秒------------");

                return response.newBuilder().body(ResponseBody.create(mediaType,content)).build();
            }
        };
//        设置统一的请求头部参数
        builder.addInterceptor(apikey);
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    @Singleton
    @Provides
    UserApis provideGoldService(@UserUrl Retrofit retrofit) {
        return retrofit.create(UserApis.class);
    }

    @Singleton
    @Provides
    OrderApis provideOrderApiService(@BaseUrl Retrofit retrofit) {
        return retrofit.create(OrderApis.class);
    }

    @Singleton
    @Provides
    CartApi provideCartApiService(@BaseUrl Retrofit retrofit) {
        return retrofit.create(CartApi.class);
    }


    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
