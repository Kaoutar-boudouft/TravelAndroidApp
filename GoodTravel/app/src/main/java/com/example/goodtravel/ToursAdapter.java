package com.example.goodtravel;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class ToursAdapter extends RecyclerView.Adapter<ToursAdapter.LayoutStartour> {
    private ArrayList<Tour> listt;

    public ToursAdapter(ArrayList<Tour> listt) {
        this.listt = listt;
    }

    @NonNull
    @Override
    public ToursAdapter.LayoutStartour onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one_tour,parent,false);
        return new LayoutStartour(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToursAdapter.LayoutStartour holder, int position) {
        final Tour t=listt.get(position);
        holder.titre.setText(t.getTitre());
        holder.date.setText(t.getDateDepart());
        holder.prix.setText(t.getPrix());
        Picasso.get().load(t.getImage()).into(holder.im);
        if(t.getCapacite().equals("0")){
            holder.Reserver.setEnabled(false);
        }
        holder.Reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intTourRes=new Intent(v.getContext(),ReservationTour.class);
                intTourRes.putExtra("idtour",t.getIdTour());
                intTourRes.putExtra("cate",t.getCategorie());
                intTourRes.putExtra("title",t.getTitre());
                intTourRes.putExtra("dd",t.getDateDepart());
                intTourRes.putExtra("prix",t.getPrix());
                intTourRes.putExtra("capacite",t.getCapacite());
                v.getContext().startActivity(intTourRes);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentshare=new Intent(Intent.ACTION_SEND);
                intentshare.setType("text/plain");
                intentshare.putExtra(Intent.EXTRA_TEXT,t.getTitre()+"\n"+"Do You Like This Trip?"+"\n"+"Visite Our Website :"+"\n"+"http://192.168.56.1/GoodTravel"+"\n"+"Or Install Our Mobile Version and Reserve Your Place Now!");
                v.getContext().startActivity(intentshare);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listt.size();
    }

    public static class LayoutStartour extends RecyclerView.ViewHolder {

        ImageView im,share;
        TextView titre,date,prix;
        Button Reserver;

        public LayoutStartour(@NonNull View itemView) {
            super(itemView);
           im=(ImageView) itemView.findViewById(R.id.tourim);
           titre= (TextView) itemView.findViewById(R.id.tourtitle);
           date=(TextView) itemView.findViewById(R.id.tourdate);
           prix=(TextView) itemView.findViewById(R.id.tourprix);
           Reserver=(Button) itemView.findViewById(R.id.reservertour);
           share=(ImageView) itemView.findViewById(R.id.share);

        }
    }
}
