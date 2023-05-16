package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_uping);

                EditText edtName = dialog.findViewById(R.id.namefill);
                EditText edtNum = dialog.findViewById(R.id.numfill);
                Button btnSubmit = dialog.findViewById(R.id.submit);

                TextView txtContact = dialog.findViewById((R.id.txtContact));

                txtContact.setText("Update");
                btnSubmit.setText("Update");
                edtName.setText(arl.get(position).name);
                edtNum.setText(arl.get(position).contact);




                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name ="",num = "";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();

                        }else {
                            Toast.makeText(context,"Please Enter Contact Name",Toast.LENGTH_SHORT);
                        }
                        if(!edtNum.getText().toString().equals("")) {
                            num = edtNum.getText().toString();
                        }else {
                            Toast.makeText(context,"Please Enter Contact Num",Toast.LENGTH_SHORT);
                        }
                        arl.set(position,new card(name ,num));  //HERE SET WILL CHANGE THE VALUE OF THE PARTICULAR IDX
                        //IT WILL NOT ADD THE NEW ITEM
                        notifyItemChanged(position); // In MainActivity this method was used as the instance
                        //like adapter.notifyI....() but here we can use directly

                        //here we should not use notifyIteminserted
                        //here we have to use notify Itemchanged otherwise new item will be created



                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to Delete")
                        .setIcon(R.drawable.baseline_delete_forever_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arl.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.show();


                return true;
            }
        });

//        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return arl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView contact;
        LinearLayout llRow;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);   //.toString();  // we can convert it to string later of else take variable only as txtview
            img = itemView.findViewById(R.id.imageView);
            contact = itemView.findViewById(R.id.details);
            llRow = itemView.findViewById(R.id.LLRow);

        }

    }

        //costum method to setup the animation using animation class
        // the animation directory will be always android.r.anim naam ka folder

    // and for this animation to work only once scrolling
    //lets say
//    int lastPostion = -1;
//    private void setAnimation(View viewToAnimate ,int position){
//            if(position>lastPostion) {
//                Animation sideLn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
//                viewToAnimate.startAnimation(sideLn);
//                lastPostion = position;
//                // so once the lastPosition becomes arr.size() value next time when we scroll up or down
//                // this code wont work when we are scrolling again
//
//            }
//    }

}
