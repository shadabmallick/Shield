package com.sketch.shield.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.activity.AddCar;
import com.sketch.shield.adapters.CarListAdapter;
import com.sketch.shield.dataModel.CarData;

import java.util.ArrayList;


public class Car extends Fragment implements CarListAdapter.onItemClickListner {

    TextView toolbar_title;
    RecyclerView recycler_vendor;

    ProgressDialog pd;

    public Car() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_vendor, container, false);

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

        recycler_vendor = view.findViewById(R.id.recycler_vendor);
        recycler_vendor.setLayoutManager(new LinearLayoutManager(getActivity()));


        ArrayList<CarData> carDataArrayList = new ArrayList<>();
        carDataArrayList.add(new CarData());
        carDataArrayList.add(new CarData());
        carDataArrayList.add(new CarData());
        carDataArrayList.add(new CarData());
        carDataArrayList.add(new CarData());


        CarListAdapter visitorAdapter = new CarListAdapter(getActivity(),
                carDataArrayList, this);
        recycler_vendor.setAdapter(visitorAdapter);


        toolbar_title.setText("Car ("+carDataArrayList.size()+")");
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_vendor, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.add_user:

                Intent intent = new Intent(getActivity(), AddCar.class);
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
