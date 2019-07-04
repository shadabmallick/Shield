package com.sketch.shield.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.sketch.shield.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddVisitor extends AppCompatActivity
        implements View.OnClickListener {

    RelativeLayout rel_back;
    EditText edt_name, edt_phone, edt_flat_no, edt_purpose, edt_date_time, edt_person_to_meet;
    CircleImageView iv_user;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_visitor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),
                    R.color.colorPrimaryDark));
        }

        initViews();


    }

    private void initViews(){

        rel_back = findViewById(R.id.rel_back);
        iv_user = findViewById(R.id.iv_user);

        edt_name = findViewById(R.id.edt_name);
        edt_phone = findViewById(R.id.edt_phone);
        edt_flat_no = findViewById(R.id.edt_flat_no);
        edt_purpose = findViewById(R.id.edt_purpose);
        edt_date_time = findViewById(R.id.edt_date_time);
        edt_person_to_meet = findViewById(R.id.edt_person_to_meet);

        btn_submit = findViewById(R.id.btn_submit);


        rel_back.setOnClickListener(this);
        btn_submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.rel_back:

                finish();

                break;

            case R.id.btn_submit:

                finish();

                break;

        }

    }




}
