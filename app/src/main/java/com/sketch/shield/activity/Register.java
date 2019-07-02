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

public class Register extends AppCompatActivity
        implements View.OnClickListener {

    RelativeLayout rel_register, rel_login;
    EditText edt_name, edt_email, edt_phone, edt_complex, edt_flat_no,
            edt_password, edt_confirm_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),
                    R.color.colorPrimaryDark));
        }

        initViews();


    }

    private void initViews(){

        rel_register = findViewById(R.id.rel_register);
        rel_login = findViewById(R.id.rel_login);

        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);
        edt_complex = findViewById(R.id.edt_complex);
        edt_flat_no = findViewById(R.id.edt_flat_no);
        edt_password = findViewById(R.id.edt_password);
        edt_confirm_password = findViewById(R.id.edt_confirm_password);


        rel_register.setOnClickListener(this);
        rel_login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.rel_register:



                break;

            case R.id.rel_login:

                finish();

                break;

        }

    }




}
