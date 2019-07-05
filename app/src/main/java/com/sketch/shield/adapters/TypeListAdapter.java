package com.sketch.shield.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.dataModel.VendorData;
import com.sketch.shield.dataModel.VendorTypeData;

import java.util.ArrayList;

public class TypeListAdapter extends
        RecyclerView.Adapter<TypeListAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<VendorTypeData> dataArrayList;


    private onItemClickListner mListner;
    public interface onItemClickListner{
        void onItemClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv_2char, tv_name, tv_designation;
        ImageView iv_call;
        RelativeLayout rel_add_mylist;
        onItemClickListner listner;

        public ItemViewHolder(View itemView, onItemClickListner listner) {
            super(itemView);
            tv_2char = itemView.findViewById(R.id.tv_2char);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_designation = itemView.findViewById(R.id.tv_designation);
            iv_call = itemView.findViewById(R.id.iv_call);
            rel_add_mylist = itemView.findViewById(R.id.rel_add_mylist);
            this.listner = listner;
        }
    }


    public TypeListAdapter(Context context, ArrayList<VendorTypeData> itemList,
                           onItemClickListner listner){

        this.context = context;
        this.dataArrayList=itemList;
        this.mListner=listner;



    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vendor_type_list_item, parent,false);
        ItemViewHolder dvh = new ItemViewHolder(v, mListner);
        return dvh;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {





    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

}
