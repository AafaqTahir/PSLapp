package com.example.psl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.viewHolder> implements Filterable {

    ArrayList<ExampleModelClass> examples;
    ArrayList<ExampleModelClass> filteredItem;
    ItemSelected activity;

    public ExampleAdapter(Context context , ArrayList<ExampleModelClass> list) {
        examples = list;
        activity = (ItemSelected) context;
        filteredItem = new ArrayList<>(list);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ExampleModelClass> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(filteredItem);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(ExampleModelClass item : filteredItem){
                    if(item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            examples.clear();;
            examples.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

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
        if(image.equals("Abstract")){
            holder.imageView.setImageResource(R.drawable.abstrac);
        }else if(image.equals("Painting")){
            holder.imageView.setImageResource(R.drawable.painting);
        }else if(image.equals("Palette Knife")){
            holder.imageView.setImageResource(R.drawable.paletteknife);
        }else if(image.equals("Pastel")){
            holder.imageView.setImageResource(R.drawable.pastel);
        }else if(image.equals("Palette")){
            holder.imageView.setImageResource(R.drawable.palette);
        }else if(image.equals("Battery")){
            holder.imageView.setImageResource(R.drawable.battery);
        }else if(image.equals("Ceiling Fan")){
            holder.imageView.setImageResource(R.drawable.ceilingfan);
        }else if(image.equals("Electric Iron")){
            holder.imageView.setImageResource(R.drawable.iron);
        }else if(image.equals("Electric Toaster")){
            holder.imageView.setImageResource(R.drawable.toaster);
        }else if(image.equals("Freezer")){
            holder.imageView.setImageResource(R.drawable.freezer);
        }else if(image.equals("Air Crash")){
            holder.imageView.setImageResource(R.drawable.aircrash);
        }else if(image.equals("Allama Iqbal Airport")){
            holder.imageView.setImageResource(R.drawable.airport_);
        }else if(image.equals("Arrival")){
            holder.imageView.setImageResource(R.drawable.arrivals);
        }else if(image.equals("Baggage Cleaning")){
            holder.imageView.setImageResource(R.drawable.baggage);
        }else if(image.equals("Quaid-e-Azam Airport")){
            holder.imageView.setImageResource(R.drawable.airport_);
        }else if(image.equals("A")){
            holder.imageView.setImageResource(R.drawable.a);
        }else if(image.equals("B")){
            holder.imageView.setImageResource(R.drawable.b);
        }else if(image.equals("C")){
            holder.imageView.setImageResource(R.drawable.c);
        }else if(image.equals("D")){
            holder.imageView.setImageResource(R.drawable.d);
        }else if(image.equals("E")){
            holder.imageView.setImageResource(R.drawable.e);
        }else if(image.equals("Crow")){
            holder.imageView.setImageResource(R.drawable.crow);
        }else if(image.equals("Dove")){
            holder.imageView.setImageResource(R.drawable.dove);
        }else if(image.equals("Falcon")){
            holder.imageView.setImageResource(R.drawable.falcon);
        }else if(image.equals("Hawk")){
            holder.imageView.setImageResource(R.drawable.hawk);
        }else{
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
