package com.example.erp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.CaptivePortal;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_help );
        Button back=(Button)findViewById( R.id.back );
        final Button rule=(Button)findViewById( R.id.rule );
        final Button market=(Button)findViewById( R.id.market );
        Button guide=(Button)findViewById( R.id.guide );
        Button knowledge=(Button)findViewById( R.id.knowledge );
        final Button []list={rule,market,guide,knowledge};
        final LinearLayout linearLayout=(LinearLayout)findViewById( R.id.page );
        final Intent intent = getIntent();
        final String name = intent.getStringExtra( "name" );
//        for(int i=0;i<4;i++)
//        {
//            final int finalI = i;
//            list[i].setOnClickListener( new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(finalI ==0)
//                    {
//                        textView.setText( "" );
//                        textView.setMovementMethod( ScrollingMovementMethod.getInstance());
//                        textView.setHorizontallyScrolling(true); // 不让超出屏幕的文本自动换行，使用滚动
//                        textView.setFocusable(true);
//                        Intent intent=new Intent( Intent.ACTION_VIEW );
//                        intent.setData( Uri.parse("http://110.88.128.202:8080/sandbox/help/index.html") );
//                        startActivity( intent );
//                        linearLayout.addView( tableLayout );
//                    }
//                }
//            } );
//        }
        rule.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<=3;i++)
                {
                    list[i].setBackgroundColor( Color.parseColor( "#ffffff" ) );
                }
                rule.setBackgroundColor( Color.parseColor( "#707274" ) );
                View view=getLayoutInflater().inflate(R.layout.rule,null);
                linearLayout.removeAllViews();
                linearLayout.addView( view);
            }
        } );
        market.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<=3;i++)
                {
                    list[i].setBackgroundColor(Color.parseColor("#ffffff"));
                }
                market.setBackgroundColor( Color.parseColor( "#707274" ) );
                linearLayout.removeAllViews();
            }
        } );
        guide.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeAllViews();
            }
        } );
        knowledge.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeAllViews();
            }
        } );
        back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( HelpActivity.this,MainActivity.class );
                intent.putExtra("name",name);
                startActivity( intent );
            }
        } );
    }
}
