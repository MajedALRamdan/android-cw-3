package com.example.movielist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ma extends RecyclerView.Adapter {

    ArrayList<Moive>mArray;
    Context context;

    public ma(ArrayList<Moive> mArray, Context context) {
        this.mArray = mArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.mi,parent,false);
        Viewholder vh= new Viewholder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((Viewholder)holder).rating.setText(mArray.get(position).getRating()+"");
        ((Viewholder)holder).name.setText(mArray.get(position).getName()+"");
        ((Viewholder)holder).duration.setText(mArray.get(position).getDuration()+"");
        ((Viewholder)holder).img.setImageResource(mArray.get(position).getImg());

        ((Viewholder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(context,Deatails.class);
                i.putExtra("movie",mArray.get(position));
                context.startActivity(i);


            }
        });
            final AlertDialog.Builder builder =new AlertDialog.Builder(context);

        ((Viewholder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure?");
                builder.setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mArray.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"Not delete",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog AlerDialog = builder.create();
                AlerDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return mArray.size();
    }
    public static class Viewholder extends  RecyclerView.ViewHolder{
        public ImageView img;
        public ImageView delete;
        public TextView name;
        public TextView rating;
        public TextView duration;
        public View view;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            img=itemView.findViewById(R.id.mi);
            name=itemView.findViewById(R.id.mn);
            duration=itemView.findViewById(R.id.md2);
            rating=itemView.findViewById((R.id.mr2));
            delete=itemView.findViewById(R.id.del);


        }
    }
}
