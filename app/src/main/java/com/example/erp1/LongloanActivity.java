package com.example.erp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erp1.R;

public class LongloanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_longloan );
        final Spinner spinner=(Spinner)findViewById( R.id.spinner );
        final EditText number=(EditText)findViewById( R.id.number );
        //final int  num=Integer.parseInt( number.getText().toString() );
        final String num=number.getText().toString();
        Button yes=(Button)findViewById( R.id.yes );
        Button no =(Button)findViewById( R.id.no );
        View view=getLayoutInflater().inflate( R.layout.operation1,null );
        final Button longloan=view.findViewById( R.id.longloan );

        //长贷时间
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.times);
                TextView tv = (TextView)view;
                tv.setTextColor( Color.parseColor( "#000000" )); //设置颜色
                tv.setTextSize(15.0f); //设置大小
                tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                // Toast.makeText(MainActivity.this, "你点击的是:"+languages[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
        yes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num.equals( "" )||num.length()==0) {
                    Toast.makeText( LongloanActivity.this,"长贷金额0", Toast.LENGTH_SHORT ).show();
                }
                else {
                    Toast.makeText( LongloanActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                }

//                Intent intent=new Intent( );
//                intent.putExtra( "button","1" );
//                setResult( RESULT_OK,intent );
                longloan.setEnabled( false );
                finish();

            }
        } );
        no.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();//点击窗口外部区域 弹窗消失
        return true;
    }
}
