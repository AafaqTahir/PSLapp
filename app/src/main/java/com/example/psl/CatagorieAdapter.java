package com.example.psl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatagorieAdapter extends RecyclerView.Adapter<CatagorieAdapter.ViewHolder> {
    ArrayList<CatagorieModelClass> list;
    ItemSelected itemSelected;

    public CatagorieAdapter(ArrayList<CatagorieModelClass> list, Context context) {
        this.list = list;
        itemSelected = (ItemSelected) context;
    }
    public interface ItemSelected{
        void onItemSelected(int index);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagorie_layout, parent, false);
        return new CatagorieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(list.get(position));
        holder.tv_catagorie.setText(list.get(position).getName());
        String image = list.get(position).getName();
        if(image.equals("Alphabets")){
            holder.iv_catagorie.setImageResource(R.drawable.blocks);
        }else if(image.equals("Airport")){
            holder.iv_catagorie.setImageResource(R.drawable.airport);
        }else if(image.equals("Appliances")){
            holder.iv_catagorie.setImageResource(R.drawable.appliances);
        }else if(image.equals("Arts")){
            holder.iv_catagorie.setImageResource(R.drawable.paint_palette);
        }else if(image.equals("Banking")){
            holder.iv_catagorie.setImageResource(R.drawable.bank);
        }else if(image.equals("Bathroom")){
            holder.iv_catagorie.setImageResource(R.drawable.shower);
        }else if(image.equals("Beach")){
            holder.iv_catagorie.setImageResource(R.drawable.no_photo);
        }else if(image.equals("Beauty")){
            holder.iv_catagorie.setImageResource(R.drawable.skincare);
        }else if(image.equals("Birds")){
            holder.iv_catagorie.setImageResource(R.drawable.bird);
        }else if(image.equals("Computer")){
            holder.iv_catagorie.setImageResource(R.drawable.desktop);
        }else if(image.equals("Bedroom")){
            holder.iv_catagorie.setImageResource(R.drawable.bed);
        }else if(image.equals("Drinks")){
            holder.iv_catagorie.setImageResource(R.drawable.juice);
        }else if(image.equals("Kitchen")){
            holder.iv_catagorie.setImageResource(R.drawable.kitchen);
        }else if(image.equals("Colors")){
            holder.iv_catagorie.setImageResource(R.drawable.color);
        }
        else{
            holder.iv_catagorie.setImageResource(R.drawable.no_photo);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_catagorie;
        TextView tv_catagorie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_catagorie = itemView.findViewById(R.id.iv_catagorie);
            tv_catagorie = itemView.findViewById(R.id.tv_catagorie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSelected.onItemSelected(list.indexOf((CatagorieModelClass) itemView.getTag()));
                }
            });
        }
    }
}
