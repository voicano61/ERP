package com.example.erp1;
import android.os.Message;

import com.example.erp1.report.balanceBean;
import com.example.erp1.report.chargeBean;
import com.example.erp1.report.profitBean;
import com.example.erp1.report.reportBean;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    //登录
    public static void loginWithOkHttp(String name,String password,String address,okhttp3.Callback callback)
    {
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
    //注册(
    public static void register(String token,String pwd,String school,String major,String companyClass,String companyName,String declaration,String ceo,String cfo,String coo, String cpo,String cmo,String address,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
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
    //用户信息
    public static void info(String token,String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //贷款
    public static void applyLong(String token,String time,String num,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("amount",num)
                .add("year",time)
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/loan/applyLong")
                .post(body)
                .header( "token" ,token)
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void applyShort(String token,String num,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("amount",num)
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/loan/applyShort")
                .post(body)
                .header( "token" ,token)
                .build();
        client.newCall(request).enqueue(callback);
    }

    //当季开始,结束
    public static void start(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/quarter/start")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void end(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/quarter/end")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //原料更新,购买
    public static void update(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/material/update")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void buy(String token,String nums,String ids,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "nums",nums )
                .add( "ids",ids )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/material/buy")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //生产线
    public static void newLine(String token,String workshopId,String productId,String productLineId,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("workshopId",workshopId)
                .add("productId",productId)
                .add( "productLineId",productLineId )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/new")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void invest(String token,String productLineIds,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "productLineIds",productLineIds )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/invest")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void sell(String token,String ids,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/sell")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void startProduce(String token,String productLineIds,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "productLineIds",productLineIds )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/starProduce")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void change(String token,String productLineIds,String productId,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "productLineIds",productLineIds )
                .add( "productId",productId )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/change")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void buildingList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/buildingList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void changeList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/changeList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void changingList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/changingList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void freeList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/productLine/freeList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //更新应收款帐
    public static void receviable(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/receivale/update")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //产品
    public static void developingProductList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/production/developingList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void developProduct(String token,String productIds,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "productIds",productIds )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/production/develop")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //市场
    public static void developingMarketList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/market/developingList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void developMarket(String token,String ids,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/market/develop")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //iso
    public static void developingISOList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/iso/developingList")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void developISO(String token,String ids,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/iso/develop")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //报表
    public static void get(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/report/get")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void save(String token,int []charges,int []profits,int []balances,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        chargeBean charge=new chargeBean();
        profitBean profit=new profitBean();
        balanceBean balance=new balanceBean();
        reportBean report=new reportBean();

        charge.setAdminstrativeCost( charges[0] );
        charge.setAdCost( charges[1] );
        charge.setMaintenanceCost( charges[2] );
        charge.setLoss( charges[3] );
        charge.setTurnOverCost( charges[4] );
        charge.setRentCost( charges[5] );
        charge.setDevelopingMarketCost( charges[6] );
        charge.setDevelopingProductCost( charges[7] );
        charge.setDevelopingIsoCost( charges[8] );
        charge.setInformationCost( charges[9] );
        charge.setTotal( charges[10] );

        profit.setSales( profits[0] );
        profit.setDirectCost( profits[1] );
        profit.setComprehensiveCost( profits[2] );
        profit.setDepreciationCost( profits[3] );
        profit.setFinancialCost( profits[4] );
        profit.setTax( profits[5] );
        profit.setGrossProfit( profits[6] );
        profit.setProfitBeforeTax( profits[7] );
        profit.setProfitBeforeDepreciation( profits[8] );
        profit.setProfitBeforeInterest( profits[9] );

        balance.setCash( balances[0] );
        balance.setLongLoan( balances[1] );
        balance.setReceivable( balances[2] );
        balance.setShortLoan( balances[3] );
        balance.setProductInProcess( balances[4] );
        balance.setSpecialLoan( balances[5] );
        balance.setProduct( balances[6] );
        balance.setTax( balances[7] );
        balance.setMaterial( balances[8] );
        balance.setWorkshop( balances[9] );
        balance.setEquity( balances[10] );
        balance.setEquipment( balances[11] );
        balance.setRetainedEarning( balances[12] );
        balance.setConstructionInProcess( balances[13] );
        balance.setAnualNetProfit( balances[14] );
        balance.setTotalDebt( balances[15] );
        balance.setTotalCurrentAsset( balances[16] );
        balance.setTotalFixedAsset( balances[17] );
        balance.setTotalEquity( balances[18] );
        balance.setTotalAsset( balances[19] );
        balance.setTotal( balances[20] );

        report.setCharge( charge );
        report.setProfit( profit );
        report.setBalance( balance );

        Gson gson = new Gson();
        String json = gson.toJson(report);
        RequestBody requestBody = RequestBody.create( MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/report/save")//请求的url
                .post(requestBody)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void submit(String token,int []charges,int []profits,int []balances,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        chargeBean charge=new chargeBean();
        profitBean profit=new profitBean();
        balanceBean balance=new balanceBean();
        reportBean report=new reportBean();

        charge.setAdminstrativeCost( charges[0] );
        charge.setAdCost( charges[1] );
        charge.setMaintenanceCost( charges[2] );
        charge.setLoss( charges[3] );
        charge.setTurnOverCost( charges[4] );
        charge.setRentCost( charges[5] );
        charge.setDevelopingMarketCost( charges[6] );
        charge.setDevelopingProductCost( charges[7] );
        charge.setDevelopingIsoCost( charges[8] );
        charge.setInformationCost( charges[9] );
        charge.setTotal( charges[10] );

        profit.setSales( profits[0] );
        profit.setDirectCost( profits[1] );
        profit.setComprehensiveCost( profits[2] );
        profit.setDepreciationCost( profits[3] );
        profit.setFinancialCost( profits[4] );
        profit.setTax( profits[5] );
        profit.setGrossProfit( profits[6] );
        profit.setProfitBeforeTax( profits[7] );
        profit.setProfitBeforeDepreciation( profits[8] );
        profit.setProfitBeforeInterest( profits[9] );

        balance.setCash( balances[0] );
        balance.setLongLoan( balances[1] );
        balance.setReceivable( balances[2] );
        balance.setShortLoan( balances[3] );
        balance.setProductInProcess( balances[4] );
        balance.setSpecialLoan( balances[5] );
        balance.setProduct( balances[6] );
        balance.setTax( balances[7] );
        balance.setMaterial( balances[8] );
        balance.setWorkshop( balances[9] );
        balance.setEquity( balances[10] );
        balance.setEquipment( balances[11] );
        balance.setRetainedEarning( balances[12] );
        balance.setConstructionInProcess( balances[13] );
        balance.setAnualNetProfit( balances[14] );
        balance.setTotalDebt( balances[15] );
        balance.setTotalCurrentAsset( balances[16] );
        balance.setTotalFixedAsset( balances[17] );
        balance.setTotalEquity( balances[18] );
        balance.setTotalAsset( balances[19] );
        balance.setTotal( balances[20] );

        report.setCharge( charge );
        report.setProfit( profit );
        report.setBalance( balance );

        Gson gson = new Gson();
        String json = gson.toJson(report);
        RequestBody requestBody = RequestBody.create( MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/report/submit")//请求的url
                .post(requestBody)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //广告
    public static void adSubmit(String token,String ads,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ads",ads )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/ad/submit")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //贴现
    public static void discountList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/discount/list")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void discountSubmit(String token,String discount1,String discount2,String discount3,String discount4,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "discount1",discount1 )
                .add( "discount2",discount2 )
                .add( "discount3",discount3 )
                .add( "discount4",discount4 )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/discount/submit")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //紧急采购
    public static void purchasetList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/purchase/list")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void buyProduct(String token,String ids,String nums,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .add( "nums",nums )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/purchase/product/submit")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void buyMaterial(String token,String ids,String nums,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .add( "nums",nums )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/purchase/material/submit")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //出售库存
    public static void sellList(String token,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/sell/list")
                .post(okhttp3.internal.Util.EMPTY_REQUEST)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void sellProduct(String token,String ids,String nums,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .add( "nums",nums )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/sell/product/submit")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void sellMaterial(String token,String ids,String nums,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "ids",ids )
                .add( "nums",nums )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/sell/material/submit")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    //间谍
    public static void spy(String token,String userId,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "userId",userId )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/spy/get")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }




    //教师登录
    public static void tlogin(okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "name","ljm" )
                .add( "pwd","1 ")
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/common/login/login")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    //厂房
    public static void disposeList(String token,String type,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "type",type )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/workshop/disposeList")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void buyworkshop(String token,String workshopId,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "workshopId",workshopId )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/workshop/buy")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void rentworkshop(String token,String workshopId,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "workshopId",workshopId )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/workshop/rent")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void disposeworkshop(String token,String workshopId,String disposeType,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "workshopId",workshopId )
                .add("disposeType",disposeType)
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/workshop/dispose")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void discountworkshop(String token, String id, Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add( "id",id )
                .build();
        Request request = new Request.Builder()
                .url("http://110.88.128.202:8088/stu/ops/workshop/discount")
                .post(body)
                .header( "token",token )
                .build();
        client.newCall(request).enqueue(callback);
    }
}
