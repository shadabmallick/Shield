package com.sketch.shield.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.adapters.DrawerListAdapter;
import com.sketch.shield.dataModel.DrawerItem;
import com.sketch.shield.fragments.Car;
import com.sketch.shield.fragments.FamilyMember;
import com.sketch.shield.fragments.Home;
import com.sketch.shield.fragments.Staff;
import com.sketch.shield.fragments.Vendor;
import com.sketch.shield.fragments.Visitors;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Container extends AppCompatActivity implements
        DrawerListAdapter.onItemClickListner {

    DrawerLayout drawer;
    RecyclerView nav_drawer_recycler_view;
    CircleImageView iv_user;
    RelativeLayout rel_profile;
    TextView toolbar_title, tv_name, tv_complex, tv_flat_no;

    private FragmentManager mFragmentManager;
    Toolbar toolbar;

    ArrayList<DrawerItem> drawerItemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.container);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),
                    R.color.colorPrimaryDark));
        }

        initViews();


    }

    private void initViews(){

        toolbar  = findViewById(R.id.toolbar);
        toolbar_title  = findViewById(R.id.toolbar_title);
        tv_name  = findViewById(R.id.tv_name);
        tv_complex  = findViewById(R.id.tv_complex);
        tv_flat_no  = findViewById(R.id.tv_flat_no);
        setSupportActionBar(toolbar);
        toolbar_title.setText("Home");


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(false);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),
                R.mipmap.drawer_menu, getApplicationContext().getTheme());
        toggle.setHomeAsUpIndicator(drawable);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });



        NavigationView navigationView = findViewById(R.id.nav_view);
        nav_drawer_recycler_view = findViewById(R.id.nav_drawer_recycler_view);
        nav_drawer_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        mFragmentManager = getSupportFragmentManager();

        initNavigationItems();

        transactFragment(new Home());



    }



    public void initNavigationItems(){

        String[] drawer_items = getResources().getStringArray(R.array.drawer_items);

        ArrayList<Integer> myImageList = new ArrayList<>();
        myImageList.add(R.mipmap.home_white);
        myImageList.add(R.mipmap.visitor_white);
        myImageList.add(R.mipmap.vendor_white);
        myImageList.add(R.mipmap.staff_white);
        myImageList.add(R.mipmap.staff_white);
        myImageList.add(R.mipmap.car_white);
        myImageList.add(R.mipmap.user_white);
        myImageList.add(R.mipmap.staff_white);
        myImageList.add(R.mipmap.staff_white);
        myImageList.add(R.mipmap.notify_gate_white);
        myImageList.add(R.mipmap.help_white);
        myImageList.add(R.mipmap.security_white);
        myImageList.add(R.mipmap.settings_white);
        myImageList.add(R.mipmap.logout_white);

        drawerItemArrayList = new ArrayList<>();
        DrawerItem drawerItem;

        for (int i = 0; i < drawer_items.length; i++){
            drawerItem = new DrawerItem();

            drawerItem.setImgResID(myImageList.get(i));
            drawerItem.setTitle(drawer_items[i]);
            drawerItemArrayList.add(drawerItem);

        }


        DrawerListAdapter drawerListAdapter =
                new DrawerListAdapter(Container.this, drawerItemArrayList, this);
        nav_drawer_recycler_view.setAdapter(drawerListAdapter);

    }

    @Override
    public void onItemClick(int position) {

        switch (position){

            case 0:

                toolbar_title.setText(drawerItemArrayList.get(position).getTitle());
                transactFragment(new Home());

                break;

            case 1:

                toolbar_title.setText(drawerItemArrayList.get(position).getTitle());
                transactFragment(new Visitors());

                break;

            case 2:

                toolbar_title.setText(drawerItemArrayList.get(position).getTitle());
                transactFragment(new Vendor());

                break;

            case 3:

                toolbar_title.setText(drawerItemArrayList.get(position).getTitle());
                transactFragment(new Staff());

                break;

            case 4:

                toolbar_title.setText(drawerItemArrayList.get(position).getTitle());
                transactFragment(new FamilyMember());

                break;

            case 5:

                toolbar_title.setText(drawerItemArrayList.get(position).getTitle());
                transactFragment(new Car());

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

                break;

            case 10:

                break;

            case 11:

                break;

            case 12:

                break;

            case 13:

                break;



        }



    }


    private void changeActivity(final Intent intent){

        if (intent != null){

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(intent);

                }
            }, 300);

        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                drawer.closeDrawer(GravityCompat.START);

            }
        }, 150);

    }


    private void transactFragment(final Fragment fragment){

        if (fragment != null) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    FragmentTransaction ft = mFragmentManager.beginTransaction();
                    ft.replace(R.id.flContent, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();

                }
            }, 300);

        }

        drawer.closeDrawer(GravityCompat.START);

    }






}
