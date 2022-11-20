package com.cookandroid.app111;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private ArrayList<Item> mList;

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("ResourceType") View view = LayoutInflater.from(parent.getContext()).inflate(R.id.recyclerview, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(mList.get(position));
    }

    public void setList(ArrayList<Item> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        EditText sub_et_name;
        EditText sub_et_loc;
        EditText sub_et_etc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sub_et_name = (EditText) itemView.findViewById(R.id.sub_et_name);
            sub_et_loc = (EditText) itemView.findViewById(R.id.sub_et_loc);
            sub_et_etc = (EditText) itemView.findViewById(R.id.sub_et_etc);
        }

        void onBind(Item item) {
            sub_et_name.setText((item.getStrName()));
            sub_et_loc.setText((item.getStrLoc()));
            sub_et_etc.setText((item.getStrEtc()));
        }
    }
}
