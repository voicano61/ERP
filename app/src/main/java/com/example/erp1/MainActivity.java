package com.example.erp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.erp1.discount.discountListBean;
import com.example.erp1.dispose.disposeListBean;
import com.example.erp1.info.developIsoBean;
import com.example.erp1.info.developMarketBean;
import com.example.erp1.info.developProductBean;
import com.example.erp1.info.informationBean;
import com.example.erp1.info.loanBean;
import com.example.erp1.info.materialBean;
import com.example.erp1.info.productBean;
import com.example.erp1.info.productLineBean;
import com.example.erp1.info.receivableBean;
import com.example.erp1.info.transportBean;
import com.example.erp1.info.workshopBean;
import com.example.erp1.purchase.dataBean;
import com.example.erp1.purchase.purchaseListBean;
import com.example.erp1.spy.spyBean;
import com.example.erp1.tLogin.loginBean;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private MyDatebaseHelper dbHelper;
    private ArrayAdapter<String> adapter;
    private DrawerLayout mDrawerLayout;
    private  List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final Intent intent = getIntent();
        final String name = intent.getStringExtra( "name" );
        final String token=intent.getStringExtra( "token" );
        setInfo( token );
        Button help = (Button) findViewById( R.id.help );
        Button notice=(Button)findViewById( R.id.notice );
        Button signout=(Button)findViewById( R.id.signout );
        Button finance=(Button)findViewById( R.id.finance );
        Button research=(Button)findViewById( R.id.research );
        Button inventory=(Button)findViewById( R.id.inventory);
        final LinearLayout finance_message=(LinearLayout)findViewById( R.id.finance_message );
        dbHelper = new MyDatebaseHelper( this, "ERP.db", null, 2 );


        final View view1=getLayoutInflater().inflate( R.layout.operation1,null);
        final View view2=getLayoutInflater().inflate( R.layout.operation2,null );
        final View view3=getLayoutInflater().inflate( R.layout.operation3,null );
        final View view4=getLayoutInflater().inflate( R.layout.operation4 ,null);
        final View view5=getLayoutInflater().inflate( R.layout.operation_end,null );
        final View view6=getLayoutInflater().inflate( R.layout.operation_yearend,null);
        final View normal=getLayoutInflater().inflate( R.layout.normal,null);

        final LinearLayout linearLayout=(LinearLayout)findViewById( R.id.page1 );
//        final  LinearLayout linearLayout3=(LinearLayout)findViewById( R.id.mainoperation );
        final LinearLayout linearLayout2=(LinearLayout)findViewById( R.id.page2 );
        linearLayout2.addView( normal );
        Button discount=normal.findViewById( R.id.discount );
        //Button discount2=view2.findViewById( R.id.discount );
        Button purchase=normal.findViewById( R.id.purchase );
       // Button purchase2=view2.findViewById( R.id.purchase );
        //Button purchase3=view3.findViewById( R.id.purchase );
        Button soldinventory=normal.findViewById( R.id.soleinventory );
       // Button soldinventory2=view2.findViewById( R.id.soleinventory );
       // Button soldinventory3=view3.findViewById( R.id.soleinventory );
        Button factorydiscount=normal.findViewById( R.id.factorydiscount );
        //Button factorydiscount2=view2.findViewById( R.id.factorydiscount );
        //Button factorydiscount3=view3.findViewById( R.id.factorydiscount );
        Button ordermessage=normal.findViewById( R.id.ordermessage );
       // Button ordermessage2=view2.findViewById( R.id.ordermessage );
       // Button ordermessage3=view3.findViewById( R.id.ordermessage );
        Button spy=normal.findViewById( R.id.spy );
        //Button spy2=view2.findViewById( R.id.spy );
        //Button spy3=view3.findViewById( R.id.spy );



            linearLayout.addView( view1 );
        final Button longloan=view1.findViewById( R.id.longloan );
        final Button start=view1.findViewById( R.id.start );
        final Button shortloan=view2.findViewById( R.id.shortloan );
        Button update=view2.findViewById( R.id.update );
        final Button buy=view3.findViewById( R.id.buy );
       // buy.setVisibility(View.VISIBLE);
        final Button buy_workshop=view3.findViewById( R.id.buy_workshop );
        final Button createline=view3.findViewById( R.id.createline );
        final Button update1=view3.findViewById( R.id.update );
        final Button construction=view3.findViewById( R.id.construction );
        final Button changeline=view3.findViewById( R.id.changeline );
        final Button continuechange=view3.findViewById( R.id.continuechange );
        final Button soldline=view3.findViewById( R.id.soldline );
        final Button startproduction=view3.findViewById( R.id.startproduction );

        final Button delivery=view4.findViewById( R.id.delivery );
        final Button managefactory=view4.findViewById( R.id.managefactory );
        final Button researchproduct=view4.findViewById( R.id.researchproduct );
        final Button end=view4.findViewById( R.id.end );


        final Button delivery1=view5.findViewById( R.id.delivery );
        final Button managefactory1=view5.findViewById( R.id.managefactory );
        final Button researchproduct1=view5.findViewById( R.id.researchproduct );
        final Button exploit=view5.findViewById( R.id.exploit );
        final Button investment=view5.findViewById( R.id.investment );
        final Button end1=view5.findViewById( R.id.end );

        final Button report=view6.findViewById( R.id.report );
        final Button advertising=view6.findViewById( R.id.advertising );
        final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialog2=new AlertDialog.Builder( this);
        final AlertDialog.Builder alertDialog3=new AlertDialog.Builder( this);
        final AlertDialog.Builder alertDialog4=new AlertDialog.Builder( this);
        final AlertDialog.Builder alertDialog5=new AlertDialog.Builder( this );

        final View dialogView=View.inflate( MainActivity.this,R.layout.longloan,null );
        final View buyview=View.inflate( MainActivity.this,R.layout.buy,null );
        //final  View dialogView1=View.inflate( MainActivity.this,R.layout.start,null );
       // final View dialogView2=View.inflate( MainActivity.this,R.layout.shortloan,null );
//        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
//        final AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(this);
//        final AlertDialog.Builder alertDialog4 = new AlertDialog.Builder(this);
        final ScrollView financepage=(ScrollView)findViewById( R.id.financepage );
        final ScrollView researchpage=(ScrollView)findViewById( R.id.researchpage );
        final ScrollView inventorypage=(ScrollView)findViewById( R.id.inventorypage );


        final TextView username = (TextView) findViewById( R.id.name );
        SpannableString spannableString = new SpannableString( name );
        spannableString.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        username.append( spannableString );



//        View view=getLayoutInflater().inflate(R.layout.longloan,null);

        //帮助，公告信息，退出系统
        help.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, HelpPageActivity.class );
                intent.putExtra("name",name);
                startActivity( intent );
            }
        } );
        notice.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText( MainActivity.this,statusString,Toast.LENGTH_SHORT ).show();
                Intent intent=new Intent( MainActivity.this,NoticeActivity.class );
                startActivity( intent);
            }
        } );
        signout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog3
                        .setTitle("信息")
                        .setMessage("是否退出？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                            @Override
                            public void onClick(final DialogInterface dialogInterface, int i) {
                                Intent intent1=new Intent( MainActivity.this,SigninActivity.class );
                                startActivity( intent1 );
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                alertDialog3.show();
            }
        } );


        finance.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (financepage.getVisibility()==View.VISIBLE)
                {
                    financepage.setVisibility(View.GONE);
                }
                else if (financepage.getVisibility()==View.GONE)
                {
                    financepage.setVisibility(View.VISIBLE );
                }
            }
        } );
        research.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (researchpage.getVisibility()==View.VISIBLE)
                {
                    researchpage.setVisibility(View.GONE);
                }
                else if (researchpage.getVisibility()==View.GONE)
                {
                    researchpage.setVisibility(View.VISIBLE );
                }
            }
        } );
        inventory.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inventorypage.getVisibility()==View.VISIBLE)
                {
                    inventorypage.setVisibility(View.GONE);
                }
                else if (inventorypage.getVisibility()==View.GONE)
                {
                    inventorypage.setVisibility(View.VISIBLE );
                }
            }
        } );
        //操作台


        //申请长贷
        longloan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.longloan, null);
                final Spinner spinner=(Spinner)linearLayout1.findViewById( R.id.spinner );
                final EditText number=linearLayout1.findViewById( R.id.number );
                //final int  num=Integer.parseInt( number.getText().toString() );
                final String num=number.getText().toString();
                final String[] time = new String[1];
                //长贷时间
                spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String[] languages = getResources().getStringArray(R.array.times);
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        time[0] =languages[position];
                       // Toast.makeText(MainActivity.this, "你点击的是:"+languages[position], Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                } );

                alertDialog1.setTitle( "申请长贷" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if(num.equals( "" )||num.length()==0) {
                                    Toast.makeText( MainActivity.this,"长贷金额0",Toast.LENGTH_SHORT ).show();
                                }
                                else {

                                }

                                longloan.setEnabled( false );

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();

            }
        } );
        //当季开始
        start.setOnClickListener( new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.start,null );
                alertDialog1.setTitle( "当季开始" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                linearLayout.addView( view2);

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //申请短贷
        shortloan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.shortloan,null);
                EditText number=linearLayout1.findViewById( R.id.number );
                final String num=number.getText().toString();
                alertDialog1.setTitle( "申请短贷" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if(num.equals( "" )||num.length()==0) {
                                    Toast.makeText( MainActivity.this,"短贷金额0",Toast.LENGTH_SHORT ).show();
                                }
                                else {
                                    Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                }
                                shortloan.setVisibility( View.GONE );
                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();


            }
        } );

        //更新原料库
        update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog2.setTitle( "更新原料库" )
                        .setMessage( "现付金额 " )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                //linearLayout2.setVisibility( View.GONE );
                                linearLayout.addView( view3 );


                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog2.show();
            }
        } );
        //订购原料
        buy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.buy,null );
                final EditText number1=linearLayout1.findViewById( R.id.r1_number );
                final EditText number2=linearLayout1.findViewById( R.id.r2_number );
                final EditText number3=linearLayout1.findViewById( R.id.r3_number );
                final EditText number4=linearLayout1.findViewById( R.id.r4_number );
                alertDialog1.setTitle( "订购原料" )
                        .setView(linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"R1:"+number1.getText().toString()+",R2="+number2.getText().toString()+",R3="+number3.getText().toString()+",R4="+number4.getText().toString(),Toast.LENGTH_SHORT ).show();
                                buy.setVisibility( View.GONE );
                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();

            }
        } );
        //购（租）厂房
        buy_workshop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.buy_workshop, null);
                final Spinner spinner=(Spinner)linearLayout1.findViewById( R.id.spinner );
                final RadioButton radioButton1=(RadioButton)linearLayout1.findViewById( R.id.radioButton1 );
                final RadioButton radioButton2=(RadioButton)linearLayout1.findViewById( R.id.radioButton2 );
                //final RadioGroup radioGroup=(RadioGroup)linearLayout1.findViewById( R.id.radioGroup );
                final String[] s = {""};
                spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String[] languages = getResources().getStringArray(R.array.workshop);
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        s[0] =languages[position];
                        // Toast.makeText(MainActivity.this, "你点击的是:"+languages[position], Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                } );
                alertDialog1.setTitle( "新建厂房" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )

                        .create();
                alertDialog1.show();
            }
        } );
        //新建生产线

        createline.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] s = {""};
                final String[] line = {""};
                final String[] c = {""};
                final int[] d = {0};
                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.createline, null);
                final RadioButton p1=linearLayout1.findViewById( R.id.p1 );
                final RadioButton p2=linearLayout1.findViewById( R.id.p2 );
                final RadioButton p3=linearLayout1.findViewById( R.id.p3 );
                final RadioButton p4=linearLayout1.findViewById( R.id.p4 );
                final RadioButton p5=linearLayout1.findViewById( R.id.p5 );
                final Spinner spinner1=(Spinner)linearLayout1.findViewById( R.id.spinner1 );
                final Spinner spinner2=(Spinner)linearLayout1.findViewById( R.id.spinner2 );
                //所属厂房
                list =new ArrayList<String>();
                list.add( "请选择厂房" );

                createline();
                spinner1.setAdapter( adapter );
                spinner1.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        c[0] =list.get( position );
                        d[0] =position;
                        //Toast.makeText(MainActivity.this, "你点击的是:"+ c[0], Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                } );
                //生产线类型
                spinner2.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String[] languages = getResources().getStringArray(R.array.line);
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        s[0] =languages[position];
                        //Toast.makeText(MainActivity.this, "你点击的是:"+languages[position], Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                } );
                alertDialog1.setTitle( "新建生产线" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();

            }
        } );
        //在建生产线
        construction.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.construction,null);
                alertDialog1.setTitle( "在建生产线" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //生产线转产
        changeline.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.changeline,null);
                alertDialog1.setTitle( "生产线转产" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //继续转产
        continuechange.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.continuechangeline,null);
                alertDialog1.setTitle( "继续转产" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //出售生产线
        soldline.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.soldline,null);
                alertDialog1.setTitle( "出售生产线" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //开始生产
        startproduction.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.startproduction,null);
                alertDialog1.setTitle( "开始生产" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );


        //更新应收款账
        update1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog2.setTitle( "更新应收款账" )
                        .setMessage( "收现金额(1期)  " )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                //linearLayout2.setVisibility( View.VISIBLE );
//                                if(i%4==0&&i!=0)
//                                {
//                                    linearLayout.addView( view5 );
//                                }
//                                else {
//                                    linearLayout.addView( view4 );
//                                }

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog2.show();

            }
        } );
        //按订单交货
        delivery.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delivery();
            }
        } );
        delivery1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delivery();
            }
        } );
        //厂房处理
        managefactory.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managefactory();
            }
        } );
        managefactory1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managefactory();
            }
        } );
        //产品研发
        researchproduct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchproduce( researchproduct );

            }
        } );
        researchproduct1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchproduce( researchproduct1 );

            }
        } );
        //当季结束
        end.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.end,null );
                alertDialog1.setTitle( "当季结束" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                linearLayout.addView( view1);
                                longloan.setVisibility( View.GONE );

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();

            }
        } );
        //市场开拓
        exploit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.exploit,null );
                Button allselect=linearLayout1.findViewById( R.id.allselect );
                final CheckBox s1=linearLayout1.findViewById( R.id.s1 );
                final CheckBox s2=linearLayout1.findViewById( R.id.s2 );
                final CheckBox s3=linearLayout1.findViewById( R.id.s3 );
                final CheckBox s4=linearLayout1.findViewById( R.id.s4 );
                final CheckBox s5=linearLayout1.findViewById( R.id.s5 );
                allselect.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(s1.isChecked()&&s2.isChecked()&&s3.isChecked()&&s4.isChecked()&&s5.isChecked())
                        {
                            s1.setChecked( false );
                            s2.setChecked( false);
                            s3.setChecked( false );
                            s4.setChecked( false );
                            s5.setChecked( false );
                        }
                        else
                        {
                            s1.setChecked( true );
                            s2.setChecked( true );
                            s3.setChecked( true );
                            s4.setChecked( true );
                            s5.setChecked( true );
                        }

                    }
                } );
                alertDialog1.setTitle( "市场开拓" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                exploit.setVisibility( View.GONE );

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //ISO投资
        investment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.investment,null );
                Button allselect=linearLayout1.findViewById( R.id.allselect );
                final CheckBox s1=linearLayout1.findViewById( R.id.s1 );
                final CheckBox s2=linearLayout1.findViewById( R.id.s2 );
                allselect.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(s1.isChecked()&&s2.isChecked())
                        {
                            s1.setChecked( false );
                            s2.setChecked( false);
                        }
                        else
                        {
                            s1.setChecked( true );
                            s2.setChecked( true );

                        }

                    }
                } );
                alertDialog1.setTitle( "市场开拓" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                investment.setVisibility( View.GONE );

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );
        //第四季当季结束
        end1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.end,null );
                alertDialog1.setTitle( "当季结束" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                linearLayout.addView( view6);

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );

        //填写报表
        report.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.report_form,null );
                final Button composite=linearLayout1.findViewById( R.id.composite );
                final Button profit=linearLayout1.findViewById( R.id.profit );
                final Button liabilities=linearLayout1.findViewById( R.id.liabilities );
                final TableLayout table1=linearLayout1.findViewById( R.id.table1 );
                final TableLayout table2=linearLayout1.findViewById( R.id.table2 );
                final TableLayout table3=linearLayout1.findViewById( R.id.table3 );
                composite.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        profit.setTextColor( Color.parseColor( "#000000" ));
                        liabilities.setTextColor( Color.parseColor( "#000000" ));
                        composite.setTextColor( Color.parseColor( "#992424" ));
                        table1.setVisibility( View.VISIBLE );
                        table2.setVisibility( View.GONE );
                        table3.setVisibility( View.GONE );
                    }
                } );
                profit.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        profit.setTextColor( Color.parseColor( "#992424" ));
                        liabilities.setTextColor( Color.parseColor( "#000000" ));
                        composite.setTextColor( Color.parseColor( "#000000" ));
                        table1.setVisibility( View.GONE );
                        table2.setVisibility( View.VISIBLE );
                        table3.setVisibility( View.GONE );
                    }
                } );
                liabilities.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        profit.setTextColor( Color.parseColor( "#000000" ));
                        liabilities.setTextColor( Color.parseColor( "#992424" ));
                        composite.setTextColor( Color.parseColor( "#000000" ));
                        table1.setVisibility( View.GONE );
                        table2.setVisibility( View.GONE );
                        table3.setVisibility( View.VISIBLE );
                    }
                } );
                alertDialog1.setTitle( "填写报表" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                report.setVisibility( View.GONE );

                            }
                        } )
                        .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        } )
                        .create();
                alertDialog1.show();
            }
        } );

        //投放广告
        advertising.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(report.getVisibility()==View.GONE) {
                    LinearLayout linearLayout1 = (LinearLayout) getLayoutInflater().inflate( R.layout.advertising, null );
                    alertDialog1.setTitle( "投放广告" )
                            .setView( linearLayout1 )
                            .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Toast.makeText( MainActivity.this, "已进行该操作", Toast.LENGTH_SHORT ).show();

                                }
                            } )
                            .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            } )
                            .create();
                    alertDialog1.show();
                }
                else
                {
                    Toast.makeText( MainActivity.this,"请先填写报表",Toast.LENGTH_SHORT).show();
                }
            }
        } );


        discount.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                discount(token);
            }
        } );

        purchase.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchase(token);
            }
        } );

        soldinventory.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soldinventory(token);
            }
        } );

        factorydiscount.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factorydiscount(token);
            }
        } );

        ordermessage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordermessage();
            }
        } );

        spy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spy();
            }
        } );

    }

    //贴现(success)
    private  void discount(final String token)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(false);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.discount,null);
        final int[][] l = new int[1][4];
        final TextView discount1=linearLayout1.findViewById( R.id.discount1 );
        final TextView discount2=linearLayout1.findViewById( R.id.discount2 );
        final TextView discount3=linearLayout1.findViewById( R.id.discount3 );
        final TextView discount4=linearLayout1.findViewById( R.id.discount4 );
        final TextView []discount={discount1,discount2,discount3,discount4};
        final EditText d1=linearLayout1.findViewById( R.id.d1 );
        final EditText d2=linearLayout1.findViewById( R.id.d2 );
        final EditText d3=linearLayout1.findViewById( R.id.d3 );
        final EditText d4=linearLayout1.findViewById( R.id.d4 );
        final EditText []d={d1,d2,d3,d4};
        HttpUtil.discountList(token,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        discountListBean discountList = JSON.parseObject( responseData, discountListBean.class );
                        int []list=discountList.getData();
                        l[0] =list;
                        for(int i = 0; i< list.length; i++)
                        {
                            discount[i].setText( Integer.toString( list[i] )+"W" );
                        }
                    }
                } );
            }
        });
        alertDialog.setTitle( "贴现" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int s=0;
                        for(int i=0;i<4;i++)
                        {
                            if(Integer.parseInt(String.valueOf(d[i].getText()))>l[0][i])
                            {
                                Toast.makeText( MainActivity.this,"贴息金额超过应收款金额",Toast.LENGTH_SHORT ).show();
                                break;
                            }
                            else
                            {
                                s=s+1;
                            }
                        }
                        if(s==4)
                        {
                            HttpUtil.discountSubmit(token,String.valueOf(d1.getText()),String.valueOf(d2.getText()),String.valueOf(d3.getText()),String.valueOf(d4.getText()),new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    final String responseData = response.body().string();
                                    runOnUiThread( new Runnable() {
                                        @Override
                                        public void run() {
                                            setInfo( token );
                                        }
                                    } );
                                }
                            });
                            dialog.dismiss();
                        }
                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    //紧急采购(success)
    private void purchase(final String token)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(false);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.purchase,null);
        final TextView r1=linearLayout1.findViewById( R.id.r1 );
        final TextView r2=linearLayout1.findViewById( R.id.r2 );
        final TextView r3=linearLayout1.findViewById( R.id.r3 );
        final TextView r4=linearLayout1.findViewById( R.id.r4 );
        final TextView p1=linearLayout1.findViewById( R.id.p1 );
        final TextView p2=linearLayout1.findViewById( R.id.p2 );
        final TextView p3=linearLayout1.findViewById( R.id.p3 );
        final TextView p4=linearLayout1.findViewById( R.id.p4 );
        final TextView p5=linearLayout1.findViewById( R.id.p5 );
        final EditText r1_num=linearLayout1.findViewById( R.id.r1_number );
        final EditText r2_num=linearLayout1.findViewById( R.id.r2_number );
        final EditText r3_num=linearLayout1.findViewById( R.id.r3_number );
        final EditText r4_num=linearLayout1.findViewById( R.id.r4_number );
        final EditText p1_num=linearLayout1.findViewById( R.id.p1_number );
        final EditText p2_num=linearLayout1.findViewById( R.id.p2_number );
        final EditText p3_num=linearLayout1.findViewById( R.id.p3_number );
        final EditText p4_num=linearLayout1.findViewById( R.id.p4_number );
        final EditText p5_num=linearLayout1.findViewById( R.id.p5_number );
        final TextView []r={r1,r2,r3,r4};
        final TextView []p={p1,p2,p3,p4,p5};
        final EditText []material={r1_num,r2_num,r3_num,r4_num};
        final EditText []product={p1_num,p2_num,p3_num,p4_num,p5_num};

        HttpUtil.purchasetList(token,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        purchaseListBean purchaseList=JSON.parseObject( responseData,purchaseListBean.class );
                        dataBean data=purchaseList.getData();
                        List<productBean> product=data.getProduct();
                        List<materialBean> material=data.getMaterial();
                        for(int i=0;i<material.size();i++)
                        {
                            r[i].setText( String.valueOf( material.get(i).getInventoryNum() ) );
                        }
                        for(int i=0;i<product.size();i++)
                        {
                            p[i].setText( String.valueOf( product.get(i).getInventoryNum() ) );
                        }

                    }
                } );
            }
        });
        alertDialog.setTitle( "紧急采购" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String material_ids="";
                        String material_nums="";
                        String product_ids="";
                        String product_nums="";
                        int j=0;
                        int x=0;
                        for(int i=0;i<material.length;i++)
                        {
                           if(Integer.parseInt( String.valueOf( material[i].getText() ) )!=0)
                           {
                               j=j+1;
                               if(j==1)
                               {
                                   material_ids=Integer.toString( i+1 );
                                   material_nums=String.valueOf( material[i].getText());
                               }
                               else
                               {
                                   material_ids=material_ids+","+Integer.toString( i+1 );
                                   material_nums=material_nums+","+String.valueOf( material[i].getText());
                               }
                           }
                       }
                        for(int i=0;i<product.length;i++)
                        {
                            if(Integer.parseInt( String.valueOf( product[i].getText() ) )!=0)
                            {
                                x=x+1;
                                if(x==1)
                                {
                                    product_ids=Integer.toString( i+1 );
                                    product_nums=String.valueOf( product[i].getText());
                                }
                                else
                                {
                                    product_ids=product_ids+","+Integer.toString( i+1 );
                                    product_nums=product_nums+","+String.valueOf( product[i].getText());
                                }
                            }
                        }
                        if(!material_ids.equals( "" ))
                        {
                            HttpUtil.buyMaterial(token,material_ids,material_nums,new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    final String responseData = response.body().string();
                                    runOnUiThread( new Runnable() {
                                        @Override
                                        public void run() {
                                        }
                                    } );
                                }
                            });
                        }
                        if(!product_ids.equals( "" ))
                        {
                            HttpUtil.buyProduct(token,product_ids,product_nums,new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    final String responseData = response.body().string();
                                    runOnUiThread( new Runnable() {
                                        @Override
                                        public void run() {
                                        }
                                    } );
                                }
                            });
                        }
                        dialog.dismiss();
                        setInfo( token );
                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    //出售库存(success)
    private void soldinventory(final String token)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.soldinventory,null);
        alertDialog.setCancelable(false);
        final int []list1 = new int[4];
        final int []list2=new int[5];
        final TextView r1=linearLayout1.findViewById( R.id.r1 );
        final TextView r2=linearLayout1.findViewById( R.id.r2 );
        final TextView r3=linearLayout1.findViewById( R.id.r3 );
        final TextView r4=linearLayout1.findViewById( R.id.r4 );
        final TextView p1=linearLayout1.findViewById( R.id.p1 );
        final TextView p2=linearLayout1.findViewById( R.id.p2 );
        final TextView p3=linearLayout1.findViewById( R.id.p3 );
        final TextView p4=linearLayout1.findViewById( R.id.p4 );
        final TextView p5=linearLayout1.findViewById( R.id.p5 );
        final EditText r1_num=linearLayout1.findViewById( R.id.r1_number );
        final EditText r2_num=linearLayout1.findViewById( R.id.r2_number );
        final EditText r3_num=linearLayout1.findViewById( R.id.r3_number );
        final EditText r4_num=linearLayout1.findViewById( R.id.r4_number );
        final EditText p1_num=linearLayout1.findViewById( R.id.p1_number );
        final EditText p2_num=linearLayout1.findViewById( R.id.p2_number );
        final EditText p3_num=linearLayout1.findViewById( R.id.p3_number );
        final EditText p4_num=linearLayout1.findViewById( R.id.p4_number );
        final EditText p5_num=linearLayout1.findViewById( R.id.p5_number );
        final TextView []r={r1,r2,r3,r4};
        final TextView []p={p1,p2,p3,p4,p5};
        final EditText []material={r1_num,r2_num,r3_num,r4_num};
        final EditText []product={p1_num,p2_num,p3_num,p4_num,p5_num};
        HttpUtil.sellList(token,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        purchaseListBean purchaseList=JSON.parseObject( responseData,purchaseListBean.class );
                        dataBean data=purchaseList.getData();
                        List<productBean> product=data.getProduct();
                        List<materialBean> material=data.getMaterial();
                        for(int i=0;i<material.size();i++)
                        {
                            r[i].setText( String.valueOf( material.get(i).getInventoryNum() ) );
                            list1[i]=material.get(i).getInventoryNum();
                        }
                        for(int i=0;i<product.size();i++)
                        {
                            p[i].setText( String.valueOf( product.get(i).getInventoryNum() ) );
                            list2[i]=product.get(i).getInventoryNum();
                        }

                    }
                } );
            }
        });
        alertDialog.setTitle( "出售库存" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String material_ids="";
                        String material_nums="";
                        String product_ids="";
                        String product_nums="";
                        int j=0;
                        int x=0;
                        int a=0;
                        int b=0;
                        for (int i=0;i<4;i++)
                        {
                            if(Integer.parseInt( String.valueOf( material[i].getText() ) )>list1[i])
                            {
                                Toast.makeText( MainActivity.this,"出售数量超出现有库存",Toast.LENGTH_SHORT ).show();
                                break;
                            }
                            else
                            {
                                a=a+1;
                            }
                        }
                        for (int i=0;i<5;i++)
                        {
                            if(Integer.parseInt( String.valueOf( product[i].getText() ) )>list2[i])
                            {
                                Toast.makeText( MainActivity.this,"出售数量超出现有库存",Toast.LENGTH_SHORT ).show();
                                break;
                            }
                            else
                            {
                                b=b+1;
                            }
                        }
                        for(int i=0;i<material.length;i++)
                        {
                            if(Integer.parseInt( String.valueOf( material[i].getText() ) )!=0&&a==4)
                            {
                                j=j+1;
                                if(j==1)
                                {
                                    material_ids=Integer.toString( i+1 );
                                    material_nums=String.valueOf( material[i].getText());
                                }
                                else
                                {
                                    material_ids=material_ids+","+Integer.toString( i+1 );
                                    material_nums=material_nums+","+String.valueOf( material[i].getText());
                                }
                            }
                        }
                        for(int i=0;i<product.length;i++)
                        {
                            if(Integer.parseInt( String.valueOf( product[i].getText() ) )!=0&&b==5)
                            {
                                x=x+1;
                                if(x==1)
                                {
                                    product_ids=Integer.toString( i+1 );
                                    product_nums=String.valueOf( product[i].getText());
                                }
                                else
                                {
                                    product_ids=product_ids+","+Integer.toString( i+1 );
                                    product_nums=product_nums+","+String.valueOf( product[i].getText());
                                }
                            }
                        }
                        if(!material_ids.equals( "" ))
                        {
                            HttpUtil.sellMaterial(token,material_ids,material_nums,new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    final String responseData = response.body().string();
                                    runOnUiThread( new Runnable() {
                                        @Override
                                        public void run() {
                                        }
                                    } );
                                }
                            });
                        }
                        if(!product_ids.equals( "" ))
                        {
                            HttpUtil.sellProduct(token,product_ids,product_nums,new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    final String responseData = response.body().string();
                                    runOnUiThread( new Runnable() {
                                        @Override
                                        public void run() {
                                        }
                                    } );
                                }
                            });
                        }
                        dialog.dismiss();
                        setInfo( token );
                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    //厂房贴现(success)
    private void factorydiscount(final String token)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.factorydiscount,null);
        final TableRow r1=linearLayout1.findViewById( R.id.r1 );
        final TableRow r2=linearLayout1.findViewById( R.id.r2 );
        final TableRow r3=linearLayout1.findViewById( R.id.r3 );
        final TableRow r4=linearLayout1.findViewById( R.id.r4 );
        final TableRow[] row={r1,r2,r3,r4};
        final CheckBox c1=linearLayout1.findViewById( R.id.c1 );
        final CheckBox c2=linearLayout1.findViewById( R.id.c2 );
        final CheckBox c3=linearLayout1.findViewById( R.id.c3 );
        final CheckBox c4=linearLayout1.findViewById( R.id.c4 );
        final CheckBox[] c={c1,c2,c3,c4};
        final TextView name1=linearLayout1.findViewById( R.id.name1 );
        final TextView name2=linearLayout1.findViewById( R.id.name2 );
        final TextView name3=linearLayout1.findViewById( R.id.name3 );
        final TextView name4=linearLayout1.findViewById( R.id.name4 );
        final TextView []name={name1,name2,name3,name4};
        final TextView capacity1=linearLayout1.findViewById( R.id.capacity1 );
        final TextView capacity2=linearLayout1.findViewById( R.id.capacity2 );
        final TextView capacity3=linearLayout1.findViewById( R.id.capacity3 );
        final TextView capacity4=linearLayout1.findViewById( R.id.capacity4 );
        final TextView[] capacity={capacity1,capacity2,capacity3,capacity4};
        final TextView residual1=linearLayout1.findViewById( R.id.residual1 );
        final TextView residual2=linearLayout1.findViewById( R.id.residual2 );
        final TextView residual3=linearLayout1.findViewById( R.id.residual3 );
        final TextView residual4=linearLayout1.findViewById( R.id.residual4 );
        final TextView[] residual={residual1,residual2,residual3,residual4};
        final int[] x=new int[4];
        HttpUtil.dispostList(token,"0",new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        disposeListBean disposeList=JSON.parseObject( responseData,disposeListBean.class );
                        List<com.example.erp1.dispose.dataBean> workshopList=disposeList.getData();
                        for(int i=0;i<workshopList.size();i++)
                        {
                            x[i]=workshopList.get( i ).getId();
                            row[i].setVisibility( View.VISIBLE );
                            name[i].setText( workshopList.get( i ).getConfigWorkshop().getName()+"("+String.valueOf( workshopList.get( i ).getId())+")" );
                            capacity[i].setText( String.valueOf( workshopList.get( i ).getConfigWorkshop().getCapacity() ) );
                            residual[i].setText( String.valueOf( workshopList.get( i ).getResidualCapacity() ) );

                        }
                    }
                } );
            }
        });
        alertDialog.setTitle( "厂房贴现" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int b=0;
                        for(int i=0;i<4;i++)
                        {
                            if(c[i].isChecked())
                            {
                                HttpUtil.discountworkshop(token,String.valueOf(x[i] ),new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread( new Runnable() {
                                            @Override
                                            public void run() {
                                            }
                                        } );
                                    }
                                });
                                break;
                            }
                        }

                        dialog.dismiss();
                        setInfo( token );

                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    private void ordermessage()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.ordermessage,null);
        alertDialog.setTitle( "订单信息" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    private void spy()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.spy,null);
        alertDialog.setTitle( "间谍" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    private void delivery()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.delivery,null);
        alertDialog.setTitle( "按订单交货" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    private void managefactory()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.managefactory,null);
        alertDialog.setTitle( "厂房处理" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    private void researchproduce(final Button res)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.researchproduct,null);
                Button allselect=linearLayout1.findViewById( R.id.allselect );
                final CheckBox s1=linearLayout1.findViewById( R.id.s1 );
                final CheckBox s2=linearLayout1.findViewById( R.id.s2 );
                final CheckBox s3=linearLayout1.findViewById( R.id.s3 );
                final CheckBox s4=linearLayout1.findViewById( R.id.s4 );
                final CheckBox s5=linearLayout1.findViewById( R.id.s5 );
                allselect.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(s1.isChecked()&&s2.isChecked()&&s3.isChecked()&&s4.isChecked()&&s5.isChecked())
                        {
                            s1.setChecked( false );
                            s2.setChecked( false);
                            s3.setChecked( false );
                            s4.setChecked( false );
                            s5.setChecked( false );
                        }
                        else
                        {
                            s1.setChecked( true );
                            s2.setChecked( true );
                            s3.setChecked( true );
                            s4.setChecked( true );
                            s5.setChecked( true );
                        }

                    }
                } );
        alertDialog.setTitle( "产品研发" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        res.setVisibility( View.GONE );
                        dialog.dismiss();

                    }
                } )
                .setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } )
                .create();
        alertDialog.show();
    }
    private void createline()
    {
       adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
    }

    private void setInfo(String token)
    {

        String url = "http://110.88.128.202:8088/stu/user/info";
        final informationBean[] info = {new informationBean()};
        HttpUtil.decide(token,url, new Callback() {
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
                        TextView time=findViewById( R.id.time );
//                        SpannableString spannableString1 =new SpannableString( info.getData().getCompany().getPeriodString());
//                        spannableString1.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                        time.setText(info.getData().getCompany().getPeriodString());
                        TextView status=findViewById( R.id.status );
//                        SpannableString spannableString2 =new SpannableString( info.getData().getCompany().getStatusString());
//                        spannableString2.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                        status.setText(info.getData().getCompany().getStatusString());
                        //财务信息
                        TextView cash=findViewById( R.id.cash );
                        cash.setText( Integer.toString(info.getData().getCompany().getCash()));
                        TextView receivable=findViewById( R.id.receivable );
                        List<receivableBean> receivableBeanList=info.getData().getReceivable();
                        if(receivableBeanList.size()==0)
                        {
                            receivable.setText( "0" );
                        }
                        else
                        {
                            receivable.setText( Integer.toString(receivableBeanList.get( 0 ).getReceivableValue() ));
                        }
                        TextView longloan=findViewById( R.id.longloan );
                        TextView shortloan=findViewById( R.id.shortloan );
                        TextView specialloan=findViewById( R.id.specialloan );

                        TextView shareholder=findViewById( R.id.shareholder );
                        List<loanBean> loanBeanList=info.getData().getLoan();
                        shareholder.setText( Integer.toString( info.getData().getCompany().getCapital() ) );
                        if(loanBeanList.size()==0)
                        {
                            longloan.setText( "0" );
                            shortloan.setText( "0" );
                            specialloan.setText( "0" );
                        }
                        else
                        {
                            int lloan=0;
                            int sloan=0;
                            int sploan=0;
                            for(int i=0;i<loanBeanList.size();i++)
                            {
                                if(loanBeanList.get( i ).getLoanType()==1)
                                {
                                    sloan=loanBeanList.get( i ).getLoanValue()+sloan;
                                }
                                if(loanBeanList.get( i ).getLoanType()==2)
                                {
                                    lloan=loanBeanList.get( i ).getLoanValue()+lloan;
                                }
                                if(loanBeanList.get( i ).getLoanType()==3)
                                {
                                    sploan=loanBeanList.get( i ).getLoanValue()+sploan;
                                }
                            }
                            longloan.setText( Integer.toString( lloan ) );
                            shortloan.setText( Integer.toString( sloan ) );
                            specialloan.setText( Integer.toString( sploan ) );
                        }
                        TextView discountCost=findViewById( R.id.discountCost );
                        discountCost.setText( Integer.toString( info.getData().getFinancial().getDiscountCost() ) );
                        TextView interest=findViewById( R.id.interest );
                        interest.setText( Integer.toString( info.getData().getFinancial().getInterest() ) );
                        TextView salesAmount=findViewById( R.id.salesAmount );
                        salesAmount.setText( Integer.toString( info.getData().getFinancial().getSalesAmount() ) );
                        TextView maintenanceCost=findViewById( R.id.maintenanceCost );
                        maintenanceCost.setText( Integer.toString( info.getData().getFinancial().getMaintenanceCost() ) );
                        TextView turnOverCost=findViewById( R.id.turnOverCost );
                        turnOverCost.setText( Integer.toString( info.getData().getFinancial().getTurnOverCost() ) );
                        TextView rentCost=findViewById( R.id.rentCost );
                        rentCost.setText( Integer.toString( info.getData().getFinancial().getRentCost() ) );
                        TextView adminstrativeCost=findViewById( R.id.adminstrativeCost );
                        adminstrativeCost.setText( Integer.toString( info.getData().getFinancial().getAdminstrativeCost() ) );
                        TextView adCost=findViewById( R.id.adCost );
                        adCost.setText( Integer.toString( info.getData().getFinancial().getAdCost() ) );
                        TextView informationCost=findViewById( R.id.informationCost );
                        informationCost.setText(Integer.toString( info.getData().getFinancial().getInformationCost() ) );
                        TextView finacialLoss=findViewById( R.id.finacialLoss );
                        finacialLoss.setText( Integer.toString( info.getData().getFinancial().getFinacialLoss()) );
                        TextView directCost=findViewById( R.id.directCost );
                        directCost.setText( Integer.toString( info.getData().getFinancial().getDirectCost() ) );
                        TextView developingIsoCost=findViewById( R.id.developingIsoCost );
                        developingIsoCost.setText( Integer.toString( info.getData().getFinancial().getDevelopingIsoCost() ) );
                        TextView developingProductCost=findViewById( R.id.developingProductCost );
                        developingProductCost.setText( Integer.toString( info.getData().getFinancial().getDevelopingProductCost() ) );
                        TextView developingMarketCost=findViewById( R.id.developingMarketCost );
                        developingMarketCost.setText( Integer.toString( info.getData().getFinancial().getDevelopingMarketCost() ) );

                        //研发认证信息
                        TextView market=findViewById( R.id.market );
                        TextView local=findViewById( R.id.local );
                        TextView region=findViewById( R.id.region );
                        TextView domestic=findViewById( R.id.domestic );
                        TextView asia=findViewById( R.id.asia );
                        TextView international=findViewById( R.id.international );
                        TextView []markets={local,region,domestic,asia,international};
                        List<developMarketBean> developMarketBeanList=info.getData().getDevelopMarket();

                        int j=0;
                        String s="";
                        for(int i=0;i<5;i++)
                        {
                            markets[i].setText( "未开拓" );
                        }
                        for(int i=0;i<developMarketBeanList.size();i++)
                        {
                            int x=0;
                            if(developMarketBeanList.get( i ).getDevelopingRemainder()==0)
                            {
                                s=s+developMarketBeanList.get( i ).getConfigMarket().getName()+" ";
//                                SpannableString spannableString =new SpannableString(s);
//                                spannableString.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                                if(developMarketBeanList.get( i).getConfigMarket().getName()=="本地")
                                {
                                    x=0;
                                }
                                if(developMarketBeanList.get( i).getConfigMarket().getName()=="区域")
                                {
                                    x=1;
                                }
                                if(developMarketBeanList.get( i).getConfigMarket().getName()=="国内")
                                {
                                    x=2;
                                }
                                if(developMarketBeanList.get( i).getConfigMarket().getName()=="亚洲")
                                {
                                    x=3;
                                }
                                if(developMarketBeanList.get( i).getConfigMarket().getName()=="国际")
                                {
                                    x=4;
                                }
                                markets[x].setText( "已开拓" );
                            }
                            else
                            {
                                j=j+1;
                                String m="剩余"+developMarketBeanList.get( i ).getDevelopingRemainder()+"年";
                                markets[x].setText( m );
                            }

                        }
                        market.setText(s);
                        if(j==developMarketBeanList.size()||developMarketBeanList.size()==0)
                        {
                            market.setText( "暂无" );
                            market.setTextColor( Color.parseColor( "#000000" ));
                        }

                        TextView iso=findViewById( R.id.iso );
                        TextView iso1=findViewById( R.id.iso1 );
                        TextView iso2=findViewById( R.id.iso2 );
                        TextView []isos={iso1,iso2};
                        int []isonum={0,0};
                        List<developIsoBean> developIsoBeanList=info.getData().getDevelopIso();
                        int z=0;
                        String isomessage="";
                        for(int i=0;i<developIsoBeanList.size();i++)
                        {
                            int x=0;
                            if(developIsoBeanList.get( i ).getDevelopingRemainder()==0)
                            {
                                isomessage=isomessage+developIsoBeanList.get( i ).getConfigIso().getName()+" ";
                                if(developIsoBeanList.get( i ).getConfigIso().getName().equals( "ISO9000" ))
                                {
                                    x=0;
                                }
                                if(developIsoBeanList.get( i ).getConfigIso().getName().equals( "ISO14000" ))
                                {
                                    x=1;
                                }
                                isos[x].setText( "已认证" );
                                isonum[x]=1;

                            }
                            else
                            {
                                String m="剩余"+developIsoBeanList.get( i ).getDevelopingRemainder()+"年";
                                isos[x].setText( m);
                                isonum[x]=1;
                                z=z+1;
                            }
                        }
                        iso.setText( isomessage );
                        if (z==developIsoBeanList.size()||developIsoBeanList.size()==0)
                        {
                            iso.setText( "暂无" );
                            iso.setTextColor( Color.parseColor( "#000000" ));
                        }

                        TextView product=findViewById( R.id.product );
                        TextView product1=findViewById( R.id.product1 );
                        TextView product2=findViewById( R.id.product2 );
                        TextView product3=findViewById( R.id.product3 );
                        TextView product4=findViewById( R.id.product4 );
                        TextView product5=findViewById( R.id.product5 );
                        TextView []products={product1,product2,product3,product4,product5};
                        List<developProductBean> developProductBeanList=info.getData().getDevelopProduct();
                        String p="";
                        int y=0;
                        for(int i=0;i<5;i++)
                        {
                            products[i].setText( "未研发" );
                        }
                        for(int i=0;i<developProductBeanList.size();i++)
                        {
                            int x=0;
                            if(developProductBeanList.get( i ).getDevelopingRemainder()==0)
                            {
                                if(developProductBeanList.get( i ).getConfigProduct().getName().equals( "P1" ))
                                {
                                    x=0;
                                }
                                if(developProductBeanList.get( i ).getConfigProduct().getName().equals( "P2" ))
                                {
                                    x=1;
                                }
                                if(developProductBeanList.get( i ).getConfigProduct().getName().equals( "P3" ))
                                {
                                    x=2;
                                }
                                if(developProductBeanList.get( i ).getConfigProduct().getName().equals( "P4" ))
                                {
                                    x=3;
                                }
                                if(developProductBeanList.get( i ).getConfigProduct().getName().equals( "P5" ))
                                {
                                    x=4;
                                }
                                p=p+developProductBeanList.get( i ).getConfigProduct().getName()+" ";
                                products[x].setText( "已研发" );
                            }
                            else
                            {
                                String m="剩余"+developProductBeanList.get( i ).getDevelopingRemainder()+"季";
                                products[x].setText( m );
                                y=y+1;
                            }
                        }
                        product.setText( p );

                        if(developProductBeanList.size()==0||y==developProductBeanList.size())
                        {
                            product.setText( "暂无" );
                            product.setTextColor( Color.parseColor( "#000000" ));
                        }

                        TextView p1=findViewById( R.id.p1 );
                        TextView p2=findViewById( R.id.p2 );
                        TextView p3=findViewById( R.id.p3 );
                        TextView p4=findViewById( R.id.p4 );
                        TextView p5=findViewById( R.id.p5 );
                        TextView r1=findViewById( R.id.r1 );
                        TextView r2=findViewById( R.id.r2 );
                        TextView r3=findViewById( R.id.r3 );
                        TextView r4=findViewById( R.id.r4 );
                        List<productBean> productBeanList=info.getData().getProduct();
                        List<materialBean> materialBeanList=info.getData().getMaterial();
                        TextView []ps={p1,p2,p3,p4,p5};
                        TextView []rs={r1,r2,r3,r4};
                        for(int i=0;i<5;i++)
                        {
                            ps[i].setText( "0" );
                        }
                        for (int i=0;i<4;i++)
                        {
                            rs[i].setText( "0" );
                        }
                        for(int i=0;i<productBeanList.size();i++)
                        {
                            if(productBeanList.get( i ).getConfigProduct().getName().equals( "P1" ))
                            {
                                p1.setText(Integer.toString(  productBeanList.get( i ).getInventoryNum()) );
                            }
                            if(productBeanList.get( i ).getConfigProduct().getName().equals( "P2" ))
                            {
                                p2.setText(Integer.toString(  productBeanList.get( i ).getInventoryNum()) );
                            }
                            if(productBeanList.get( i ).getConfigProduct().getName().equals( "P3" ))
                            {
                                p3.setText( Integer.toString(  productBeanList.get( i ).getInventoryNum()) );
                            }
                            if(productBeanList.get( i ).getConfigProduct().getName().equals( "P4" ))
                            {
                                p4.setText(Integer.toString(  productBeanList.get( i ).getInventoryNum()) );
                            }
                            if(productBeanList.get( i ).getConfigProduct().getName().equals( "P5" ))
                            {
                                p5.setText( Integer.toString(  productBeanList.get( i ).getInventoryNum()) );
                            }
                        }
                        for(int i=0;i<materialBeanList.size();i++)
                        {
                            rs[materialBeanList.get( i ).getMaterialId()-1].setText(Integer.toString(  materialBeanList.get( i ).getInventoryNum() ) );
                        }
                        TextView transport1=findViewById( R.id.transport1 );
                        TextView transport2=findViewById( R.id.transport2 );
                        transport1.setText( "暂无运单信息" );
                        transport2.setText( "暂无运单信息" );
                        List<transportBean> transportBeanList=info.getData().getTransport();
                        String rnum="";
                        for (int i=0;i<transportBeanList.size();i++)
                        {
                            rnum="R"+transportBeanList.get( i ).getProductId()+"("+transportBeanList.get( i ).getNum()+")";
                            if(transportBeanList.get( i ).getRemainder()==1)
                            {
                                transport1.setText(rnum);
                            }
                            if(transportBeanList.get( i ).getRemainder()==2)
                            {
                                transport2.setText( rnum);
                            }
                        }

                        final TextView place1=(TextView)findViewById( R.id.place1 ) ;
                        final TextView place2=(TextView)findViewById( R.id.place2 ) ;
                        final TextView place3=(TextView)findViewById( R.id.place3 ) ;
                        final TextView place4=(TextView)findViewById( R.id.place4 ) ;
                        //final LinearLayout space1=(LinearLayout)findViewById( R.id.space1 );
                        final TextView space11=(TextView)findViewById( R.id.space11 );
                        final TextView space12=(TextView)findViewById( R.id.space12 );
                        final TextView space13=(TextView)findViewById( R.id.space13 );
                        final TextView space14=(TextView)findViewById( R.id.space14 );
                        final TextView space21=(TextView)findViewById( R.id.space21 );
                        final TextView space22=(TextView)findViewById( R.id.space22 );
                        final TextView space23=(TextView)findViewById( R.id.space23 );
                        final TextView space24=(TextView)findViewById( R.id.space24 );
                        final TextView space31=(TextView)findViewById( R.id.space31 );
                        final TextView space32=(TextView)findViewById( R.id.space32 );
                        final TextView space33=(TextView)findViewById( R.id.space33 );
                        final TextView space34=(TextView)findViewById( R.id.space34 );
                        final TextView space41=(TextView)findViewById( R.id.space41 );
                        final TextView space42=(TextView)findViewById( R.id.space42 );
                        final TextView space43=(TextView)findViewById( R.id.space43 );
                        final TextView space44=(TextView)findViewById( R.id.space44 );
                        final TextView[] place={place1,place2,place3,place4};
                        final TextView[] space1={space11,space12,space13,space14};
                        final TextView[] space2={space21,space22,space23,space24};
                        final TextView[] space3={space31,space32,space33,space34};
                        final TextView[] space4={space41,space42,space43,space44};
                        List<workshopBean> workshopBeanList=info.getData().getWorkshop();
                        List<productLineBean> productLineBeanList=info.getData().getProductLine();
                        for(int i=0;i<4;i++)
                        {
                            place[i].setText( "空地" );
                            space1[i].setVisibility( View.INVISIBLE );
                            space2[i].setVisibility( View.INVISIBLE );
                            space3[i].setVisibility( View.INVISIBLE );
                            space4[i].setVisibility( View.INVISIBLE );
                        }
                        for(int i=0;i<workshopBeanList.size();i++)
                        {
                            String wsname=workshopBeanList.get( i ).getConfigWorkshop().getName()+"("+workshopBeanList.get( i ).getId()+")"+workshopBeanList.get( i ).getWorkshopStatusDesc();
                            place[i].setText( wsname );
                        }
                        int n1=0;
                        int n2=0;
                        int n3=0;
                        int n4=0;
                        for(int i=0;i<productLineBeanList.size();i++)
                        {
                            for(int a=0;a<4;a++)
                            {
                                if(productLineBeanList.get( i ).getWorkshopId()==workshopBeanList.get(a).getId())
                                {
                                    if(a==0)
                                    {
                                        String linename=productLineBeanList.get(i).getConfigProductLine().getName()+"("+productLineBeanList.get(i).getId()+") P"+productLineBeanList.get(i).getProductId()+productLineBeanList.get(i).getStatusString();
                                        space1[n1].setText( linename );
                                        space1[n1].setVisibility( View.VISIBLE );
                                        n1=n1+1;
                                    }
                                    if(a==1)
                                    {
                                        String linename=productLineBeanList.get(i).getConfigProductLine().getName()+"("+productLineBeanList.get(i).getId()+") P"+productLineBeanList.get(i).getProductId()+productLineBeanList.get(i).getStatusString();
                                        space2[n2].setText( linename );
                                        space2[n2].setVisibility( View.VISIBLE );
                                        n2=n2+1;
                                    }
                                    if(a==2)
                                    {
                                        String linename=productLineBeanList.get(i).getConfigProductLine().getName()+"("+productLineBeanList.get(i).getId()+") P"+productLineBeanList.get(i).getProductId()+productLineBeanList.get(i).getStatusString();
                                        space3[n3].setText( linename );
                                        space3[n3].setVisibility( View.VISIBLE );
                                        n3=n3+1;
                                    }
                                    if(a==3)
                                    {
                                        String linename=productLineBeanList.get(i).getConfigProductLine().getName()+"("+productLineBeanList.get(i).getId()+") P"+productLineBeanList.get(i).getProductId()+productLineBeanList.get(i).getStatusString();
                                        space4[n4].setText( linename );
                                        space4[n4].setVisibility( View.VISIBLE );
                                        n4=n4+1;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                });

            }
        });
    }

    private void getotherCompany()
    {
        HttpUtil.tlogin(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        loginBean teacher = JSON.parseObject( responseData, loginBean.class );
                        String token=teacher.getData().getToken();

                    }
                } );
            }
        });
    }
}