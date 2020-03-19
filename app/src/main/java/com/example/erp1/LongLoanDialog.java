package com.example.erp1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LongLoanDialog extends Dialog {
    private Context mContext;
    private Button buttonConfirm;
    private String message;

    public LongLoanDialog(@NonNull Context context) {
        super( context );
    }

    public LongLoanDialog(Context context, int themeResId) {
        super( context, themeResId );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.longloan );
        setCanceledOnTouchOutside( false );

    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = 600;
        layoutParams.height = 500;
        layoutParams.gravity = Gravity.CENTER;
        getWindow().getDecorView().setPadding( 0, 0, 0, 0 );
        getWindow().setAttributes( layoutParams );
    }


    private void initView() {
        buttonConfirm = findViewById( R.id.yes );
        buttonConfirm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        } );
    }

    //内部接口
    public interface MyOnclickListener {
        public void onYesClick(String message);
    }

    //set内部接口和String参数
    public void setMyOnclickListener(String message, MyOnclickListener myOnclickListener) {
        this.message = message;
    }
}
