package com.sketch.shield.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.sketch.shield.R;
import com.sketch.shield.adapters.CategoryAdapter;
import com.sketch.shield.dataModel.CategoryData;
import com.sketch.shield.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SelectCategory extends AppCompatActivity
        implements View.OnClickListener, CategoryAdapter.onItemClickListner {

    RelativeLayout rel_back;
    RecyclerView recycler_category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_category);
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
        recycler_category = findViewById(R.id.recycler_category);

        int numberOfColumns = 2;
        recycler_category.setLayoutManager(new GridLayoutManager(this, numberOfColumns));


        int spanCount = 2;
        int spacing = 10;
        boolean includeEdge = true;
        recycler_category.addItemDecoration(
                new GridSpacingItemDecoration(spanCount, spacing, includeEdge));



        rel_back.setOnClickListener(this);


        ArrayList<CategoryData> dataArrayList = new ArrayList<>();
        dataArrayList.add(new CategoryData());
        dataArrayList.add(new CategoryData());
        dataArrayList.add(new CategoryData());
        dataArrayList.add(new CategoryData());
        dataArrayList.add(new CategoryData());
        dataArrayList.add(new CategoryData());
        dataArrayList.add(new CategoryData());

        CategoryAdapter categoryAdapter =
                new CategoryAdapter(SelectCategory.this, dataArrayList, this);
        recycler_category.setAdapter(categoryAdapter);


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

        Intent intent = new Intent(SelectCategory.this, TypeList.class);
        startActivity(intent);

    }
}
