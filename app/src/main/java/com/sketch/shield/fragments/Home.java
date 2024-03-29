package com.sketch.shield.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.adapters.HomeFeedsAdapter;
import com.sketch.shield.dataModel.FeedsData;

import java.util.ArrayList;


public class Home extends Fragment implements HomeFeedsAdapter.onItemClickListner {

    TextView tv_user_name;
    RecyclerView recycler_feeds;

    ProgressDialog pd;


    public Home() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        setHasOptionsMenu(true);
        pd = new ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage("Loading...");

        initialisation(view);
        bottomViews(view);


        return view;
    }

    private void initialisation(View view) {


        tv_user_name = view.findViewById(R.id.tv_user_name);
        recycler_feeds = view.findViewById(R.id.recycler_feeds);
        recycler_feeds.setLayoutManager(new LinearLayoutManager(getActivity()));


        ArrayList<FeedsData> feedsDataArrayList = new ArrayList<>();
        feedsDataArrayList.add(new FeedsData());
        feedsDataArrayList.add(new FeedsData());
        feedsDataArrayList.add(new FeedsData());
        feedsDataArrayList.add(new FeedsData());
        feedsDataArrayList.add(new FeedsData());


        HomeFeedsAdapter homeFeedsAdapter = new HomeFeedsAdapter(getActivity(),
                feedsDataArrayList, this);
        recycler_feeds.setAdapter(homeFeedsAdapter);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.settings:


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void bottomViews(View view){

        RelativeLayout rel_notification = view.findViewById(R.id.rel_notification);
        RelativeLayout rel_help = view.findViewById(R.id.rel_help);
        RelativeLayout rel_visitors = view.findViewById(R.id.rel_visitors);
        RelativeLayout rel_alert = view.findViewById(R.id.rel_alert);

        rel_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rel_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rel_visitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rel_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }
}
