package com.sketch.shield.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.sketch.shield.R;
import com.sketch.shield.adapters.CategoryAdapter;
import com.sketch.shield.adapters.TypeListAdapter;
import com.sketch.shield.dataModel.CategoryData;
import com.sketch.shield.dataModel.VendorTypeData;
import com.sketch.shield.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

public class TypeList extends AppCompatActivity
        implements View.OnClickListener, TypeListAdapter.onItemClickListner {

    RelativeLayout rel_back;
    RecyclerView recycler_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_list_screen);
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
        recycler_type = findViewById(R.id.recycler_type);
        recycler_type.setLayoutManager(new LinearLayoutManager(this));


        rel_back.setOnClickListener(this);


        ArrayList<VendorTypeData> dataArrayList = new ArrayList<>();
        dataArrayList.add(new VendorTypeData());
        dataArrayList.add(new VendorTypeData());
        dataArrayList.add(new VendorTypeData());
        dataArrayList.add(new VendorTypeData());
        dataArrayList.add(new VendorTypeData());
        dataArrayList.add(new VendorTypeData());
        dataArrayList.add(new VendorTypeData());

        TypeListAdapter typeListAdapter =
                new TypeListAdapter(TypeList.this, dataArrayList, this);
        recycler_type.setAdapter(typeListAdapter);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.rel_back:

                finish();

                break;

        }

    }

    @Override
    public void onItemClick(int position) {

    }
}
