package com.sketch.shield.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.sketch.shield.R;

public class WelcomeScreen extends AppCompatActivity {

    CardView cardview_add_residence, cardview_add_family_members, cardview_add_vendor,
            cardview_add_staff, cardview_add_car;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),
                    R.color.colorPrimaryDark));
        }

        initViews();


    }

    private void initViews(){

        cardview_add_residence = findViewById(R.id.cardview_add_residence);
        cardview_add_family_members = findViewById(R.id.cardview_add_family_members);
        cardview_add_vendor = findViewById(R.id.cardview_add_vendor);
        cardview_add_staff = findViewById(R.id.cardview_add_staff);
        cardview_add_car = findViewById(R.id.cardview_add_car);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.settings:


                break;

            case R.id.home:

                Intent intent = new Intent(WelcomeScreen.this, Container.class);
                startActivity(intent);

                break;


        }

        return true;
    }
}
