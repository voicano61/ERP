package com.example.erp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private MyDatebaseHelper dbHelper;
    private int i=1;
    private  int j=1;
    private ArrayAdapter<String> adapter;
    private DrawerLayout mDrawerLayout;
    private  List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        final Intent intent = getIntent();
        final String name = intent.getStringExtra( "name" );
        Button help = (Button) findViewById( R.id.help );
        Button notice=(Button)findViewById( R.id.notice );
        Button signout=(Button)findViewById( R.id.signout );
        Button finance=(Button)findViewById( R.id.finance );
        Button research=(Button)findViewById( R.id.research );
        Button inventory=(Button)findViewById( R.id.inventory);
        final LinearLayout finance_message=(LinearLayout)findViewById( R.id.finance_message );
        dbHelper = new MyDatebaseHelper( this, "ERP.db", null, 2 );

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

        final TextView textView = (TextView) findViewById( R.id.name );
        SpannableString spannableString = new SpannableString( name );
        spannableString.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.append( spannableString );
        TextView time = (TextView) findViewById( R.id.time );
        final String[][] s = {{"第" + j + "年第" + i + "季"}};
        SpannableString spannableString1 =new SpannableString( s[0][0] );
        spannableString1.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        time.append( spannableString1 );


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
//                Intent intent=new Intent( MainActivity.this,LongloanActivity.class);
//                startActivity( intent );
//                LongLoanDialog myDialog=new LongLoanDialog(MainActivity.this,R.style.Dialog_Msg);

//                myDialog.setMyOnclickListener("这是外部实现的点击事件", new
//                        LongLoanDialog.MyOnclickListener() {
//                            @Override
//                            public void onYesClick(String message) {
//                                System.out.println("测试:"+message);
//                            }
//                        });
//                myDialog.show();

//
                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.longloan, null);
                final Spinner spinner=(Spinner)linearLayout1.findViewById( R.id.spinner );
                final EditText number=linearLayout1.findViewById( R.id.number );
                //final int  num=Integer.parseInt( number.getText().toString() );
                final String num=number.getText().toString();
                //长贷时间
                spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String[] languages = getResources().getStringArray(R.array.times);
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
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
                                    Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
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
//                Intent intent=new Intent( MainActivity.this, LonglActivity.class );
                //startActivity( intent);
                //Toast.makeText( MainActivity.this,"已进行该操作", Toast.LENGTH_SHORT ).show();
               // linearLayout.removeAllViews();
                //linearLayout.addView( view2);
                TextView time = (TextView) findViewById( R.id.time );
                time.setText( "" );
                String s="第"+j+"年第"+i+"季";
                SpannableString spannableString1 =new SpannableString(s);
                spannableString1.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                time.append( spannableString1 );

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
                Toast.makeText( MainActivity.this,"第"+j+"年第"+i+"季!",Toast.LENGTH_LONG ).show();
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
                                if(s[0].equals( "请选择厂房类型" ))
                                {
                                    Toast.makeText( MainActivity.this,"未选择厂房类型",Toast.LENGTH_SHORT ).show();
                                }
                                else
                                {
                                    if(place4.getText().toString().equals( "空地" ))
                                    {
                                        if (radioButton1.isChecked())
                                        {
                                            for (int i = 0; i < 4; i++)
                                            {
                                                if (place[i].getText().toString().equals( "空地" ))
                                                {
                                                    if (s[0].equals( "大厂房（购买:400W,容量:4,租用:40W）" ))
                                                    {
                                                        place[i].setText( "大厂房（购买）" );
                                                        break;
                                                    }
                                                    if (s[0].equals( "中厂房（购买:300W,容量:3,租用:30W）" ))
                                                    {
                                                        place[i].setText( "中厂房（购买）" );
                                                        break;
                                                    }
                                                    if (s[0].equals( "小厂房（购买:200W,容量:2,租用:20W）" ))
                                                    {
                                                        place[i].setText( "小厂房（购买）" );
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (radioButton2.isChecked())
                                        {
                                            //Toast.makeText( MainActivity.this,"2",Toast.LENGTH_SHORT ).show();
                                            for (int i = 0; i < 4; i++)
                                            {
                                                if (place[i].getText().toString().equals( "空地" ))
                                                {
                                                    if (s[0].equals( "大厂房（购买:400W,容量:4,租用:40W）" ))
                                                    {
                                                        place[i].setText( "大厂房（租）" );
                                                        break;
                                                    }
                                                    if (s[0].equals( "中厂房（购买:3000W,容量:3,租用:30W）" )) {
                                                        place[i].setText( "中厂房（租）" );
                                                        break;
                                                    }
                                                    if (s[0].equals( "小厂房（购买:200W,容量:2,租用:20W）" )) {
                                                        place[i].setText( "小厂房（租）" );
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                       if(!radioButton1.isChecked()&&!radioButton2.isChecked())
                                        {
                                            Toast.makeText( MainActivity.this,"未选择购买或是租赁",Toast.LENGTH_SHORT ).show();
                                        }
                                    }
                                    else
                                    {
                                        Toast.makeText( MainActivity.this,"没有空地",Toast.LENGTH_SHORT ).show();
                                    }
                                }

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
                for(int i=0;i<4;i++)
                {
                    if(!place[i].getText().toString().equals( "空地" ))
                    {
                        list.add( place[i].getText().toString() );
                    }
                }
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
                                if(c[0].equals( "请选择厂房" ))
                                {
                                    Toast.makeText( MainActivity.this,"未选择厂房",Toast.LENGTH_SHORT ).show();
                                }
                                else
                                {
                                    if(s[0].equals( "请选择生产线类型" ))
                                    {
                                        Toast.makeText( MainActivity.this,"未选择生产线类型",Toast.LENGTH_SHORT ).show();
                                    }
                                    else
                                    {
                                        if(p1.isChecked())
                                        {
                                            if(s[0].equals( "超级手工线（30W）" ))
                                            {
                                                line[0] ="超级手工线("+p1.getText().toString()+")";
                                            }
                                            if(s[0].equals( "租赁线（0W）" ))
                                            {
                                                line[0] ="租赁线("+p1.getText().toString()+")";
                                            }
                                            if(s[0].equals( "自动线（150W）" ))
                                            {
                                                line[0] ="自动线("+p1.getText().toString()+")";
                                            }
                                            if(s[0].equals( "柔性线（200W）" ))
                                            {
                                                line[0] ="柔性线("+p1.getText().toString()+")";
                                            }
                                            //Toast.makeText( MainActivity.this,"p1"+s[0],Toast.LENGTH_SHORT ).show();
                                        }
                                        if(p2.isChecked())
                                        {
                                            if(s[0].equals( "超级手工线（30W）" ))
                                            {
                                                line[0] ="超级手工线(P2)";
                                            }
                                            if(s[0].equals( "租赁线（0W）" ))
                                            {
                                                line[0] ="租赁线(P2)";
                                            }
                                            if(s[0].equals( "自动线（150W）" ))
                                            {
                                                line[0] ="自动线(P2)";
                                            }
                                            if(s[0].equals( "柔性线（200W）" ))
                                            {
                                                line[0] ="柔性线(P2)";
                                            }
                                        }
                                        if(p3.isChecked())
                                        {
                                            if(s[0].equals( "超级手工线（30W）" ))
                                            {
                                                line[0] ="超级手工线(P3)";
                                            }
                                            if(s[0].equals( "租赁线（0W）" ))
                                            {
                                                line[0] ="租赁线(P3)";
                                            }
                                            if(s[0].equals( "自动线（150W）" ))
                                            {
                                                line[0] ="自动线(P3)";
                                            }
                                            if(s[0].equals( "柔性线（200W）" ))
                                            {
                                                line[0] ="柔性线(P3)";
                                            }
                                        }
                                        if(p4.isChecked())
                                        {
                                            if(s[0].equals( "超级手工线（30W）" ))
                                            {
                                                line[0] ="超级手工线(P4)";
                                            }
                                            if(s[0].equals( "租赁线（0W）" ))
                                            {
                                                line[0] ="租赁线(P4)";
                                            }
                                            if(s[0].equals( "自动线（150W）" ))
                                            {
                                                line[0] ="自动线(P4)";
                                            }
                                            if(s[0].equals( "柔性线（200W）" ))
                                            {
                                                line[0] ="柔性线(P4)";
                                            }
                                        }
                                        if(p5.isChecked())
                                        {
                                            if(s[0].equals( "超级手工线（30W）" ))
                                            {
                                                line[0] ="超级手工线(P5)";
                                            }
                                            if(s[0].equals( "租赁线（0W）" ))
                                            {
                                                line[0] ="租赁线(P5)";
                                            }
                                            if(s[0].equals( "自动线（150W）" ))
                                            {
                                                line[0] ="自动线(P5)";
                                            }
                                            if(s[0].equals( "柔性线（200W）" ))
                                            {
                                                line[0] ="柔性线(P5)";
                                            }
                                        }

                                        else {
                                            if(list.get( d[0] ).indexOf( "大" )!=-1)
                                            {
                                                for(int i=0;i<4;i++)
                                                {
                                                    if(d[0]==0)
                                                    {
                                                        if(space1[3].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space1[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space1[i].setText( line[0] );
                                                            space1[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }

                                                    }
                                                    if(d[0]==1)
                                                    {
                                                        if(space2[3].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space2[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space2[i].setText( line[0] );
                                                            space2[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==2)
                                                    {
                                                        if(space3[3].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space3[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space3[i].setText( line[0] );
                                                            space3[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==3)
                                                    {
                                                        if(space4[3].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space4[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space4[i].setText( line[0] );
                                                            space4[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            if(list.get( d[0] ).indexOf( "中" )!=-1)
                                            {
                                                for(int i=0;i<3;i++)
                                                {
                                                    if(d[0]==1)
                                                    {
                                                        if(space1[2].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space1[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space1[i].setText( line[0] );
                                                            space1[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==2)
                                                    {
                                                        if(space2[2].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space2[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space2[i].setText( line[0] );
                                                            space2[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==3)
                                                    {
                                                        if(space3[2].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space3[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space3[i].setText( line[0] );
                                                            space3[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==4)
                                                    {
                                                        if(space4[2].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space4[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space4[i].setText( line[0] );
                                                            space4[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            if(list.get( d[0] ).indexOf( "小" )!=-1)
                                            {
                                                for(int i=0;i<2;i++)
                                                {
                                                    if(d[0]==1)
                                                    {
                                                        if(space1[1].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space1[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space1[i].setText( line[0] );
                                                            space1[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==2)
                                                    {
                                                        if(space2[1].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space2[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space2[i].setText( line[0] );
                                                            space2[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==3)
                                                    {
                                                        if(space3[1].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space3[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space3[i].setText( line[0] );
                                                            space3[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                    if(d[0]==4)
                                                    {
                                                        if(space4[1].getVisibility()==View.VISIBLE)
                                                        {
                                                            Toast.makeText( MainActivity.this,"该工厂已建满",Toast.LENGTH_SHORT );
                                                        }
                                                        if(space4[i].getVisibility()==View.INVISIBLE)
                                                        {
                                                            space4[i].setText( line[0] );
                                                            space4[i].setVisibility( View.VISIBLE );
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
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
                i=i+1;
                alertDialog2.setTitle( "更新应收款账" )
                        .setMessage( "收现金额(1期)  " )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                //linearLayout2.setVisibility( View.VISIBLE );
                                if(i%4==0&&i!=0)
                                {
                                    linearLayout.addView( view5 );
                                }
                                else {
                                    linearLayout.addView( view4 );
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
                j=j+1;
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
                discount();
            }
        } );
//        discount2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                discount();
//            }
//        } );
//        discount3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                discount();
//            }
//        } );
        purchase.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchase();
            }
        } );
//        purchase2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                purchase();
//            }
//        } );
//        purchase3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                purchase();
//            }
//        } );
        soldinventory.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soldinventory();
            }
        } );
//        soldinventory2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                soldinventory();
//            }
//        } );
//        soldinventory3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                soldinventory();
//            }
//        } );
        factorydiscount.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factorydiscount();
            }
        } );
//        factorydiscount2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                factorydiscount();
//            }
//        } );
//        factorydiscount3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                factorydiscount();
//            }
//        } );
        ordermessage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordermessage();
            }
        } );
//        ordermessage2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ordermessage();
//
//            }
//        } );
//        ordermessage3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ordermessage();
//
//            }
//        } );
        spy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spy();
            }
        } );
//        spy2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                spy();
//            }
//        } );
//        spy3.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                spy();
//            }
//        } );
    }
    private  void discount()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.discount,null);
        alertDialog.setTitle( "贴现" )
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
    private void purchase()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.purchase,null);
        alertDialog.setTitle( "紧急采购" )
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
    private void soldinventory()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.soldinventory,null);
        alertDialog.setTitle( "出售库存" )
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
    private void factorydiscount()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.factorydiscount,null);
        alertDialog.setTitle( "厂房贴现" )
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
}
