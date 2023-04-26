package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//FUNCTIONING OF THE ADAPTER
/* An adapter acts as a machine that firstly collects the data
* from the main activity and fits it to the layout
* and again it moves to the  next idx there again collects the data
* and fits to the same layout as it reuses it */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<card> arl ;
        public Adapter(Context context, ArrayList arl){
            this.context = context;
            this.arl = arl;
        }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(context).inflate(R.layout.card,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arl.get(position).img);
        holder.name.setText(arl.get(position).name);
        holder.contact.setText(arl.get(position).contact);
    }

    @Override
    public int getItemCount() {
        return arl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView contact;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);   //.toString();  // we can convert it to string later of else take variable only as txtview
            img = itemView.findViewById(R.id.imageView);
            contact = itemView.findViewById(R.id.details);
        }

    }

}
