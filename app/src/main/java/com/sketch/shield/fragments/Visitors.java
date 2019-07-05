package com.sketch.shield.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.activity.AddVisitor;
import com.sketch.shield.adapters.HomeFeedsAdapter;
import com.sketch.shield.adapters.VisitorAdapter;
import com.sketch.shield.dataModel.FeedsData;
import com.sketch.shield.dataModel.VisitorData;

import java.util.ArrayList;


public class Visitors extends Fragment implements VisitorAdapter.onItemClickListner {

    TextView toolbar_title, tv_user_name;
    RecyclerView recycler_visitor;

    ProgressDialog pd;

    public Visitors() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_visitor, container, false);

        pd = new ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage("Loading...");

        initialisation(view);


        setHasOptionsMenu(true);

        return view;
    }

    private void initialisation(View view) {

        toolbar_title = getActivity().findViewById(R.id.toolbar_title);


        tv_user_name = view.findViewById(R.id.tv_user_name);
        recycler_visitor = view.findViewById(R.id.recycler_visitor);
        recycler_visitor.setLayoutManager(new LinearLayoutManager(getActivity()));


        ArrayList<VisitorData> feedsDataArrayList = new ArrayList<>();
        feedsDataArrayList.add(new VisitorData());
        feedsDataArrayList.add(new VisitorData());
        feedsDataArrayList.add(new VisitorData());
        feedsDataArrayList.add(new VisitorData());
        feedsDataArrayList.add(new VisitorData());


        VisitorAdapter visitorAdapter = new VisitorAdapter(getActivity(),
                feedsDataArrayList, this);
        recycler_visitor.setAdapter(visitorAdapter);


        toolbar_title.setText("Visitor ("+feedsDataArrayList.size()+")");
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_visitors, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.add_user:

                Intent intent = new Intent(getActivity(), AddVisitor.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onItemClick(int position) {

    }
}
