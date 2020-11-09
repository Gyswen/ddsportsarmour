package com.example.ddsportsarmour.Basehttp;

import com.example.ddsportsarmour.Api.ApiServise;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class BaseRequest {
    //初始化Okhttp,绑定拦截器事件
    OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(20, TimeUnit.SECONDS).    //设置请求超时时间
            readTimeout(20,TimeUnit.SECONDS).        //设置读取数据超时时间
            writeTimeout(20,TimeUnit.SECONDS).       //设置写入数据超时时间
            addInterceptor(InterceptorUtil.LogInterceptor()). //绑定日志拦截器
            addNetworkInterceptor(InterceptorUtil.HeaderInterceptor()).   //绑定header拦截器
            build();

    Retrofit retrofit = new Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create()).
            addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
            baseUrl(ApiServise.HOST).
            client(client).
            build();

    public static BaseRequest instance;
    public ApiServise apiServise = retrofit.create(ApiServise.class);

    private BaseRequest(){

    }
    public static BaseRequest getInstance(){
        if(instance==null){
            synchronized (BaseRequest.class){
                if(instance==null){
                    instance=new BaseRequest();
                }
            }
        }
        return instance;
    }

    public ApiServise getApiServise(){
        return apiServise;
    }

}
