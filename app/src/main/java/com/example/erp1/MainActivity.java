package com.example.erp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.example.erp1.changeline.changeLineBean;
import com.example.erp1.developMarket.developingMarketBean;
import com.example.erp1.developingISO.developingIsoBean;
import com.example.erp1.discount.discountListBean;
import com.example.erp1.dispose.disposeListBean;
import com.example.erp1.info.companyBean;
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
import com.example.erp1.tLogin.loginBean;

import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity{
    private MyDatebaseHelper dbHelper;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> adapter;
    private List<String> list;
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
        final View view7=getLayoutInflater().inflate( R.layout.order,null);
        final View normal=getLayoutInflater().inflate( R.layout.normal,null);
        final LinearLayout linearLayout=(LinearLayout)findViewById( R.id.page1 );
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



          //  linearLayout.addView( view1 );
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
        linearLayout.removeAllViews();
        String url="http://110.88.128.202:8088/stu/user/info";
        HttpUtil.info(token,url,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        informationBean info = JSON.parseObject( responseData, informationBean.class );
                        com.example.erp1.info.dataBean data = info.getData();
                        companyBean company = data.getCompany();
                        if (company.getMainStep() == 1)
                        {
                            if(company.getPeriod()==0)
                            {
                                linearLayout.addView( view1 );
                                if(company.getSubSteps().indexOf( "cd" )!=-1)
                                {
                                    longloan.setVisibility( View.GONE );
                                }
                            }
                            else if(company.getPeriod()%4==0&&company.getPeriod()!=0)
                            {
                                linearLayout.addView( view7 );
                            }
                            else
                            {
                                linearLayout.addView( view1 );
                                longloan.setVisibility( View.GONE );
                            }
                        }
                        if (company.getMainStep() == 2)
                        {
                            linearLayout.addView( view2 );
                            if(company.getSubSteps().indexOf( "dd" )!=-1)
                            {
                                shortloan.setVisibility( View.GONE );
                            }
                        }
                        if (company.getMainStep()==3)
                        {
                            linearLayout.addView( view3 );
                            String subSteps=company.getSubSteps();
                            if(subSteps.indexOf( "ddyl" )!=-1)
                            {
                                buy.setVisibility( View.GONE );
                            }
                            if (subSteps.indexOf( "zjscx" )!=-1)
                            {
                                construction.setVisibility( View.GONE );
                            }
                        }
                        if (company.getMainStep()==4)
                        {
                            if(company.getPeriod()%4!=3)
                            {
                                linearLayout.addView( view4 );
                                String subSteps=company.getSubSteps();
                                if(subSteps.indexOf( "cpyf" )!=-1)
                                {
                                    researchproduct.setVisibility( View.GONE );
                                }
                            }
                            else
                            {
                                linearLayout.addView(view5 );
                                String subSteps=company.getSubSteps();
                                if(subSteps.indexOf( "cpyf" )!=-1)
                                {
                                    researchproduct1.setVisibility( View.GONE );
                                }
                                if(subSteps.indexOf( "ktsc" )!=-1)
                                {
                                    exploit.setVisibility( View.GONE );
                                }
                                if(subSteps.indexOf( "isotz" )!=-1)
                                {
                                    investment.setVisibility( View.GONE );
                                }
                            }

                        }
                        if (company.getMainStep()==5)
                        {
                            linearLayout.addView( view6 );
                            String subSteps=company.getSubSteps();
                            if(subSteps.indexOf( "txbb" )!=-1)
                            {
                                report.setVisibility( View.GONE );
                            }
                        }
                    }
                } );
            }
        });

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


        //申请长贷(结果有出路）
        longloan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.longloan, null);
                final Spinner spinner=(Spinner)linearLayout1.findViewById( R.id.spinner );
                final EditText number=linearLayout1.findViewById( R.id.number );
                //final int  num=Integer.parseInt( number.getText().toString() );
                final String[] time=new String[1];
                //长贷时间
                spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String[] languages = getResources().getStringArray(R.array.times);
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        time[0] =String.valueOf( position +1);
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
                                final String num=number.getText().toString();
                                if(Integer.parseInt( num )>200) {
                                    Toast.makeText( MainActivity.this,"长贷金额不能超过最大额度",Toast.LENGTH_SHORT ).show();
                                }
                                else if(Integer.parseInt( num )<10)
                                {
                                    Toast.makeText( MainActivity.this,"长贷金额不能低于10W",Toast.LENGTH_SHORT ).show();
                                }
                                else {
                                    HttpUtil.applyLong(token,time[0],num,new Callback() {
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

                                                    Toast.makeText( MainActivity.this,"贷款成功",Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }
                                    });

                                }
                                longloan.setVisibility( View.GONE );
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
                alertDialog1.show();

            }
        } );

        //当季开始(success)
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
                                HttpUtil.start(token,new Callback() {
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
                                                setInfo( token );
                                            }
                                        });
                                    }
                                });
                                //Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                linearLayout.removeAllViews();
                                linearLayout.addView( view2);
                                shortloan.setVisibility( View.VISIBLE );

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
                final EditText number=linearLayout1.findViewById( R.id.number );
                alertDialog1.setTitle( "申请短贷" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                final String num=number.getText().toString();
                                if(Integer.parseInt( num )>200) {
                                    Toast.makeText( MainActivity.this,"长贷金额不能超过最大额度",Toast.LENGTH_SHORT ).show();
                                }
                                else if(Integer.parseInt( num )<10)
                                {
                                    Toast.makeText( MainActivity.this,"长贷金额不能低于10W",Toast.LENGTH_SHORT ).show();
                                }
                                else {
                                    HttpUtil.applyShort( token, num, new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText( MainActivity.this,"贷款成功",Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }
                                    } );
                                }
                                shortloan.setVisibility( View.GONE );
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
                alertDialog1.show();

            }
        } );

        //更新原料库(success)
        update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] product = new String[1];
                product[0]="";
                HttpUtil.info( token, "http://110.88.128.202:8088/stu/user/info", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                List<transportBean> transport=info.getData().getTransport();
                                for(int i=0;i<transport.size();i++)
                                {
                                    if(i==0)
                                    {
                                        if(transport.get( i ).getRemainder()==0)
                                        {
                                            product[0] ="R"+transport.get( i ).getProductId()+"("+transport.get( i ).getNum()+")";
                                        }
                                    }
                                    else
                                    {
                                        if(transport.get( i ).getRemainder()==0)
                                        {
                                            product[0] =product[0]+","+"R"+transport.get( i ).getProductId()+"("+transport.get( i ).getNum()+")";
                                        }
                                    }
                                }
                                if(transport.size()==0)
                                {
                                    product[0]="0";
                                }
                            }
                        });
                    }
                } );
                if(product[0].equals( "" ))
                {
                    product[0]="0";
                }
                alertDialog2.setTitle( "更新原料库" )
                        .setMessage( "现付金额 "+product[0]+"W" )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
                                HttpUtil.update( token,  new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                            }
                                        });
                                    }
                                } );
                                linearLayout.removeAllViews();
                                //linearLayout2.setVisibility( View.GONE );
                                linearLayout.addView( view3 );
                                buy.setVisibility( View.VISIBLE );
                                construction.setVisibility( View.VISIBLE);
                                setInfo(token );

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
        //订购原料(success）
        buy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.buy,null );
                final EditText number1=linearLayout1.findViewById( R.id.r1_number );
                final EditText number2=linearLayout1.findViewById( R.id.r2_number );
                final EditText number3=linearLayout1.findViewById( R.id.r3_number );
                final EditText number4=linearLayout1.findViewById( R.id.r4_number );
                final String[] nums =new String[1];
                final String[] ids =new String [1];
                nums[0]="";
                ids[0]="";
                alertDialog1.setTitle( "订购原料" )
                        .setView(linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String n1=number1.getText().toString();
                                String n2=number2.getText().toString();
                                String n3=number3.getText().toString();
                                String n4=number4.getText().toString();
                                String[]number={n1,n2,n3,n4};
                                for(int i=0;i<4;i++)
                                {
                                    if(Integer.parseInt( number[i])>0)
                                    {
                                        if(nums[0].equals( "" ))
                                        {
                                            nums[0] =number[i];
                                            ids[0] =String.valueOf( i+1 );
                                        }
                                        else
                                        {
                                            nums[0] = nums[0] +","+number[i];
                                            ids[0] = ids[0] +","+String.valueOf( i+1 );
                                        }
                                    }
                                }
                                if(nums[0].equals( "" ))
                                {
                                    Toast.makeText( MainActivity.this,"请输入订购原料的数量",Toast.LENGTH_SHORT ).show();
                                }
                                else
                                {
                                    HttpUtil.buy( token, nums[0], ids[0],new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                    if(info.getResultCode()==500)
                                                    {
                                                        Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    }

                                                }
                                            });
                                        }
                                    } );
                                    buy.setVisibility( View.GONE );
                                    setInfo( token );
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
                alertDialog1.show();

            }
        } );
        //购（租）厂房(success)
        buy_workshop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.buy_workshop, null);
                final Spinner spinner=(Spinner)linearLayout1.findViewById( R.id.spinner );
                final RadioButton radioButton1=(RadioButton)linearLayout1.findViewById( R.id.radioButton1 );
                final RadioButton radioButton2=(RadioButton)linearLayout1.findViewById( R.id.radioButton2 );
                //final RadioGroup radioGroup=(RadioGroup)linearLayout1.findViewById( R.id.radioGroup );
                final String[] s =new String[1];
                spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String[] languages = getResources().getStringArray(R.array.workshop);
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        s[0] =String.valueOf( position+3 );
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
                                if(s[0].equals( "3" ))
                                {
                                    Toast.makeText( MainActivity.this,"请选择厂房类型",Toast.LENGTH_SHORT ).show();
                                }
                                else if(!radioButton1.isChecked()&&!radioButton2.isChecked())
                                {
                                    Toast.makeText( MainActivity.this,"请选择购买或租赁",Toast.LENGTH_SHORT ).show();
                                }
                                else
                                {
                                    if(radioButton1.isChecked())
                                    {
                                        HttpUtil.buyworkshop( token, s[0], new Callback() {
                                            @Override
                                            public void onFailure(Call call, IOException e) {

                                            }

                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                final String responseData = response.body().string();
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                        if(info.getResultCode()==500)
                                                        {
                                                            Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                        }
                                                    }
                                                });
                                            }
                                        } );
                                    }
                                    else
                                    {
                                        HttpUtil.rentworkshop( token, s[0], new Callback() {
                                            @Override
                                            public void onFailure(Call call, IOException e) {

                                            }

                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                final String responseData = response.body().string();
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                        if(info.getResultCode()==500)
                                                        {
                                                            Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                        }

                                                    }
                                                });
                                            }
                                        } );
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
                alertDialog1.show();
            }
        } );


        //新建生产线(success)
        createline.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout  linearLayout1= (LinearLayout) getLayoutInflater().inflate(R.layout.createline, null);
                final RadioButton p1=linearLayout1.findViewById( R.id.p1 );
                final RadioButton p2=linearLayout1.findViewById( R.id.p2 );
                final RadioButton p3=linearLayout1.findViewById( R.id.p3 );
                final RadioButton p4=linearLayout1.findViewById( R.id.p4 );
                final RadioButton p5=linearLayout1.findViewById( R.id.p5 );
                final RadioButton []p={p1,p2,p3,p4,p5};
                final Spinner spinner1=(Spinner)linearLayout1.findViewById( R.id.spinner1 );
                final Spinner spinner2=(Spinner)linearLayout1.findViewById( R.id.spinner2 );
                final TextView place1=(TextView)findViewById( R.id.place1 ) ;
                final TextView place2=(TextView)findViewById( R.id.place2 ) ;
                final TextView place3=(TextView)findViewById( R.id.place3 ) ;
                final TextView place4=(TextView)findViewById( R.id.place4 ) ;
                final TextView []place={place1,place2,place3,place4};
                final int[] wsid =new int[1];
                final int []workshop=new int[4];
                final String[] plid=new String[1];
                final String[] pid = new String[1];
                //所属厂房
                list =new ArrayList<String>();
                list.add( "请选择厂房" );
                for(int i=0;i<4;i++)
                {
                    if(!place[i].getText().toString().equals( "空地" ))
                    {
                        list.add(place[i].getText().toString());
                    }
                }
                HttpUtil.info( token, "http://110.88.128.202:8088/stu/user/info", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                List<workshopBean> workshopList=info.getData().getWorkshop();
                                int x=0;
                                for(int i=0;i<workshopList.size();i++)
                                {
                                    workshop[x]=workshopList.get( i ).getId();

                                }
                                //Toast.makeText( MainActivity.this,workId[0],Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } );
                adapter=createLine(adapter);
                //厂房
                spinner1.setAdapter( adapter );
                spinner1.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        TextView tv = (TextView)view;
                        tv.setTextColor(Color.parseColor( "#000000" )); //设置颜色
                        tv.setTextSize(15.0f); //设置大小
                        tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL); //设置居中
                        wsid[0] = position-1;
                        //Toast.makeText( MainActivity.this,String.valueOf( position ),Toast.LENGTH_SHORT ).show();
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
                        plid[0] =String.valueOf( position +7);
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
                                for(int i=0;i<5;i++)
                                {
                                    if(p[i].isChecked())
                                    {
                                        pid[0] =String.valueOf( i+1 );
                                    }
                                }
                                if(plid[0].equals( "7" ))
                                {
                                    Toast.makeText( MainActivity.this,"请选择生产线类型",Toast.LENGTH_SHORT ).show();
                                }
                                else if (wsid[0]==-1)
                                {
                                    Toast.makeText( MainActivity.this,"请选择厂房",Toast.LENGTH_SHORT ).show();
                                }
                                else if(!p1.isChecked()&&!p2.isChecked()&&!p3.isChecked()&&!p4.isChecked()&&!p5.isChecked())
                                {
                                    Toast.makeText( MainActivity.this,"请选择产品",Toast.LENGTH_SHORT ).show();
                                }
                                else{

                                    HttpUtil.newLine( token,String.valueOf( workshop[wsid[0]] ), pid[0],plid[0],new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                if(info.getResultCode()==500)
                                                {
                                                    Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                }
                                            }
                                        });
                                    }
                                } );
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
                alertDialog1.show();

            }
        } );
        //在建生产线(success)
        construction.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.construction,null);
                final TableLayout tableLayout=linearLayout1.findViewById( R.id.table );
                final TextView nothing=linearLayout1.findViewById( R.id.nothing );
                final CheckBox c1=new CheckBox( getApplicationContext() );
                CheckBox c2=new CheckBox( getApplicationContext() );
                CheckBox c3=new CheckBox( getApplicationContext() );
                CheckBox c4=new CheckBox( getApplicationContext() );
                CheckBox c5=new CheckBox( getApplicationContext() );
                CheckBox c6=new CheckBox( getApplicationContext() );
                CheckBox c7=new CheckBox( getApplicationContext() );
                CheckBox c8=new CheckBox( getApplicationContext() );
                CheckBox c9=new CheckBox( getApplicationContext() );
                CheckBox c10=new CheckBox( getApplicationContext() );
                CheckBox c11=new CheckBox( getApplicationContext() );
                CheckBox c12=new CheckBox( getApplicationContext() );
                CheckBox c13=new CheckBox( getApplicationContext() );
                CheckBox c14=new CheckBox( getApplicationContext() );
                CheckBox c15=new CheckBox( getApplicationContext() );
                CheckBox c16=new CheckBox( getApplicationContext() );
                final CheckBox[]c={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16};
                for(int i=0;i<16;i++)
                {
                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                }
                final String []lineId=new String[16];
                final int[] num = new int[1];
                HttpUtil.buildingList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                changeLineBean info=JSON.parseObject( responseData,changeLineBean.class);
                                List<productLineBean> productLineList=info.getData();
                                num[0]=productLineList.size();
                                if(productLineList.size()>0)
                                {
                                    nothing.setVisibility( View.GONE );
                                }
                                else
                                {
                                    nothing.setVisibility( View.VISIBLE );
                                }
                                for(int i=0;i<productLineList.size();i++)
                                {
                                   // Toast.makeText( MainActivity.this,"ok",Toast.LENGTH_SHORT).show();
                                    lineId[i] = String.valueOf( productLineList.get( i ).getId() );
                                    TableRow row=new TableRow(getApplicationContext());
                                    LinearLayout l=new LinearLayout( getApplicationContext() );
                                    TextView ids=new TextView( getApplicationContext() );
                                    TextView workshopId=new TextView( getApplicationContext() );
                                    TextView name=new TextView( getApplicationContext() );
                                    TextView product=new TextView( getApplicationContext() );
                                    TextView investmentAmount=new TextView( getApplicationContext() );
                                    TextView start=new TextView( getApplicationContext() );
                                    TextView productLineRemainder=new TextView( getApplicationContext() );
                                    l.setBackgroundResource( R.drawable.textview_border );
                                    l.setGravity( Gravity.CENTER );
                                    ids.setBackgroundResource( R.drawable.textview_border );
                                    ids.setGravity( Gravity.CENTER );
                                    ids.setTextColor( Color.parseColor( "#000000" ) );
                                    ids.setTextSize( 15);
                                    ids.setHeight( 84 );
                                    workshopId.setBackgroundResource( R.drawable.textview_border );
                                    workshopId.setGravity( Gravity.CENTER );
                                    workshopId.setTextColor( Color.parseColor( "#000000" ) );
                                    workshopId.setTextSize( 15);
                                    workshopId.setHeight( 84 );
                                    name.setBackgroundResource( R.drawable.textview_border );
                                    name.setGravity( Gravity.CENTER );
                                    name.setTextColor( Color.parseColor( "#000000" ) );
                                    name.setTextSize( 15);
                                    name.setHeight( 84 );
                                    product.setBackgroundResource( R.drawable.textview_border );
                                    product.setGravity( Gravity.CENTER );
                                    product.setTextColor( Color.parseColor( "#000000" ) );
                                    product.setTextSize( 15);
                                    product.setHeight( 84 );
                                    investmentAmount.setBackgroundResource( R.drawable.textview_border );
                                    investmentAmount.setGravity( Gravity.CENTER );
                                    investmentAmount.setTextColor( Color.parseColor( "#000000" ) );
                                    investmentAmount.setTextSize( 15);
                                    investmentAmount.setHeight( 84 );
                                    start.setBackgroundResource( R.drawable.textview_border );
                                    start.setGravity( Gravity.CENTER );
                                    start.setTextColor( Color.parseColor( "#000000" ) );
                                    start.setTextSize( 15);
                                    start.setHeight( 84 );
                                    productLineRemainder.setBackgroundResource( R.drawable.textview_border );
                                    productLineRemainder.setGravity( Gravity.CENTER );
                                    productLineRemainder.setTextColor( Color.parseColor( "#000000" ) );
                                    productLineRemainder.setTextSize( 15);
                                    productLineRemainder.setHeight( 84 );
                                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                                    l.addView( c[i] );
                                    row.addView( l );
                                    ids.setText(String.valueOf( productLineList.get( i ).getId()  ));
                                    row.addView( ids );
                                    workshopId.setText( String.valueOf( productLineList.get( i ).getWorkshopId() ) );
                                    row.addView( workshopId );
                                    name.setText(  productLineList.get( i ).getConfigProductLine().getName());
                                    row.addView( name );
                                    product.setText( productLineList.get( i ).getConfigProduct().getName() );
                                    row.addView( product );
                                    investmentAmount.setText( String.valueOf( productLineList.get( i ).getInvestmentAmount() ) );
                                    row.addView( investmentAmount );
                                    int y=(productLineList.get( i ).getStartTime()+1)/4;
                                    int q=(productLineList.get( i ).getStartTime()+1)%4;
                                    if(q==0)
                                    {
                                        String startTime="第"+String.valueOf(  y)+"年第4季";
                                        start.setText( startTime );
                                    }
                                    else
                                    {
                                        String startTime="第"+String.valueOf( y+1)+"年第"+String.valueOf( q )+"季";
                                        start.setText( startTime );
                                    }
                                    row.addView( start );
                                    productLineRemainder.setText( String.valueOf( productLineList.get( i ).getProductLineRemainder() ) +"季");
                                    row.addView( productLineRemainder );
                                    tableLayout.addView( row);
                                }
                            }
                        });
                    }
                } );
                alertDialog1.setTitle( "在建生产线" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String lid="";
                                int y=0;
                                for(int i=0;i<num[0];i++)
                                {
                                    if(c[i].isChecked())
                                    {
                                        if(lid.equals( "" ))
                                        {
                                            lid=lineId[i];
                                        }
                                        else
                                        {
                                            lid=lid+","+lineId[i];
                                        }
                                    }
                                    else
                                    {
                                        y=y+1;
                                    }

                                }
                                if(y!=num[0])
                                {
                                    HttpUtil.invest( token, lid, new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                    if(info.getResultCode()==500)
                                                    {
                                                        Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    }
                                                }
                                            });
                                        }
                                    } );
                                }
                                construction.setVisibility( View.GONE );
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
                alertDialog1.show();
            }
        } );
        //生产线转产(success)
        changeline.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.changeline,null);
                final LinearLayout page=linearLayout1.findViewById( R.id.page2 );
                RadioButton p1=linearLayout1.findViewById( R.id.p1 );
                RadioButton p2=linearLayout1.findViewById( R.id.p2 );
                RadioButton p3=linearLayout1.findViewById( R.id.p3 );
                RadioButton p4=linearLayout1.findViewById( R.id.p4 );
                RadioButton p5=linearLayout1.findViewById( R.id.p5 );
                final RadioButton[]p={p1,p2,p3,p4,p5};
                final TableLayout tableLayout=linearLayout1.findViewById( R.id.table );
                final TextView nothing=linearLayout1.findViewById( R.id.nothing );
                final CheckBox c1=new CheckBox( getApplicationContext() );
                CheckBox c2=new CheckBox( getApplicationContext() );
                CheckBox c3=new CheckBox( getApplicationContext() );
                CheckBox c4=new CheckBox( getApplicationContext() );
                CheckBox c5=new CheckBox( getApplicationContext() );
                CheckBox c6=new CheckBox( getApplicationContext() );
                CheckBox c7=new CheckBox( getApplicationContext() );
                CheckBox c8=new CheckBox( getApplicationContext() );
                CheckBox c9=new CheckBox( getApplicationContext() );
                CheckBox c10=new CheckBox( getApplicationContext() );
                CheckBox c11=new CheckBox( getApplicationContext() );
                CheckBox c12=new CheckBox( getApplicationContext() );
                CheckBox c13=new CheckBox( getApplicationContext() );
                CheckBox c14=new CheckBox( getApplicationContext() );
                CheckBox c15=new CheckBox( getApplicationContext() );
                CheckBox c16=new CheckBox( getApplicationContext() );
                final CheckBox[]c={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16};
                for(int i=0;i<16;i++)
                {
                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                }
                final String []lineId=new String[16];
                final int[] num = new int[1];
                HttpUtil.changeList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                changeLineBean line=JSON.parseObject( responseData, changeLineBean.class);
                                List<productLineBean> productLineList=line.getData();
                                if(productLineList.size()!=0)
                                {
                                    nothing.setVisibility( View.GONE );
                                    page.setVisibility( View.VISIBLE );
                                    num[0] =productLineList.size();
                                }
                                else
                                {
                                    nothing.setVisibility( View.VISIBLE );

                                }
                                for(int i=0;i<productLineList.size();i++)
                                {

                                    lineId[i] = String.valueOf( productLineList.get( i ).getId() );
                                    TextView ids=new TextView( getApplicationContext() );
                                    TextView workshopId=new TextView( getApplicationContext() );
                                    TextView name=new TextView( getApplicationContext() );
                                    TextView product=new TextView( getApplicationContext() );
                                    TextView turnOverTime=new TextView( getApplicationContext() );
                                    TextView turnOverCost=new TextView( getApplicationContext() );
                                    LinearLayout ls=new LinearLayout( getApplicationContext() );
                                    TableRow rows=new TableRow( getApplicationContext() );
                                    ls.setBackgroundResource( R.drawable.textview_border );
                                    ls.setGravity( Gravity.CENTER );
                                    ids.setBackgroundResource( R.drawable.textview_border );
                                    ids.setGravity( Gravity.CENTER );
                                    ids.setTextColor( Color.parseColor( "#000000" ) );
                                    ids.setTextSize( 15);
                                    ids.setHeight( 84 );
                                    workshopId.setBackgroundResource( R.drawable.textview_border );
                                    workshopId.setGravity( Gravity.CENTER );
                                    workshopId.setTextColor( Color.parseColor( "#000000" ) );
                                    workshopId.setTextSize( 15);
                                    workshopId.setHeight( 84 );
                                    name.setBackgroundResource( R.drawable.textview_border );
                                    name.setGravity( Gravity.CENTER );
                                    name.setTextColor( Color.parseColor( "#000000" ) );
                                    name.setTextSize( 15);
                                    name.setHeight( 84 );
                                    product.setBackgroundResource( R.drawable.textview_border );
                                    product.setGravity( Gravity.CENTER );
                                    product.setTextColor( Color.parseColor( "#000000" ) );
                                    product.setTextSize( 15);
                                    product.setHeight( 84 );
                                    turnOverTime.setBackgroundResource( R.drawable.textview_border );
                                    turnOverTime.setGravity( Gravity.CENTER );
                                    turnOverTime.setTextColor( Color.parseColor( "#000000" ) );
                                    turnOverTime.setTextSize( 15);
                                    turnOverTime.setHeight( 84 );
                                    turnOverCost.setBackgroundResource( R.drawable.textview_border );
                                    turnOverCost.setGravity( Gravity.CENTER );
                                    turnOverCost.setTextColor( Color.parseColor( "#000000" ) );
                                    turnOverCost.setTextSize( 15);
                                    turnOverCost.setHeight( 84 );
                                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                                    ls.addView( c[i] );
                                    rows.addView( ls);
                                    ids.setText(String.valueOf( productLineList.get( i ).getId()  ));
                                    rows.addView( ids );
                                    workshopId.setText( String.valueOf( productLineList.get( i ).getWorkshopId() ) );
                                    rows.addView( workshopId );
                                    name.setText(  productLineList.get( i ).getConfigProductLine().getName());
                                    rows.addView( name );
                                    product.setText( productLineList.get( i ).getConfigProduct().getName() );
                                    rows.addView( product );
                                    turnOverTime.setText( String.valueOf( productLineList.get( i ).getConfigProductLine().getTurnOverTime() ) +"季");
                                    rows.addView( turnOverTime );
                                    turnOverCost.setText( String.valueOf( productLineList.get( i ).getConfigProductLine().getTurnOverCost() ) +"W");
                                    rows.addView( turnOverCost );
                                    tableLayout.addView( rows );
                                }
                            }
                        });
                    }
                } );

                alertDialog1.setTitle( "生产线转产" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int x=0;
                                int y=0;
                                String lid="";
                                String pid="";
                                for(int i=0;i<5;i++)
                                {
                                    if(p[i].isChecked())
                                    {
                                        pid=String.valueOf( i+1);
                                    }
                                    else
                                    {
                                        x=x+1;
                                    }
                                }
                                for(int i=0;i<num[0];i++)
                                {
                                    if(c[i].isChecked())
                                    {
                                        if(lid.equals( "" ))
                                        {
                                            lid=lineId[i];
                                        }
                                        else
                                        {
                                            lid=lid+","+lineId[i];
                                        }
                                    }
                                    else
                                    {
                                        y=y+1;
                                    }
                                }

                                if(x==5||y==num[0])
                                {
                                    Toast.makeText( MainActivity.this,"未选择生产线或产品类型",Toast.LENGTH_SHORT).show();
                                }
                                if(!lid.equals( "" )&&!pid.equals( "" ))
                                {
                                    HttpUtil.change( token, lid, pid, new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                    if(info.getResultCode()==500)
                                                    {
                                                        Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    }
                                                }
                                            });
                                        }
                                    } );
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
                alertDialog1.show();
            }
        } );
        //继续转产(未测试)
        continuechange.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.continuechangeline,null);
                final TableLayout tableLayout=linearLayout1.findViewById( R.id.table );
                final TextView nothing=linearLayout1.findViewById( R.id.nothing );
                final CheckBox c1=new CheckBox( getApplicationContext() );
                CheckBox c2=new CheckBox( getApplicationContext() );
                CheckBox c3=new CheckBox( getApplicationContext() );
                CheckBox c4=new CheckBox( getApplicationContext() );
                CheckBox c5=new CheckBox( getApplicationContext() );
                CheckBox c6=new CheckBox( getApplicationContext() );
                CheckBox c7=new CheckBox( getApplicationContext() );
                CheckBox c8=new CheckBox( getApplicationContext() );
                CheckBox c9=new CheckBox( getApplicationContext() );
                CheckBox c10=new CheckBox( getApplicationContext() );
                CheckBox c11=new CheckBox( getApplicationContext() );
                CheckBox c12=new CheckBox( getApplicationContext() );
                CheckBox c13=new CheckBox( getApplicationContext() );
                CheckBox c14=new CheckBox( getApplicationContext() );
                CheckBox c15=new CheckBox( getApplicationContext() );
                CheckBox c16=new CheckBox( getApplicationContext() );
                final CheckBox[]c={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16};
                for(int i=0;i<16;i++)
                {
                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                }
                final String []lineId=new String[16];
                final int[] num = new int[1];
                final String []pId=new String[16];
                HttpUtil.changingList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                changeLineBean line=JSON.parseObject( responseData, changeLineBean.class);
                                List<productLineBean> productLineList=line.getData();
                                num[0] =productLineList.size();
                                if(productLineList.size()!=0)
                                {
                                    nothing.setVisibility( View.GONE );
                                }
                                else
                                {
                                    nothing.setVisibility( View.VISIBLE );
                                }
                                for(int i=0;i<productLineList.size();i++)
                                {
                                   if(productLineList.get( i ).getProductLineRemainder()>0)
                                   {
                                       lineId[i] = String.valueOf( productLineList.get( i ).getId() );
                                       pId[i]=String.valueOf( productLineList.get( i ).getProductId() );
                                       TextView ids=new TextView( getApplicationContext() );
                                       TextView workshopId=new TextView( getApplicationContext() );
                                       TextView name=new TextView( getApplicationContext() );
                                       TextView product=new TextView( getApplicationContext() );
                                       TextView depreciationExpense=new TextView( getApplicationContext() );
                                       TextView productLineRemainder=new TextView( getApplicationContext() );
                                       LinearLayout ls=new LinearLayout( getApplicationContext() );
                                       TableRow rows=new TableRow( getApplicationContext() );
                                       ls.setBackgroundResource( R.drawable.textview_border );
                                       ls.setGravity( Gravity.CENTER );
                                       ids.setBackgroundResource( R.drawable.textview_border );
                                       ids.setGravity( Gravity.CENTER );
                                       ids.setTextColor( Color.parseColor( "#000000" ) );
                                       ids.setTextSize( 15);
                                       ids.setHeight( 84 );
                                       workshopId.setBackgroundResource( R.drawable.textview_border );
                                       workshopId.setGravity( Gravity.CENTER );
                                       workshopId.setTextColor( Color.parseColor( "#000000" ) );
                                       workshopId.setTextSize( 15);
                                       workshopId.setHeight( 84 );
                                       name.setBackgroundResource( R.drawable.textview_border );
                                       name.setGravity( Gravity.CENTER );
                                       name.setTextColor( Color.parseColor( "#000000" ) );
                                       name.setTextSize( 15);
                                       name.setHeight( 84 );
                                       product.setBackgroundResource( R.drawable.textview_border );
                                       product.setGravity( Gravity.CENTER );
                                       product.setTextColor( Color.parseColor( "#000000" ) );
                                       product.setTextSize( 15);
                                       product.setHeight( 84 );
                                       depreciationExpense.setBackgroundResource( R.drawable.textview_border );
                                       depreciationExpense.setGravity( Gravity.CENTER );
                                       depreciationExpense.setTextColor( Color.parseColor( "#000000" ) );
                                       depreciationExpense.setTextSize( 15);
                                       depreciationExpense.setHeight( 84 );
                                       productLineRemainder.setBackgroundResource( R.drawable.textview_border );
                                       productLineRemainder.setGravity( Gravity.CENTER );
                                       productLineRemainder.setTextColor( Color.parseColor( "#000000" ) );
                                       productLineRemainder.setTextSize( 15);
                                       productLineRemainder.setHeight( 84 );
                                       c[i].setBackgroundResource( R.drawable.checkbox_style );
                                       ls.addView( c[i] );
                                       rows.addView( ls);
                                       ids.setText(String.valueOf( productLineList.get( i ).getId()  ));
                                       rows.addView( ids );
                                       workshopId.setText( String.valueOf( productLineList.get( i ).getWorkshopId() ) );
                                       rows.addView( workshopId );
                                       name.setText(  productLineList.get( i ).getConfigProductLine().getName());
                                       rows.addView( name );
                                       product.setText( productLineList.get( i ).getConfigProduct().getName() );
                                       rows.addView( product );
                                       depreciationExpense.setText( String.valueOf( productLineList.get( i ).getConfigProductLine().getDepreciationExpense())+"W");
                                       rows.addView( depreciationExpense );
                                       productLineRemainder.setText(String.valueOf( productLineList.get( i).getProductLineRemainder()+"季" )  );
                                       rows.addView( productLineRemainder );
                                       tableLayout.addView( rows );
                                   }
                                }
                            }
                        });
                    }
                } );
                alertDialog1.setTitle( "继续转产" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int y=0;
                                String lid="";
                                String pid="";
                                for(int i=0;i<num[0];i++)
                                {
                                    if(c[i].isChecked())
                                    {
                                        if(lid.equals( "" ))
                                        {
                                            lid=lineId[i];
                                            pid=pId[i];
                                        }
                                        else
                                        {
                                            lid=lid+","+lineId[i];
                                            pid=pid+","+pId[i];
                                        }
                                    }
                                    else
                                    {
                                        y=y+1;
                                    }
                                }
                                if (y!=num[0]&&num[0]!=0)
                                {
                                    HttpUtil.change( token, lid,pid,new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                    if(info.getResultCode()==500)
                                                    {
                                                        Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    }
                                                }
                                            });
                                        }
                                    } );
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
                alertDialog1.show();
            }
        } );
        //出售生产线(success)
        soldline.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.soldline,null);
                final TableLayout tableLayout=linearLayout1.findViewById( R.id.table );
                final TextView nothing=linearLayout1.findViewById( R.id.nothing );
                final CheckBox c1=new CheckBox( getApplicationContext() );
                CheckBox c2=new CheckBox( getApplicationContext() );
                CheckBox c3=new CheckBox( getApplicationContext() );
                CheckBox c4=new CheckBox( getApplicationContext() );
                CheckBox c5=new CheckBox( getApplicationContext() );
                CheckBox c6=new CheckBox( getApplicationContext() );
                CheckBox c7=new CheckBox( getApplicationContext() );
                CheckBox c8=new CheckBox( getApplicationContext() );
                CheckBox c9=new CheckBox( getApplicationContext() );
                CheckBox c10=new CheckBox( getApplicationContext() );
                CheckBox c11=new CheckBox( getApplicationContext() );
                CheckBox c12=new CheckBox( getApplicationContext() );
                CheckBox c13=new CheckBox( getApplicationContext() );
                CheckBox c14=new CheckBox( getApplicationContext() );
                CheckBox c15=new CheckBox( getApplicationContext() );
                CheckBox c16=new CheckBox( getApplicationContext() );
                final CheckBox[]c={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16};
                for(int i=0;i<16;i++)
                {
                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                }
                final String[]lineId=new String[16];
                final int[]num=new int[1];
                HttpUtil.freeList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                changeLineBean line=JSON.parseObject( responseData, changeLineBean.class);
                                List<productLineBean> productLineList=line.getData();
                                num[0] =productLineList.size();
                                if(productLineList.size()!=0)
                                {
                                    nothing.setVisibility( View.GONE );
                                }
                                else
                                {
                                    nothing.setVisibility( View.VISIBLE );
                                }
                                for(int i=0;i<productLineList.size();i++)
                                {
                                    lineId[i] = String.valueOf( productLineList.get( i ).getId() );
                                    TextView ids=new TextView( getApplicationContext() );
                                    TextView start=new TextView( getApplicationContext() );
                                    TextView name=new TextView( getApplicationContext() );
                                    TextView workshopId=new TextView( getApplicationContext() );
                                    TextView product=new TextView( getApplicationContext() );
                                    TextView investmentAmount=new TextView( getApplicationContext() );
                                    TextView finishTime=new TextView( getApplicationContext() );
                                    LinearLayout ls=new LinearLayout( getApplicationContext() );
                                    TableRow rows=new TableRow( getApplicationContext() );
                                    ls.setBackgroundResource( R.drawable.textview_border );
                                    ls.setGravity( Gravity.CENTER );
                                    ids.setBackgroundResource( R.drawable.textview_border );
                                    ids.setGravity( Gravity.CENTER );
                                    ids.setTextColor( Color.parseColor( "#000000" ) );
                                    ids.setTextSize( 15);
                                    ids.setHeight( 84 );

                                    name.setBackgroundResource( R.drawable.textview_border );
                                    name.setGravity( Gravity.CENTER );
                                    name.setTextColor( Color.parseColor( "#000000" ) );
                                    name.setTextSize( 15);
                                    name.setHeight( 84 );
                                    start.setBackgroundResource( R.drawable.textview_border );
                                    start.setGravity( Gravity.CENTER );
                                    start.setTextColor( Color.parseColor( "#000000" ) );
                                    start.setTextSize( 15);
                                    start.setHeight( 84 );
                                    workshopId.setBackgroundResource( R.drawable.textview_border );
                                    workshopId.setGravity( Gravity.CENTER );
                                    workshopId.setTextColor( Color.parseColor( "#000000" ) );
                                    workshopId.setTextSize( 15);
                                    workshopId.setHeight( 84 );
                                    product.setBackgroundResource( R.drawable.textview_border );
                                    product.setGravity( Gravity.CENTER );
                                    product.setTextColor( Color.parseColor( "#000000" ) );
                                    product.setTextSize( 15);
                                    product.setHeight( 84 );
                                    investmentAmount.setBackgroundResource( R.drawable.textview_border );
                                    investmentAmount.setGravity( Gravity.CENTER );
                                    investmentAmount.setTextColor( Color.parseColor( "#000000" ) );
                                    investmentAmount.setTextSize( 15);
                                    investmentAmount.setHeight( 84 );
                                    finishTime.setBackgroundResource( R.drawable.textview_border );
                                    finishTime.setGravity( Gravity.CENTER );
                                    finishTime.setTextColor( Color.parseColor( "#000000" ) );
                                    finishTime.setTextSize( 15);
                                    finishTime.setHeight( 84 );
                                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                                    ls.addView( c[i] );
                                    rows.addView( ls);
                                    ids.setText(String.valueOf( productLineList.get( i ).getId()  ));
                                    rows.addView( ids );

                                    name.setText(  productLineList.get( i ).getConfigProductLine().getName());
                                    rows.addView( name );
                                    int y=(productLineList.get( i ).getStartTime()+1)/4;
                                    int q=(productLineList.get( i ).getStartTime()+1)%4;
                                    if(q==0)
                                    {
                                        String startTime="第"+String.valueOf(  y)+"年第4季";
                                        start.setText( startTime );
                                    }
                                    else
                                    {
                                        String startTime="第"+String.valueOf( y+1)+"年第"+String.valueOf( q )+"季";
                                        start.setText( startTime );
                                    }
                                    workshopId.setText( String.valueOf( productLineList.get( i ).getWorkshopId() ) );
                                    rows.addView( workshopId );
                                    product.setText( productLineList.get( i ).getConfigProduct().getName() );
                                    rows.addView( product );
                                    investmentAmount.setText( String.valueOf( productLineList.get( i ).getConfigProductLine().getTurnOverTime() ) +"季");
                                    rows.addView( investmentAmount );
                                    int y1=(productLineList.get( i ).getFinishTime()+1)/4;
                                    int q1=(productLineList.get( i ).getFinishTime()+1)%4;
                                    if(q1==0)
                                    {
                                        String ft="第"+String.valueOf(  y1)+"年第4季";
                                        finishTime.setText( ft );
                                    }
                                    else
                                    {
                                        String ft="第"+String.valueOf( y1+1)+"年第"+String.valueOf( q1 )+"季";
                                        finishTime.setText( ft );
                                    }
                                    rows.addView( finishTime );
                                    tableLayout.addView( rows );
                                }
                            }
                        });
                    }
                } );
                alertDialog1.setTitle( "出售生产线" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String lid="";
                                int y=0;
                                for(int i=0;i<num[0];i++)
                                {
                                    if(c[i].isChecked())
                                    {
                                        if(lid.equals( "" ))
                                        {
                                            lid=lineId[i];
                                        }
                                        else
                                        {
                                            lid=lid+","+lineId[i];
                                        }
                                    }
                                    else
                                    {
                                        y=y+1;
                                    }
                                }
                                if (y!=num[0]&&num[0]!=0)
                                {
                                    HttpUtil.sell( token, lid,new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                    if(info.getResultCode()==500)
                                                    {
                                                        Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    }
                                                }
                                            });
                                        }
                                    } );
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
                alertDialog1.show();
            }
        } );
        //开始生产(success)
        startproduction.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.startproduction,null);
                final TableLayout tableLayout=linearLayout1.findViewById( R.id.table );
                final TextView nothing=linearLayout1.findViewById( R.id.nothing );
                final CheckBox c1=new CheckBox( getApplicationContext() );
                CheckBox c2=new CheckBox( getApplicationContext() );
                CheckBox c3=new CheckBox( getApplicationContext() );
                CheckBox c4=new CheckBox( getApplicationContext() );
                CheckBox c5=new CheckBox( getApplicationContext() );
                CheckBox c6=new CheckBox( getApplicationContext() );
                CheckBox c7=new CheckBox( getApplicationContext() );
                CheckBox c8=new CheckBox( getApplicationContext() );
                CheckBox c9=new CheckBox( getApplicationContext() );
                CheckBox c10=new CheckBox( getApplicationContext() );
                CheckBox c11=new CheckBox( getApplicationContext() );
                CheckBox c12=new CheckBox( getApplicationContext() );
                CheckBox c13=new CheckBox( getApplicationContext() );
                CheckBox c14=new CheckBox( getApplicationContext() );
                CheckBox c15=new CheckBox( getApplicationContext() );
                CheckBox c16=new CheckBox( getApplicationContext() );
                final CheckBox[]c={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16};
                for(int i=0;i<16;i++)
                {
                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                }
                final String[]lineId=new String[16];
                final int[]num=new int[1];
                HttpUtil.freeList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                changeLineBean line=JSON.parseObject( responseData, changeLineBean.class);
                                List<productLineBean> productLineList=line.getData();
                                num[0] =productLineList.size();
                                if(productLineList.size()!=0)
                                {
                                    nothing.setVisibility( View.GONE );
                                }
                                else
                                {
                                    nothing.setVisibility( View.VISIBLE );
                                }
                                for(int i=0;i<productLineList.size();i++)
                                {
                                    lineId[i] = String.valueOf( productLineList.get( i ).getId() );
                                    TextView ids=new TextView( getApplicationContext() );
                                    TextView workshopId=new TextView( getApplicationContext() );
                                    TextView name=new TextView( getApplicationContext() );
                                    TextView product=new TextView( getApplicationContext() );
                                    LinearLayout ls=new LinearLayout( getApplicationContext() );
                                    TableRow rows=new TableRow( getApplicationContext() );
                                    ls.setBackgroundResource( R.drawable.textview_border );
                                    ls.setGravity( Gravity.CENTER );
                                    ids.setBackgroundResource( R.drawable.textview_border );
                                    ids.setGravity( Gravity.CENTER );
                                    ids.setTextColor( Color.parseColor( "#000000" ) );
                                    ids.setTextSize( 15);
                                    ids.setHeight( 84 );
                                    workshopId.setBackgroundResource( R.drawable.textview_border );
                                    workshopId.setGravity( Gravity.CENTER );
                                    workshopId.setTextColor( Color.parseColor( "#000000" ) );
                                    workshopId.setTextSize( 15);
                                    workshopId.setHeight( 84 );
                                    name.setBackgroundResource( R.drawable.textview_border );
                                    name.setGravity( Gravity.CENTER );
                                    name.setTextColor( Color.parseColor( "#000000" ) );
                                    name.setTextSize( 15);
                                    name.setHeight( 84 );
                                    product.setBackgroundResource( R.drawable.textview_border );
                                    product.setGravity( Gravity.CENTER );
                                    product.setTextColor( Color.parseColor( "#000000" ) );
                                    product.setTextSize( 15);
                                    product.setHeight( 84 );
                                    c[i].setBackgroundResource( R.drawable.checkbox_style );
                                    ls.addView( c[i] );
                                    rows.addView( ls);
                                    ids.setText(String.valueOf( productLineList.get( i ).getId()  ));
                                    rows.addView( ids );

                                    name.setText(  productLineList.get( i ).getConfigProductLine().getName());
                                    rows.addView( name );
                                    workshopId.setText( String.valueOf( productLineList.get( i ).getWorkshopId() ) );
                                    rows.addView( workshopId );
                                    product.setText( productLineList.get( i ).getConfigProduct().getName() );
                                    rows.addView( product );
                                    tableLayout.addView( rows );
                                }
                            }
                        });
                    }
                } );
                alertDialog1.setTitle( "开始生产" )
                        .setView(  linearLayout1)
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String lid="";
                                int y=0;
                                for(int i=0;i<num[0];i++)
                                {
                                    if(c[i].isChecked())
                                    {
                                        if(lid.equals( "" ))
                                        {
                                            lid=lineId[i];
                                        }
                                        else
                                        {
                                            lid=lid+","+lineId[i];
                                        }
                                    }
                                    else
                                    {
                                        y=y+1;
                                    }
                                }
                                if (y!=num[0]&&num[0]!=0)
                                {
                                    HttpUtil.startProduce( token, lid,new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {

                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            final String responseData = response.body().string();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                    if(info.getResultCode()==500)
                                                    {
                                                        Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    }
                                                }
                                            });
                                        }
                                    } );
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
                alertDialog1.show();
            }
        } );


        //更新应收款账(success)
        update1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] num =new int[1];
                final int []period=new int[1];
                num[0]=0;
                HttpUtil.info( token, "http://110.88.128.202:8088/stu/user/info", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                com.example.erp1.info.dataBean data=info.getData();
                                List<receivableBean> receivableList=data.getReceivable();
                                if(receivableList.size()!=0)
                                {
                                    num[0] =num[0]+receivableList.get(0).getReceivableValue();
                                }
                                period[0]=info.getData().getCompany().getPeriod();
                            }
                        });
                    }
                } );
                alertDialog2.setTitle( "更新应收款账" )
                        .setMessage( "收现金额(1期)"+String.valueOf( num[0] )+"W" )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HttpUtil.receviable( token, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                if(info.getResultCode()==500)
                                                {
                                                    Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                }
                                            }
                                        });
                                    }
                                } );
                                dialog.dismiss();
                                linearLayout.removeAllViews();
                                if (period[0]%4!=3)
                                {
                                    linearLayout.addView( view4 );
                                    researchproduct.setVisibility( View.VISIBLE );
                                }
                                else
                                {
                                    linearLayout.addView( view5 );
                                    researchproduct1.setVisibility( View.VISIBLE );
                                    exploit.setVisibility( View.VISIBLE );
                                    investment.setVisibility( View.VISIBLE );
                                }
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
        //厂房处理(未测试)
        managefactory.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managefactory(token);
            }
        } );
        managefactory1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managefactory(token);
            }
        } );
        //产品研发(success)
        researchproduct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchproduce(researchproduct,token);

            }
        } );
        researchproduct1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchproduce(researchproduct1,token);
            }
        } );
        //当季结束(success)
        end.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.end,null );
                alertDialog1.setTitle( "当季结束" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HttpUtil.end( token, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                if(info.getResultCode()==500)
                                                {
                                                    Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                }
                                            }
                                        });
                                    }
                                } );
                                linearLayout.removeAllViews();
                                linearLayout.addView( view1);
                                longloan.setVisibility( View.GONE );
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
                alertDialog1.show();

            }
        } );
        //市场开拓(success)
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
                final CheckBox[]s={s1,s2,s3,s4,s5};
//                allselect.setOnClickListener( new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(s1.isChecked()&&s2.isChecked()&&s3.isChecked()&&s4.isChecked()&&s5.isChecked())
//                        {
//                            s1.setChecked( false );
//                            s2.setChecked( false);
//                            s3.setChecked( false );
//                            s4.setChecked( false );
//                            s5.setChecked( false );
//                        }
//                        else
//                        {
//                            s1.setChecked( true );
//                            s2.setChecked( true );
//                            s3.setChecked( true );
//                            s4.setChecked( true );
//                            s5.setChecked( true );
//                        }
//
//                    }
//                } );
                final TextView time1=linearLayout1.findViewById( R.id.time1 );
                final TextView time2=linearLayout1.findViewById( R.id.time2 );
                final TextView time3=linearLayout1.findViewById( R.id.time3 );
                final TextView time41=linearLayout1.findViewById( R.id.time4 );
                final TextView time5=linearLayout1.findViewById( R.id.time5 );
                final TextView []time={time1,time2,time3,time41,time5};
                HttpUtil.developingMarketList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                developingMarketBean  developingMarket=JSON.parseObject( responseData,developingMarketBean.class );
                                List<developMarketBean> developMarketList=developingMarket.getData();
                                for(int i=0;i<developMarketList.size();i++)
                                {
                                    if(developMarketList.get( i ).getDevelopingRemainder()>0)
                                    {
                                        time[i].setText( String.valueOf(  developMarketList.get( i ).getDevelopingRemainder()) );
                                    }
                                    if(developMarketList.get( i ).getDevelopingRemainder()==0&&developMarketList.get( i ).getCreateTime()!=null)
                                    {
                                        s[i].setEnabled( false );
                                        time[i].setText( "已开拓" );
                                    }
                                }
                            }
                        });
                    }
                } );
                alertDialog1.setTitle( "市场开拓" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id="";
                                for(int i=0;i<5;i++)
                                {
                                    if(s[i].isChecked())
                                    {
                                        if(id.equals( "" ))
                                        {
                                            id=String.valueOf( i+1);
                                        }
                                        else
                                        {
                                            id=id+","+String.valueOf( i+1 );
                                        }
                                    }
                                }
                                HttpUtil.developMarket( token, id, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                if(info.getResultCode()==500)
                                                {
                                                    Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                }
                                                if(info.getResultCode()==200)
                                                {
                                                    exploit.setVisibility( View.GONE );
                                                }
                                            }
                                        });
                                    }
                                } );
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
                alertDialog1.show();
            }
        } );
        //ISO投资（success）
        investment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.investment,null );
                Button allselect=linearLayout1.findViewById( R.id.allselect );
                final CheckBox s1=linearLayout1.findViewById( R.id.s1 );
                final CheckBox s2=linearLayout1.findViewById( R.id.s2 );
                final CheckBox []s={s1,s2};
                TextView time1=linearLayout1.findViewById( R.id.time1 );
                TextView time2=linearLayout1.findViewById( R.id.time2 );
                final TextView []time={time1,time2};
                HttpUtil.developingISOList( token, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String responseData = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                developingIsoBean developingISO=JSON.parseObject( responseData,developingIsoBean.class );
                                List<developIsoBean> developIsoList=developingISO.getData();
                                for(int i=0;i<developIsoList.size();i++)
                                {
                                    if(developIsoList.get( i ).getDevelopingRemainder()>0)
                                    {
                                        time[i].setText( String.valueOf(  developIsoList.get( i ).getDevelopingRemainder()) );
                                    }
                                    if(developIsoList.get( i ).getDevelopingRemainder()==0&&developIsoList.get( i ).getCreateTime()!=null)
                                    {
                                        s[i].setEnabled( false );
                                        time[i].setText( "已认证" );
                                    }
                                }
                            }
                        });
                    }
                } );
//                allselect.setOnClickListener( new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(s1.isChecked()&&s2.isChecked())
//                        {
//                            s1.setChecked( false );
//                            s2.setChecked( false);
//                        }
//                        else
//                        {
//                            s1.setChecked( true );
//                            s2.setChecked( true );
//
//                        }
//
//                    }
//                } );
                alertDialog1.setTitle( "ISO投资" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id="";
                                for(int i=0;i<2;i++)
                                {
                                    if(s[i].isChecked())
                                    {
                                        if(id.equals( "" ))
                                        {
                                            id=String.valueOf( i+1);
                                        }
                                        else
                                        {
                                            id=id+","+String.valueOf( i+1 );
                                        }
                                    }
                                }
                                HttpUtil.developISO( token, id, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                if(info.getResultCode()==500)
                                                {
                                                    Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                }
                                                if(info.getResultCode()==200)
                                                {
                                                    investment.setVisibility( View.GONE );
                                                }
                                            }
                                        });
                                    }
                                } );
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
                alertDialog1.show();
            }
        } );
        //第四季当季结束（success)
        end1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.end,null );
                alertDialog1.setTitle( "当季结束" )
                        .setView( linearLayout1 )
                        .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HttpUtil.end( token, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        final String responseData = response.body().string();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                if(info.getResultCode()==500)
                                                {
                                                    Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                    setInfo( token );
                                                }
                                            }
                                        });
                                    }
                                } );
                                linearLayout.removeAllViews();
                                linearLayout.addView( view6);
                                report.setVisibility( View.VISIBLE );
                                advertising.setVisibility( View.VISIBLE );
                                researchproduct.setVisibility( View.VISIBLE );
                                researchproduct1.setVisibility( View.VISIBLE );
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
                alertDialog1.show();
            }
        } );

        //填写报表(success)
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

                //table1
                EditText adminstrativeCost=linearLayout1.findViewById( R.id.adminstrativeCost );
                EditText adCost=linearLayout1.findViewById( R.id.adCost );
                EditText maintenanceCost=linearLayout1.findViewById( R.id.maintenanceCost );
                EditText loss=linearLayout1.findViewById( R.id.loss );
                EditText turnOverCost=linearLayout1.findViewById( R.id.turnOverCost );
                EditText rentCost=linearLayout1.findViewById( R.id.rentCost );
                EditText developingMarketCost=linearLayout1.findViewById( R.id.developingMarketCost );
                EditText developingProductCost=linearLayout1.findViewById( R.id.developingProductCost );
                EditText developingIsoCost=linearLayout1.findViewById( R.id.developingIsoCost );
                EditText informationCost=linearLayout1.findViewById( R.id.informationCost );
                final TextView total=linearLayout1.findViewById( R.id.total );
                final EditText []t1={adminstrativeCost,adCost,maintenanceCost,loss,turnOverCost,rentCost,developingMarketCost,developingProductCost,developingIsoCost,informationCost};
                for(int i=0;i<10;i++)
                {
                    t1[i].setOnFocusChangeListener( new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            int s1=0;
                            for(int j=0;j<10;j++)
                            {
                                if(!t1[j].getText().toString().equals( "" )&&!t1[j].getText().toString().equals( "0" ))
                                {
                                    s1=s1+Integer.parseInt( t1[j].getText().toString() );
                                }
                            }
                            total.setText( String.valueOf( s1 ) );
                        }
                    } );

                }
                //table2
                EditText sales=linearLayout1.findViewById( R.id.sales );
                EditText directCost=linearLayout1.findViewById( R.id.directCost );
                EditText comprehensiveCost=linearLayout1.findViewById( R.id.comprehensiveCost );
                EditText depreciationCost=linearLayout1.findViewById( R.id.depreciationCost );
                EditText financialCost=linearLayout1.findViewById( R.id.financialCost );
                EditText tax=linearLayout1.findViewById( R.id.tax );
                final TextView grossProfit=linearLayout1.findViewById( R.id.grossProfit );
                final TextView profitBeforeTax=linearLayout1.findViewById( R.id.profitBeforeTax );
                final TextView profitBeforeDepreciation=linearLayout1.findViewById( R.id.profitBeforeDepreciation );
                final TextView profitBeforeInterest=linearLayout1.findViewById( R.id.profitBeforeInterest );
                final TextView annualNetprofit=linearLayout1.findViewById( R.id.annualNetprofit );
                final EditText []t2={sales,directCost,comprehensiveCost,depreciationCost,financialCost,tax};
                final TextView []u2={grossProfit,profitBeforeTax,profitBeforeDepreciation,profitBeforeInterest,annualNetprofit};
                for(int i=0;i<6;i++)
                {
                    t2[i].setOnFocusChangeListener( new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            int s1=0;
                            int s2=0;
                            int s3=0;
                            int s4=0;
                            int s5=0;
                            if( !t2[0].getText().toString().equals( "" )&&!t2[1].getText().toString().equals( "" )) {
                                s1 = Integer.parseInt( t2[0].getText().toString() )-Integer.parseInt( t2[1].getText().toString() );
                            }
                            else if(!t2[0].getText().toString().equals( "" )&&t2[1].getText().toString().equals( "" ))
                            {
                                s1=Integer.parseInt( t2[0].getText().toString() );
                            }
                            else if(t2[0].getText().toString().equals( "" )&&!t2[1].getText().toString().equals( "" ))
                            {
                                s1=s1-Integer.parseInt( t2[1].getText().toString() );
                            }
                            grossProfit.setText( String.valueOf( s1 ) );
                            if(!t2[2].getText().toString().equals( "" ))
                            {
                                s2= s1-Integer.parseInt( t2[2].getText().toString());
                                profitBeforeDepreciation.setText( String.valueOf( s2 ) );
                            }
                            else
                            {
                                s2=s1;
                                profitBeforeDepreciation.setText( String.valueOf( s2) );
                            }

                            if(!t2[3].getText().toString().equals( "" ))
                            {
                                s3= s2-Integer.parseInt( t2[3].getText().toString());
                                profitBeforeInterest.setText( String.valueOf( s3 ) );
                            }
                            else
                            {
                                s3=s2;
                                profitBeforeInterest.setText( String.valueOf( s3) );
                            }

                            if(!t2[4].getText().toString().equals( "" ))
                            {
                                s4= s3-Integer.parseInt( t2[4].getText().toString());
                                profitBeforeTax.setText( String.valueOf( s4 ) );
                            }
                            else
                            {
                                s4=s3;
                                profitBeforeTax.setText( String.valueOf( s4) );
                            }
                            if(!t2[5].getText().toString().equals( "" ))
                            {
                                s5= s4-Integer.parseInt( t2[5].getText().toString());
                                annualNetprofit.setText( String.valueOf( s5 ) );
                            }
                            else
                            {
                                s5=s4;
                                annualNetprofit.setText( String.valueOf( s5) );
                            }
                        }
                    } );

                }
                //table3
                EditText cash=linearLayout1.findViewById( R.id.cash );
                EditText longLoan=linearLayout1.findViewById( R.id.longLoan );
                EditText receivable=linearLayout1.findViewById( R.id.receivable );
                EditText shortLoan=linearLayout1.findViewById( R.id.shortLoan );
                EditText productInProcess=linearLayout1.findViewById( R.id.productInProcess );
                EditText specialLoan=linearLayout1.findViewById( R.id.specialLoan );
                EditText product=linearLayout1.findViewById( R.id.product );
                EditText tax1=linearLayout1.findViewById( R.id.tax1 );
                EditText material=linearLayout1.findViewById( R.id.material );
                EditText workshop=linearLayout1.findViewById( R.id.workshop );
                EditText equity=linearLayout1.findViewById( R.id.equity );
                EditText equipment=linearLayout1.findViewById( R.id.equipment );
                EditText retainedEarning=linearLayout1.findViewById( R.id.retainedEarning );
                EditText constructionInProcess=linearLayout1.findViewById( R.id.constructionInProcess );
                EditText anualNetProfit=linearLayout1.findViewById( R.id.anualNetProfit );
                final TextView totalDebt=linearLayout1.findViewById( R.id.totalDebt );
                final TextView totalCurrentAsset=linearLayout1.findViewById( R.id.totalCurrentAsset );
                final TextView totalFixedAsset=linearLayout1.findViewById( R.id.totalFixedAsset );
                final TextView totalEquity=linearLayout1.findViewById( R.id.totalEquity );
                final TextView totalAsset=linearLayout1.findViewById( R.id.totalAsset );
                final TextView total1=linearLayout1.findViewById( R.id.total1 );
                final EditText []t3={cash,longLoan,receivable,shortLoan,productInProcess,specialLoan,product,tax1,material,workshop,equity,equipment,retainedEarning,constructionInProcess,anualNetProfit};
                final TextView []u3={totalDebt,totalCurrentAsset,totalFixedAsset,totalEquity,totalAsset,total1};
                final EditText []n1={cash,receivable,productInProcess,product,material};
                final EditText []n2={longLoan,shortLoan,specialLoan,tax1};
                final EditText []n3={workshop,equipment,constructionInProcess};
                final EditText []n4={equity,retainedEarning,anualNetProfit};
                for(int i=0;i<15;i++)
                {
                    t3[i].setOnFocusChangeListener( new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            int s1=0;
                            int s2=0;
                            int s3=0;
                            int s4=0;
                            int s5=0;
                            int s6=0;
                            for(int j=0;j<5;j++)
                            {
                                if(!n1[j].getText().toString().equals( "" ))
                                {
                                    s1=s1+Integer.parseInt( n1[j].getText().toString() );
                                }
                            }
                            totalCurrentAsset.setText( String.valueOf( s2 ) );
                            for(int j=0;j<4;j++)
                            {
                                if(!n2[j].getText().toString().equals( "" ))
                                {
                                    s2=s2+Integer.parseInt( n2[j].getText().toString() );
                                }
                            }
                            totalDebt.setText( String.valueOf( s2 ) );
                            for(int j=0;j<3;j++)
                            {
                                if(!n3[j].getText().toString().equals( "" ))
                                {
                                    s3=s3+Integer.parseInt( n3[j].getText().toString() );
                                }
                            }
                            totalFixedAsset.setText( String.valueOf( s3 ) );
                            for(int j=0;j<3;j++)
                            {
                                if(!n4[j].getText().toString().equals( "" )&&!n4[j].getText().toString().equals( "-" ))
                                {
                                    s4=s4+Integer.parseInt( n4[j].getText().toString() );
                                }
                            }
                            totalEquity.setText( String.valueOf( s4 ) );
                            totalAsset.setText( String.valueOf( s1+s3 ) );
                            total1.setText( String.valueOf( s2+s4 ) );
                        }
                    } );
                }
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
                                int []charge=new int[11];
                                int []profits=new int [10];
                                int []balance=new int [21];
                                for(int i=0;i<10;i++)
                                {
                                    if(t1[i].getText().toString().equals( "" )||t1[i].getText().toString().equals( "0" ))
                                    {
                                        charge[i]=0;
                                    }
                                    else
                                    {
                                        charge[i]=Integer.parseInt( t1[i].getText().toString() );
                                    }
                                }
                                charge[10]=Integer.parseInt( total.getText().toString() );

                                for(int i=0;i<6;i++)
                                {
                                    if(t2[i].getText().toString().equals( "" )||t2[i].getText().toString().equals( "0" ))
                                    {
                                        profits[i]=0;
                                    }
                                    else
                                    {
                                        profits[i]=Integer.parseInt( t2[i].getText().toString() );
                                    }
                                }
                                for(int i=6;i<10;i++)
                                {
                                    profits[i]=Integer.parseInt( u2[i-6].getText().toString());
                                }
                                for(int i=0;i<15;i++)
                                {
                                    if(t3[i].getText().toString().equals( "" )||t3[i].getText().toString().equals( "0" ))
                                    {
                                        balance[i]=0;
                                    }
                                    else
                                    {
                                        balance[i]=Integer.parseInt( t3[i].getText().toString() );
                                    }
                                }
                                for(int i=15;i<21;i++)
                                {
                                    balance[i]=Integer.parseInt( u3[i-15].getText().toString());
                                }
                                HttpUtil.submit( token, charge, profits, balance, new Callback() {
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
                                } );
                                dialog.dismiss();
                               // Toast.makeText( MainActivity.this,"已进行该操作",Toast.LENGTH_SHORT ).show();
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

        //投放广告(success)
        advertising.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(report.getVisibility()==View.GONE) {
                    LinearLayout linearLayout1 = (LinearLayout) getLayoutInflater().inflate( R.layout.advertising, null );
                    EditText local1=linearLayout1.findViewById( R.id.local1 );
                    EditText local2=linearLayout1.findViewById( R.id.local2 );
                    EditText local3=linearLayout1.findViewById( R.id.local3 );
                    EditText local4=linearLayout1.findViewById( R.id.local4 );
                    EditText local5=linearLayout1.findViewById( R.id.local5 );
                    final EditText []local={local1,local2,local3,local4,local5};
                    EditText region1=linearLayout1.findViewById( R.id.region1 );
                    EditText region2=linearLayout1.findViewById( R.id.region2 );
                    EditText region3=linearLayout1.findViewById( R.id.region3 );
                    EditText region4=linearLayout1.findViewById( R.id.region4 );
                    EditText region5=linearLayout1.findViewById( R.id.region5 );
                    final EditText []region={region1,region2,region3,region4,region5};
                    EditText domestic1=linearLayout1.findViewById( R.id.domestic1 );
                    EditText domestic2=linearLayout1.findViewById( R.id.domestic2 );
                    EditText domestic3=linearLayout1.findViewById( R.id.domestic3 );
                    EditText domestic4=linearLayout1.findViewById( R.id.domestic4 );
                    EditText domestic5=linearLayout1.findViewById( R.id.domestic5 );
                    final EditText []domestic={domestic1,domestic2,domestic3,domestic4,domestic5};
                    EditText asia1=linearLayout1.findViewById( R.id.asia1 );
                    EditText asia2=linearLayout1.findViewById( R.id.asia2 );
                    EditText asia3=linearLayout1.findViewById( R.id.asia3 );
                    EditText asia4=linearLayout1.findViewById( R.id.asia4 );
                    EditText asia5=linearLayout1.findViewById( R.id.asia5 );
                    final EditText []asia={asia1,asia2,asia3,asia4,asia5};
                    EditText international1=linearLayout1.findViewById( R.id.international1 );
                    EditText international2=linearLayout1.findViewById( R.id.international2 );
                    EditText international3=linearLayout1.findViewById( R.id.international3 );
                    EditText international4=linearLayout1.findViewById( R.id.international4 );
                    EditText international5=linearLayout1.findViewById( R.id.international5 );
                    final EditText []international={international1,international2,international3,international4,international5};
                    TextView m1=linearLayout1.findViewById( R.id.m1 );
                    TextView m2=linearLayout1.findViewById( R.id.m2 );
                    TextView m3=linearLayout1.findViewById( R.id.m3 );
                    TextView m4=linearLayout1.findViewById( R.id.m4 );
                    TextView m5=linearLayout1.findViewById( R.id.m5 );
                    final TextView []m={m1,m2,m3,m4,m5};
                    final EditText [][]market={local,region,domestic,asia,international};
                    final int []markedId=new int[5];
                    final  int[]productId=new int[5];
                    final int[] x = {0};
                    HttpUtil.developingMarketList( token, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            final String responseData = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    developingMarketBean developingMarket=JSON.parseObject( responseData,developingMarketBean.class);
                                    List<developMarketBean> developMarketList=developingMarket.getData();
                                    if(developingMarket.getResultCode()==500)
                                    {
                                        Toast.makeText( MainActivity.this,developingMarket.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                        setInfo( token );
                                    }
                                    else
                                    {
                                        for(int i=0;i<developMarketList.size();i++)
                                        {
                                            if(developMarketList.get( i ).getDevelopingRemainder()==0&&developMarketList.get( i ).getCreateTime()!=null)
                                            {
                                                markedId[x[0]]=i;
                                                x[0] = x[0] +1;
                                                for(int j=0;j<5;j++)
                                                {
                                                    market[i][j].setEnabled( true );
                                                }
                                                m[i].setTextColor( Color.parseColor( "#000000" ) );
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    } );
                    alertDialog1.setTitle( "投放广告" )
                            .setView( linearLayout1 )
                            .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String s="[";
                                    for(int i=0;i<5;i++)
                                    {
                                        for(int j=0;j<x[0];j++)
                                        {
                                            for(int z=0;z<5;z++)
                                            {
                                                if(market[markedId[j]][z].getText().toString()==null||market[markedId[j]][z].getText().toString().equals( "" )||Integer.parseInt(  market[markedId[j]][z].getText().toString())==0)
                                                {

                                                }
                                                else
                                                {
                                                    if(s.equals( "[" ))
                                                    {
                                                        s=s+"{"+"\"marketId\":"+String.valueOf(  markedId[j]+1)+","+"\"productId\":"+String.valueOf( z+1 )+","+"\"adCost\":"+market[markedId[j]][z].getText().toString()+"}";
                                                    }
                                                    else
                                                    {
                                                        s=s+","+"{"+"\"marketId\":"+String.valueOf(  markedId[j]+1)+","+"\"productId\":"+String.valueOf( z+1 )+","+"\"adCost\":"+market[markedId[j]][z].getText().toString()+"}";
                                                    }
                                                }

                                            }
                                        }
                                    }
                                    s=s+"]";
                                    if(!s.equals( "[]" ))
                                    {
                                        HttpUtil.adSubmit( token, s, new Callback() {
                                            @Override
                                            public void onFailure(Call call, IOException e) {

                                            }

                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                final String responseData = response.body().string();
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        informationBean info=JSON.parseObject( responseData,informationBean.class);
                                                        if(info.getResultCode()==500)
                                                        {
                                                            Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                                        }
                                                    }
                                                });
                                            }
                                        } );
                                    }

                                    dialog.dismiss();
                                    linearLayout.removeAllViews();
                                    linearLayout.addView( view7 );
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
                                            informationBean info=JSON.parseObject( responseData,informationBean.class );
                                            if(info.getResultCode()==500)
                                            {
                                                Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                            }
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
        HttpUtil.disposeList(token,"0",new Callback() {
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

    //厂房处理(未测试)
    private void managefactory(final String token)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.managefactory,null);
        RadioGroup radioGroup=linearLayout1.findViewById( R.id.radioGroup );
        final RadioButton s1=linearLayout1.findViewById( R.id.s1 );
        final RadioButton s2=linearLayout1.findViewById( R.id.s1 );
        final RadioButton s3=linearLayout1.findViewById( R.id.s1 );
        TableRow row1=linearLayout1.findViewById( R.id.row1 );
        TableRow row2=linearLayout1.findViewById( R.id.row2 );
        TableRow row3=linearLayout1.findViewById( R.id.row3 );
        TableRow row4=linearLayout1.findViewById( R.id.row4 );
        final TableRow []r={row1,row2,row3,row4};
        CheckBox c1=linearLayout1.findViewById( R.id.c1 );
        CheckBox c2=linearLayout1.findViewById( R.id.c2 );
        CheckBox c3=linearLayout1.findViewById( R.id.c3 );
        CheckBox c4=linearLayout1.findViewById( R.id.c4 );
        final CheckBox []c={c1,c2,c3,c4};
        TextView name1=linearLayout1.findViewById( R.id.name1 );
        TextView name2=linearLayout1.findViewById( R.id.name2 );
        TextView name3=linearLayout1.findViewById( R.id.name3 );
        TextView name4=linearLayout1.findViewById( R.id.name4 );
        final TextView []name={name1,name2,name3,name4};
        TextView status1=linearLayout1.findViewById( R.id.status1 );
        TextView status2=linearLayout1.findViewById( R.id.status2 );
        TextView status3=linearLayout1.findViewById( R.id.status3 );
        TextView status4=linearLayout1.findViewById( R.id.status4 );
        final TextView []status={status1,status2,status3,status4};
        TextView capacity1=linearLayout1.findViewById( R.id.capacity1 );
        TextView capacity2=linearLayout1.findViewById( R.id.capacity2 );
        TextView capacity3=linearLayout1.findViewById( R.id.capacity3 );
        TextView capacity4=linearLayout1.findViewById( R.id.capacity4 );
        final TextView []capacity={capacity1,capacity2,capacity3,capacity4};
        TextView residualCapacity1=linearLayout1.findViewById( R.id.residualCapacity1 );
        TextView residualCapacity2=linearLayout1.findViewById( R.id.residualCapacity2 );
        TextView residualCapacity3=linearLayout1.findViewById( R.id.residualCapacity3 );
        TextView residualCapacity4=linearLayout1.findViewById( R.id.residualCapacity4 );
        final TextView []residualCapacity={residualCapacity1,residualCapacity2,residualCapacity3,residualCapacity4};
        final String[] type =new String[1];
        final String[] wId=new String[4];
        type[0]="";
        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i=0;i<4;i++)
                {
                    r[i].setVisibility( View.GONE );
                    c[i].setChecked(  false);
                }
                if(checkedId==s1.getId())
                {
                    type[0]="0";
                    HttpUtil.disposeList( token, "0", new Callback() {
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
                                    for(int i=0;i<workshopList.size();i++ )
                                    {
                                        wId[i]=String.valueOf( workshopList.get( i ).getId() );
                                        r[i].setVisibility( View.VISIBLE );
                                        name[i].setText( workshopList.get( i ).getConfigWorkshop().getName()+"("+workshopList.get( i ).getId()+")");
                                        status[i].setText( workshopList.get( i ).getWorkshopStatusDesc() );
                                        capacity[i].setText( String.valueOf( workshopList.get( i ).getConfigWorkshop().getCapacity() ) );
                                        residualCapacity[i].setText( String.valueOf( workshopList.get( i ).getResidualCapacity() ) );
                                    }

                                }
                            } );
                        }
                    } );
                }
                if(checkedId==s2.getId())
                {
                    type[0]="1";
                    HttpUtil.disposeList( token, "1", new Callback() {
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
                                    for(int i=0;i<workshopList.size();i++ )
                                    {
                                        wId[i]=String.valueOf( workshopList.get( i ).getId() );
                                        r[i].setVisibility( View.VISIBLE );
                                        name[i].setText( workshopList.get( i ).getConfigWorkshop().getName()+"("+workshopList.get( i ).getId()+")" );
                                        status[i].setText( workshopList.get( i ).getWorkshopStatusDesc() );
                                        capacity[i].setText( String.valueOf( workshopList.get( i ).getConfigWorkshop().getCapacity() ) );
                                        residualCapacity[i].setText( String.valueOf( workshopList.get( i ).getResidualCapacity() ) );
                                    }

                                }
                            } );
                        }
                    } );
                }
                if(checkedId==s3.getId())
                {
                    type[0]="2";
                    HttpUtil.disposeList( token, "2", new Callback() {
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
                                    for(int i=0;i<workshopList.size();i++ )
                                    {
                                        wId[i]=String.valueOf( workshopList.get( i ).getId() );
                                        r[i].setVisibility( View.VISIBLE );
                                        name[i].setText( workshopList.get( i ).getConfigWorkshop().getName()+"("+workshopList.get( i ).getId()+")" );
                                        status[i].setText( workshopList.get( i ).getWorkshopStatusDesc() );
                                        capacity[i].setText( String.valueOf( workshopList.get( i ).getConfigWorkshop().getCapacity() ) );
                                        residualCapacity[i].setText( String.valueOf( workshopList.get( i ).getResidualCapacity() ) );
                                    }

                                }
                            } );
                        }
                    } );
                }
            }
        } );
        alertDialog.setTitle( "厂房处理" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!type[0].equals( "" ))
                        {
                            String id="";
                            for(int i=0;i<4;i++)
                            {
                                if(c[i].isChecked())
                                {

                                    if(id.equals(""))
                                    {
                                        id=wId[i];
                                    }
                                    else
                                    {
                                        id=id+","+wId[i];
                                    }
                                }
                            }
                            if(!id.equals( "" ))
                            {
                               // Toast.makeText( MainActivity.this,id,Toast.LENGTH_SHORT ).show();
                                HttpUtil.disposeworkshop( token, id, type[0], new Callback() {
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
                                } );
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
    //产品研发(success）
    private void researchproduce(final Button res,final String token)
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LinearLayout linearLayout1=(LinearLayout)getLayoutInflater().inflate( R.layout.researchproduct,null);
        Button allselect=linearLayout1.findViewById( R.id.allselect );
        final CheckBox s1=linearLayout1.findViewById( R.id.s1 );
        final CheckBox s2=linearLayout1.findViewById( R.id.s2 );
        final CheckBox s3=linearLayout1.findViewById( R.id.s3 );
        final CheckBox s4=linearLayout1.findViewById( R.id.s4 );
        final CheckBox s5=linearLayout1.findViewById( R.id.s5 );
        final CheckBox []c={s1,s2,s3,s4,s5};
        TextView time1=linearLayout1.findViewById( R.id.time1 );
        TextView time2=linearLayout1.findViewById( R.id.time2 );
        TextView time3=linearLayout1.findViewById( R.id.time3 );
        TextView time4=linearLayout1.findViewById( R.id.time4 );
        TextView time5=linearLayout1.findViewById( R.id.time5 );
        final TextView []t={time1,time2,time3,time4,time5};
        HttpUtil.developingProductList( token, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread( new Runnable() {
                    @Override
                    public void run() {
                        com.example.erp1.developProduct.developProductBean developProduct=JSON.parseObject( responseData,com.example.erp1.developProduct.developProductBean.class );
                        List<com.example.erp1.developProduct.productBean> productList=developProduct.getData();
                        for(int i=0;i<productList.size();i++)
                        {
                            if(productList.get( i ).getDevelopingRemainder()==0)
                            {
                                c[i].setEnabled( false );
                                t[i].setText( "已研发" );
                            }
                            else if(productList.get( i ).getDevelopingRemainder()==-1)
                            {
                                t[i].setText( "未研发" );
                            }
                            else
                            {
                                t[i].setText( String.valueOf( productList.get( i ).getDevelopingRemainder() ) );
                            }
                        }
                    }
                } );
            }
        } );
        alertDialog.setTitle( "产品研发" )
                .setView(  linearLayout1)
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String pId="";
                        for(int i=0;i<5;i++)
                        {
                            if(c[i].isChecked())
                            {
                                if(pId.equals( "" ))
                                {
                                    pId=String.valueOf( i+1 );
                                }
                                else
                                {
                                    pId=pId+","+String.valueOf( i+1 );
                                }
                            }
                        }
                        HttpUtil.developProduct( token, pId, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String responseData = response.body().string();
                                runOnUiThread( new Runnable() {
                                    @Override
                                    public void run() {
                                        informationBean info=JSON.parseObject( responseData,informationBean.class );
                                        if(info.getResultCode()==500)
                                        {
                                            Toast.makeText( MainActivity.this,info.getResultMessage(),Toast.LENGTH_SHORT ).show();
                                        }
                                        if(info.getResultCode()==200)
                                        {
                                            res.setVisibility( View.GONE );
                                        }
                                    }
                                } );
                            }
                        });
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

    private ArrayAdapter<String> createLine(ArrayAdapter<String> adpter)
    {
        adpter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, list );
        return adpter;

    }
    private void setInfo(String token)
    {

        String url = "http://110.88.128.202:8088/stu/user/info";
        final informationBean[] info = {new informationBean()};
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
                        if(info.getResultCode()==200)
                        {
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
                                if(developMarketBeanList.get( i ).getDevelopingRemainder()==0)
                                {
                                    s=s+developMarketBeanList.get( i ).getConfigMarket().getName()+" ";
//                                SpannableString spannableString =new SpannableString(s);
//                                spannableString.setSpan( new ForegroundColorSpan( Color.parseColor( "#992424" ) ), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                                    markets[developMarketBeanList.get( i ).getMarketId()-1].setText( "已开拓" );
                                }
                                else
                                {
                                    j=j+1;
                                    String m="剩余"+developMarketBeanList.get( i ).getDevelopingRemainder()+"年";
                                    markets[developMarketBeanList.get( i ).getMarketId()-1].setText( m );
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
                            iso1.setText( "未认证" );
                            iso2.setText( "未认证" );
                            List<developIsoBean> developIsoBeanList=info.getData().getDevelopIso();
                            int z=0;
                            String isomessage="";
                            for(int i=0;i<developIsoBeanList.size();i++)
                            {
                                if(developIsoBeanList.get( i ).getDevelopingRemainder()==0)
                                {
                                    isomessage=isomessage+developIsoBeanList.get( i ).getConfigIso().getName()+" ";
                                    isos[developIsoBeanList.get( i ).getIsoId()-1].setText( "已认证" );

                                }
                                else
                                {
                                    String m="剩余"+developIsoBeanList.get( i ).getDevelopingRemainder()+"年";
                                    isos[developIsoBeanList.get( i ).getIsoId()-1].setText( m);
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
                                x=developProductBeanList.get( i ).getProductId()-1;
                                if(developProductBeanList.get( i ).getDevelopingRemainder()==0)
                                {
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
                                int x=materialBeanList.get( i ).getMaterialId()-1;
                                rs[x].setText(Integer.toString(  materialBeanList.get( i ).getInventoryNum() ) );
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
                        else
                        {
                            Toast.makeText( MainActivity.this,"用户信息过期，请重新登录",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent( MainActivity.this,SigninActivity.class );
                            startActivity( intent );
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