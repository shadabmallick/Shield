package com.sketch.shield.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.dataModel.CarData;
import com.sketch.shield.dataModel.FamilyMemberData;

import java.util.ArrayList;

public class CarListAdapter extends
        RecyclerView.Adapter<CarListAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<CarData> dataArrayList;


    private onItemClickListner mListner;
    public interface onItemClickListner{
        void onItemClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv_2char, tv_car_name_color, tv_car_no, tv_remove;
        onItemClickListner listner;

        public ItemViewHolder(View itemView, onItemClickListner listner) {
            super(itemView);
            tv_2char = itemView.findViewById(R.id.tv_2char);
            tv_car_name_color = itemView.findViewById(R.id.tv_car_name_color);
            tv_car_no = itemView.findViewById(R.id.tv_car_no);
            tv_remove = itemView.findViewById(R.id.tv_remove);

            this.listner = listner;
        }
    }


    public CarListAdapter(Context context, ArrayList<CarData> itemList,
                          onItemClickListner listner){

        this.context = context;
        this.dataArrayList=itemList;
        this.mListner=listner;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_list_item, parent,false);
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
