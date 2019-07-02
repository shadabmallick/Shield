package com.sketch.shield.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.sketch.shield.R;

public class Login extends AppCompatActivity
        implements View.OnClickListener {

    RelativeLayout rel_register, rel_login, rel_forgot_password;
    EditText edt_phone, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
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
        rel_forgot_password = findViewById(R.id.rel_forgot_password);
        edt_phone = findViewById(R.id.edt_phone);
        edt_password = findViewById(R.id.edt_password);


        rel_register.setOnClickListener(this);
        rel_login.setOnClickListener(this);
        rel_forgot_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()){

            case R.id.rel_register:

                intent = new Intent(Login.this, Register.class);
                startActivity(intent);

                break;

            case R.id.rel_login:

                break;

            case R.id.rel_forgot_password:

                intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);

                break;
        }

    }




}
