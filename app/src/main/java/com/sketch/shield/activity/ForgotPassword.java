package com.sketch.shield.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.sketch.shield.R;

public class ForgotPassword extends AppCompatActivity
        implements View.OnClickListener {

    RelativeLayout rel_submit;
    EditText edt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),
                    R.color.colorPrimaryDark));
        }

        initViews();


    }

    private void initViews(){

        rel_submit = findViewById(R.id.rel_submit);
        edt_phone = findViewById(R.id.edt_phone);


        rel_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.rel_submit:

                Intent intent = new Intent(ForgotPassword.this, RenewPassword.class);
                startActivity(intent);
                finish();

                break;
        }

    }




}
