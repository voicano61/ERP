package com.example.erp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatebaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_User="create table User ("
            +"id integer primary key autoincrement,"
            +"username text,"
            +"password text)";
    public static final String userstate="create table UserState ("
            +"id integer primary key autoincrement,"
            +"applylong int,"
            +"start text,"
            +"applyshort text";
    private Context mContext;
    public MyDatebaseHelper( Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
        super( context, name, factory, version );
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( CREATE_User );
        Toast.makeText( mContext,"success!",Toast.LENGTH_LONG ).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "drop table if exists User" );
        onCreate( db );
    }
}
