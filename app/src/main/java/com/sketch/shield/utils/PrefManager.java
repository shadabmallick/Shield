package com.sketch.shield.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


/**
 * Created by Shadab Mallick on 06/03/19.
 */

public class PrefManager {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    SharedPreferences sharedPreferences2;
    SharedPreferences.Editor editor2;



    GlobalClass globalclass;
    private boolean pref_logInStatus;
    private String pref_name;
    private String pref_fname;
    private String pref_lname;
    private String pref_id;
    private String schoolname;
    private String pref_email;
    private String pref_phone_number;
    private String pref_order_id;
    private String pref_order_type;
    private String pref_business;
    private String pref_user_type;
    private String pref_profile_img;
    private String pref_shipping_address;
    private String pref_cart_no;
    private String pref_ship_address_id;
    private String pref_ship_full_address;
    private String pref_organisation;
    private  String unique_name;
    private  String main_access_group_id;
    private  String sub_access_group_id;
    private String type;
    private String first_login;
    private  String notification;
    private String latitude;
    private  String longitude;
    private  String location;



    private String remote_user_id;

    private String fcm;
    private String login_from;


    private static final String PREFS_NAME = "preferences";
    private static final String PREFS_NAME2 = "preferences2";

    private static final String PREF_logInStatus = "logInStatus";
    private static final String PREF_name = "name";
    private static final String PREF_fname = "fname";
    private static final String PREF_lname = "lname";
    private static final String PREF_schoolname = "schoolname";
    private static final String PREF_email = "user_email";
    private static final String PREF_phone_number = "phone_number";
    private static final String PREF_user_type = "user_type";
    private static final String PREF_business = "business";
    private static final String PREF_id = "id";
    private static final String PREF_profile_img = "profile_img";
    private static final String PREF_cart_no = "cart_no";
    private static final String PREF_ship_address_id = "ship_address_id";
    private static final String PREF_ship_full_address = "ship_full_address";
    private static final String PREF_login_from = "login_from";
    private static final String PREF_organisation = "organisation";
    private static final String PREF_order_id = "order_id";
    private static final String PREF_order_type = "ordertype";
    private static final String remote = "remote_id";
    private static final String PREF_unique_name = "unique_name";
    private static final String PREF_main_access_group_id = "main_access_group_id";
    private static final String PREF_sub_access_group_id = "sub_access_group_id";
    private static final String PREF_type = "type";
    private static final String PREF_first_login = "first_login";
    private static final String PREF_notification = "notification";
    private static final String PREF_latitude = "latitude";
    private static final String PREF_longitude = "longitude";
    private static final String PREF_location = "location";




    public PrefManager(Context context) {
        this.context = context;

        this.globalclass = (GlobalClass) context.getApplicationContext();
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();

        this.sharedPreferences2 = context.getSharedPreferences(PREFS_NAME2, Context.MODE_PRIVATE);
        this.editor2 = sharedPreferences2.edit();



    }



    public void clearPrefrence(){

        editor.clear();
        editor.commit();


    }













}
