package com.sketch.shield.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.dataModel.CategoryData;
import com.sketch.shield.dataModel.VisitorData;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<CategoryData> dataArrayList;


    private onItemClickListner mListner;
    public interface onItemClickListner{
        void onItemClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv_2char;
        ImageView iv_call;
        LinearLayout linear_main;
        onItemClickListner listner;

        public ItemViewHolder(View itemView, onItemClickListner listner) {
            super(itemView);

            linear_main = itemView.findViewById(R.id.linear_main);

            this.listner = listner;
        }
    }


    public CategoryAdapter(Context context, ArrayList<CategoryData> itemList,
                           onItemClickListner listner){

        this.context = context;
        this.dataArrayList=itemList;
        this.mListner=listner;



    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent,false);
        ItemViewHolder dvh = new ItemViewHolder(v, mListner);
        return dvh;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {




        holder.linear_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListner.onItemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

}
