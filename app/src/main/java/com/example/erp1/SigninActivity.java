package com.example.erp1;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.Response;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.erp1.info.companyBean;
import com.example.erp1.info.dataBean;
import com.example.erp1.info.informationBean;
import com.example.erp1.login.loginBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class SigninActivity extends AppCompatActivity {
    private MyDatebaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        dbHelper = new MyDatebaseHelper( this, "ERP.db", null, 2 );
        setContentView( R.layout.activity_signin );
        // Bmob.initialize( this,"ae1eda892970b9ac009daa2d847ffcdc" );
        Button button1 = (Button) findViewById( R.id.submit );
//        final Button button2 = (Button) findViewById( R.id.register );
        final EditText edit_name = (EditText) findViewById( R.id.edit_name );
        final EditText edit_password = (EditText) findViewById( R.id.edit_password );
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = edit_name.getText().toString();
                final String password = edit_password.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                //login( name,password ,url);
                String url = "http://110.88.128.202:8088/stu/user/login";
                HttpUtil.loginWithOkHttp(name,password,url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        //在这里对异常情况进行处理
                    }
                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        //得到服务器返回的具体内容
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Headers headers=response.headers();
                                loginBean login=JSON.parseObject( responseData,loginBean.class );
                                int resultCode=login.getResultCode();
                                if (resultCode==200)
                                {
                                    decide(login.getData().getToken(),name);
                                }
                                else
                                {
                                    Toast.makeText( SigninActivity.this,login.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                    edit_name.setText( "" );
                                    edit_password.setText( "" );
                                }

                            }
                        });
                    }
                });
            }
        } );
//        button2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent( SigninActivity.this, RegisterActivity.class );
//                startActivity( intent );
//            }
//        } );
    }

    private void decide(final String token, final String name) {
        String url = "http://110.88.128.202:8088/stu/user/info";
        HttpUtil.info(token,url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println( "error" );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        informationBean info=JSON.parseObject( responseData,informationBean.class );
                        String status=info.getData().getCompany().getStatusString();
                        //System.out.println("info:"+ info.getData().getCompany().getStatusString() );
                        if(status.equals( "未注册" ))
                        {
                            Intent intent= new Intent( SigninActivity.this, RegisterActivity.class);
                            intent.putExtra( "name", name);
                            intent.putExtra( "token",token );
                            startActivity( intent );

                        }
                        else
                        {
                            Intent intent= new Intent( SigninActivity.this, MainActivity.class);
                            intent.putExtra( "name", name);
                            intent.putExtra( "token",token );
                            intent.putExtra( "userId",String.valueOf( info.getData().getCompany().getUserId() ) );
                            startActivity( intent );
                        }

                    }
                });

            }
        });
    }

}
