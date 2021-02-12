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

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.viewHolder>{

    ArrayList<ExampleModelClass> examples;
    ItemSelected activity;

    public ExampleAdapter(Context context , ArrayList<ExampleModelClass> list) {
        examples = list;
        activity = (ItemSelected) context;
    }
    public interface ItemSelected{
        void onItemSelected(int index);
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.itemView.setTag(examples.get(position));
        holder.tvName.setText(examples.get(position).getName());
        String image = examples.get(position).getName();
        if(image.equals("Adobe")){
            holder.imageView.setImageResource(R.drawable.adobe);
        }else if(image.equals("Apple")){
            holder.imageView.setImageResource(R.drawable.apple);
        }else if(image.equals("Artwork")){
            holder.imageView.setImageResource(R.drawable.art);
        }else if(image.equals("Boss")){
            holder.imageView.setImageResource(R.drawable.boss);
        }else if(image.equals("Chicken")){
            holder.imageView.setImageResource(R.drawable.chicken);
        }else{
            holder.imageView.setImageResource(R.drawable.no_photo);
        }
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvClickPlay;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivPref);
            tvName = itemView.findViewById(R.id.tvName);
            tvClickPlay = itemView.findViewById(R.id.click_to_play);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemSelected(examples.indexOf((ExampleModelClass) itemView.getTag()));
                }
            });
        }
    }
}
