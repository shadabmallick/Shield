package com.sketch.shield.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sketch.shield.R;
import com.sketch.shield.dataModel.FeedsData;

import java.util.ArrayList;

public class HomeFeedsAdapter extends
        RecyclerView.Adapter<HomeFeedsAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<FeedsData> dataArrayList;


    private onItemClickListner mListner;
    public interface onItemClickListner{
        void onItemClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_msg, tv_show_more;
        onItemClickListner listner;

        public ItemViewHolder(View itemView, onItemClickListner listner) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_msg = itemView.findViewById(R.id.tv_msg);
            tv_show_more = itemView.findViewById(R.id.tv_show_more);
            this.listner = listner;
        }
    }


    public HomeFeedsAdapter(Context context, ArrayList<FeedsData> itemList,
                            onItemClickListner listner){

        this.context = context;
        this.dataArrayList=itemList;
        this.mListner=listner;



    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_feeds_item, parent,false);
        ItemViewHolder dvh = new ItemViewHolder(v, mListner);
        return dvh;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        FeedsData feedsData = dataArrayList.get(position);




    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

}
