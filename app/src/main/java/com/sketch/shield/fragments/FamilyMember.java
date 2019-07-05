package com.sketch.shield.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.sketch.shield.activity.AddFamilyMember;
import com.sketch.shield.activity.AddStaff;
import com.sketch.shield.activity.SelectCategory;
import com.sketch.shield.adapters.FamilyMemberAdapter;
import com.sketch.shield.adapters.StaffAdapter;
import com.sketch.shield.dataModel.FamilyMemberData;
import com.sketch.shield.dataModel.VendorData;

import java.util.ArrayList;


public class FamilyMember extends Fragment implements FamilyMemberAdapter.onItemClickListner {

    TextView toolbar_title, tv_user_name;
    RecyclerView recycler_vendor;

    ProgressDialog pd;

    public FamilyMember() {
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

        tv_user_name = view.findViewById(R.id.tv_user_name);
        recycler_vendor = view.findViewById(R.id.recycler_vendor);
        recycler_vendor.setLayoutManager(new LinearLayoutManager(getActivity()));


        ArrayList<FamilyMemberData> familyMemberDataArrayList = new ArrayList<>();
        familyMemberDataArrayList.add(new FamilyMemberData());
        familyMemberDataArrayList.add(new FamilyMemberData());
        familyMemberDataArrayList.add(new FamilyMemberData());
        familyMemberDataArrayList.add(new FamilyMemberData());
        familyMemberDataArrayList.add(new FamilyMemberData());


        FamilyMemberAdapter visitorAdapter = new FamilyMemberAdapter(getActivity(),
                familyMemberDataArrayList, this);
        recycler_vendor.setAdapter(visitorAdapter);


        toolbar_title.setText("Family Members ("+familyMemberDataArrayList.size()+")");
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

                Intent intent = new Intent(getActivity(), AddFamilyMember.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onItemClick(int position) {

    }


    private void dialogAddVendor(){

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_add_vendor, null);
        alert.setView(alertLayout);

        TextView tv_add_new = alertLayout.findViewById(R.id.tv_add_new);
        TextView tv_category = alertLayout.findViewById(R.id.tv_category);


        final AlertDialog dialog = alert.create();
        dialog.show();


        tv_add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AddStaff.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        tv_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SelectCategory.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });




    }
}
