package com.example.gowsik.working.recyclerview;

import android.content.ClipData;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gowsik.working.R;

import java.util.List;

/**
 * Created by gowsik on 26-04-2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    public List<Items> itemsList;
    public RecycleViewListener recycleViewListener;
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View views= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ItemHolder(views);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ItemHolder holder,final int position) {
        holder.title.setText((itemsList.get(position)).getTitle());
        holder.className.setText((itemsList.get(position)).getClass_name());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleViewListener.setOnRecycleViewListener((itemsList.get(position)).getTitle(),(itemsList.get(position)).getClass_name());
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("Item Size ",""+itemsList.size());
        return itemsList.size();
    }

    public ItemAdapter (List<Items> itemsList,RecycleViewListener recycleViewListener){
        this.itemsList=itemsList;
        this.recycleViewListener=recycleViewListener;
    }
    public class ItemHolder extends RecyclerView.ViewHolder{

        public TextView title,className;
        public LinearLayout linearLayout;
        public ItemHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            className=(TextView)itemView.findViewById(R.id.name);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.item_container);
        }
    }
}
