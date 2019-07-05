package com.sketch.shield.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.dataModel.VendorData;
import com.sketch.shield.dataModel.VisitorData;

import java.util.ArrayList;

public class VendorAdapter extends
        RecyclerView.Adapter<VendorAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<VendorData> dataArrayList;


    private onItemClickListner mListner;
    public interface onItemClickListner{
        void onItemClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv_2char, tv_name, tv_designation, tv_history, tv_remove;
        ImageView iv_call;
        onItemClickListner listner;

        public ItemViewHolder(View itemView, onItemClickListner listner) {
            super(itemView);
            tv_2char = itemView.findViewById(R.id.tv_2char);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_designation = itemView.findViewById(R.id.tv_designation);
            tv_history = itemView.findViewById(R.id.tv_history);
            tv_remove = itemView.findViewById(R.id.tv_remove);
            iv_call = itemView.findViewById(R.id.iv_call);
            this.listner = listner;
        }
    }


    public VendorAdapter(Context context, ArrayList<VendorData> itemList,
                         onItemClickListner listner){

        this.context = context;
        this.dataArrayList=itemList;
        this.mListner=listner;



    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vendor_list_item, parent,false);
        ItemViewHolder dvh = new ItemViewHolder(v, mListner);
        return dvh;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        VendorData vendorData = dataArrayList.get(position);




    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

}
