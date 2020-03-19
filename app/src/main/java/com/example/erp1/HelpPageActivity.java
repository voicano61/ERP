package com.example.erp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelpPageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_help_page );
        final Intent intent = getIntent();
        final String name = intent.getStringExtra( "name" );
        final Button rule=(Button)findViewById( R.id.rule );
        final Button market=(Button)findViewById( R.id.market );
        final Button back=(Button)findViewById( R.id.back );
        final Button guide=(Button)findViewById( R.id.guide );
        final Button knowledge=(Button)findViewById( R.id.knowledge );
        final Button []list={rule,market,guide,knowledge};
        back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  finish();
//                Intent intent=new Intent( HelpPageActivity.this,MainActivity.class);
//                intent.putExtra( "name",name);
//                startActivity( intent );
            }
        } );
        rule.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for (int i=0;i<=3;i++)
//                {
//                    //list[i].setBackgroundColor(getResources().getColor( android.R.color.holo_orange_light ));
//                }
//                rule.setBackgroundColor( Color.parseColor( "#707274" ) );
                for(int i=0;i<=3;i++)
                {
                    list[i].setTextColor( Color.parseColor( "#000000" ));
                }
                rule.setTextColor( Color.parseColor( "#992424" ));
                replaceFragment( new RuleRightFragment() );
            }
        } );
        market.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for (int i=0;i<=3;i++)
//                {
//                    list[i].setBackground(null);
//                    //list[i].setBackgroundColor(getResources().getColor( android.R.color.holo_orange_light ));
//                }
//                market.setBackgroundColor( Color.parseColor( "#707274" ) );
//                replaceFragment( new RuleRightFragment() );
                for(int i=0;i<=3;i++)
                {
                    list[i].setTextColor( Color.parseColor( "#000000" ));
                }
                market.setTextColor( Color.parseColor( "#992424" ));
                replaceFragment( new MarketRightFragment() );
            }
        } );
        guide.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<=3;i++)
                {
                    list[i].setTextColor( Color.parseColor( "#000000" ));
                }
                guide.setTextColor( Color.parseColor( "#992424" ));
            }
        } );
        knowledge.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent( Intent.ACTION_VIEW );
//                intent.setData( Uri.parse("http://110.88.128.202:8080/sandbox/help/index.html") );
//                startActivity( intent);
                for(int i=0;i<=3;i++)
                {
                    list[i].setTextColor( Color.parseColor( "#000000" ));
                }
                knowledge.setTextColor( Color.parseColor( "#992424" ));
            }
        } );
    replaceFragment( new RightFragment() );

}
    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace( R.id.right_layout,fragment );
        transaction.addToBackStack( null );
        transaction.commit();
    }

}
