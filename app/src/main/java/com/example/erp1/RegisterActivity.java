package com.example.erp1;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private MyDatebaseHelper dbHelper;
    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );
        dbHelper=new MyDatebaseHelper( this,"ERP.db",null,2 );

//        EditText username=(EditText)findViewById( R.id.edit_name );
//        EditText userpassword=(EditText)findViewById( R.id.edit_password );
//        name=username.getText().toString();
//        password=userpassword.getText().toString();
        final EditText companyname=(EditText)findViewById( R.id.companyname );//不能为空
        final EditText password=(EditText)findViewById( R.id.password );//不能为空
        final EditText edit_manager=(EditText)findViewById( R.id.manager );//不能为空
        final EditText edit_school=(EditText)findViewById( R.id.school );//不能为空
        final EditText edit_finance=(EditText)findViewById( R.id.finance );//不能为空
        final EditText edit_major=(EditText)findViewById( R.id.major );
        final EditText edit_purchasing=(EditText)findViewById( R.id.purchasing );//不能为空
        final EditText edit_theclass=(EditText)findViewById( R.id.theclass );
        final EditText edit_sales=(EditText)findViewById( R.id.sales );//不能为空
        final EditText edit_declaration=(EditText)findViewById( R.id.declaration );
        Button button=(Button) findViewById( R.id.submit );
        Button back=(Button) findViewById( R.id.back );
        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cname=companyname.getText().toString();
                final String pword=password.getText().toString();
                final String manager=edit_manager.getText().toString();
                final String school=edit_school.getText().toString();
                final String finance=edit_finance.getText().toString();
                final String major=edit_major.getText().toString();
                final String purchasing=edit_purchasing.getText().toString();
                final String theclass=edit_theclass.getText().toString();
                final String sales=edit_sales.getText().toString();
                final String declaration=edit_declaration.getText().toString();


                if (cname.length()==0||cname.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("公司名不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    companyname.setText( "" );
                                    password.setText( "" );
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else if(pword.length()==0||pword.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("新密码不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else if(manager.length()==0||manager.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("总经理名称不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else if(school.length()==0||school.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("学校不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else if(finance.length()==0||finance.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("财务总监名称不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else if(purchasing.length()==0||purchasing.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("采购总监名称不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else if(sales.length()==0||sales.equals( "" ))
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("销售总监名称不能为空")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog2.show();
                }
                else
                {
                    alertDialog2
                            .setTitle("信息")
                            .setMessage("是否开始经营")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    SQLiteDatabase db=dbHelper.getWritableDatabase();
                                    ContentValues values=new ContentValues(  );
                                    values.put( "username",cname );
                                    values.put( "password",pword );
                                    db.insert( "User",null ,values);
                                    values.clear();
//                    SQLiteDatabase db=dbHelper.getWritableDatabase();
//                    ContentValues values=new ContentValues(  );
//                    values.put( "username",cname );
//                    values.put( "password",pword );
//                    values.put( "state","operation1" );
//                    db.insert( "Users",null ,values);
//                    values.clear();
                                    Toast.makeText( RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent( RegisterActivity.this,SigninActivity.class);
                                    startActivity( intent);
                                }
                            })
                            .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            } )
                            .create();
                    alertDialog2.show();

                }
            }
        } );
        back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,SigninActivity.class);
                startActivity( intent );
            }
        } );
    }
}
