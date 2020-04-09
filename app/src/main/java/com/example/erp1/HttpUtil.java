package com.example.erp1;
import android.os.Message;

import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    public static void loginWithOkHttp(String name,String password,String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("name",name)
                .add("pwd",password)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void register(String token,String pwd,String school,String major,String companyClass,String companyName,String declaration,String ceo,String cfo,String coo, String cpo,String cmo,String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
//        RequestBody body = new FormBody.Builder()
//                .add("pwd",pwd)
//                .add("school",school)
//                .add("major",major)
//                .add("companyClass",companyClass)
//                .add("companyName",companyName)
//                .add("declaration",declaration)
//                .add("ceo",ceo)
//                .add("cfo",cfo)
//                .add("coo",coo)
//                .add("cpo",cpo)
//                .add("cmo",cmo)
//                .build();
//        Request request = new Request.Builder()
//                .url(address)
//                .post(body)
//                .header( "token",token )
//                .build();
//        client.newCall(request).enqueue(callback);

        User user=new User();
        user.setPwd( pwd );
        user.setSchool( school );
        user.setMajor( major );
        user.setCompanyClass( companyClass );
        user.setCompanyName( companyName );
        user.setDeclaration( declaration );
        user.setCeo( ceo );
        user.setCfo(cfo);
        user.setCoo( coo );
        user.setCpo( cpo );
        user.setCmo( cmo );
        Gson gson = new Gson();
        String json = gson.toJson(user);
        RequestBody requestBody = RequestBody.create( MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
                .url(address)//请求的url
                .post(requestBody)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void decide(String token,String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
// .cache(new Cache())
// .addInterceptor(interceptor)//这里可以继续添加多种拦截器
                .addInterceptor(new TokenInterceptor())//添加获取token的拦截器
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void applyLong(String time,String num,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("amount",num)
                .add("year",time)
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/loan/applyLong")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
