package com.example.erp1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SigninActivity extends AppCompatActivity {
    private MyDatebaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        dbHelper = new MyDatebaseHelper( this, "ERP.db", null, 2 );
        setContentView( R.layout.activity_signin );
       // Bmob.initialize( this,"ae1eda892970b9ac009daa2d847ffcdc" );
        Button button1=(Button)findViewById(R.id.submit);
        final Button button2=(Button)findViewById( R.id.register );
        final EditText edit_name=(EditText)findViewById( R.id.edit_name );
        final EditText edit_password=(EditText)findViewById( R.id.edit_password);
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = edit_name.getText().toString();
                String password = edit_password.getText().toString();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                //Cursor cursor = db.rawQuery("select * from User where username =? and password=?", new String[]{name,password});
//                while (cursor.moveToNext()) {
//                    Toast.makeText( SigninActivity.this,"登录成功",Toast.LENGTH_SHORT ).show();
//                    Intent intent=new Intent( SigninActivity.this, MainActivity.class );
//                    intent.putExtra( "name",name );
//                    startActivity( intent );
//                }
                int i=0;
                Cursor cursor = db.rawQuery("select * from User", null);
                while (cursor.moveToNext()) {
                    String n= cursor.getString(cursor.getColumnIndex("username"));
                    String p = cursor.getString(cursor.getColumnIndex("password"));
                   // String state=cursor.getString( cursor.getColumnIndex( "state" ) );
                    if(n.equals( name ))
                    {
                        if(p.equals( password ))
                        {
                            Toast.makeText( SigninActivity.this,"登录成功",Toast.LENGTH_SHORT ).show();
                            Intent intent=new Intent( SigninActivity.this, MainActivity.class );
                            intent.putExtra( "name",name );
                           // intent.putExtra( "state",state );
                            startActivity( intent );
                        }
                        else
                        {
                            Toast.makeText( SigninActivity.this,"密码错误",Toast.LENGTH_SHORT ).show();
                            edit_password.setText( "" );
                        }
                    }
                    else
                    {
                        i=i+1;
                    }
                    if(i==cursor.getCount())
                    {
                        Toast.makeText( SigninActivity.this,"用户名不存在",Toast.LENGTH_SHORT ).show();
                        edit_name.setText( "" );
                        edit_password.setText( "" );
                    }
                }
            }
        });
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( SigninActivity.this, RegisterActivity.class );
                startActivity( intent );
            }
        } );
    }
}
