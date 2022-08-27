package com.example.goodtravel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TravelsAdapter extends RecyclerView.Adapter<TravelsAdapter.LayoutStar>{


    private ArrayList<Travel> lists;

    public TravelsAdapter(ArrayList<Travel> lists) {
        this.lists = lists;
    }


    @NonNull
    @Override
    public TravelsAdapter.LayoutStar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.onerow,parent,false);
        return new LayoutStar(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelsAdapter.LayoutStar holder, int position) {
        final Travel t=lists.get(position);

        holder.vd.setText(t.getVilledepart());
        holder.va.setText(t.getVillearrivee());
       holder.dd.setText(t.getDatedepart());
       holder.da.setText(t.getDatearrivee());
       holder.prix.setText(t.getPrix()+" DH");
       holder.hd.setText(t.getHeuredepart());
       holder.ha.setText(t.getHeurearrivee());
       holder.capacite.setText(t.getCapacite()+" Places");
       if(t.getCapacite().equals("0")){
           holder.reserver.setEnabled(false);
       }

       holder.reserver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intTravelReserv=new Intent(v.getContext(),Reservation.class);
               intTravelReserv.putExtra("idr",t.getId());
               intTravelReserv.putExtra("vdr",t.getVilledepart());
               intTravelReserv.putExtra("var",t.getVillearrivee());
               intTravelReserv.putExtra("ddr",t.getDatedepart());
               intTravelReserv.putExtra("dar",t.getDatearrivee());
               intTravelReserv.putExtra("hdr",t.getHeuredepart());
               intTravelReserv.putExtra("har",t.getHeurearrivee());
               intTravelReserv.putExtra("or",t.getOutile());
               intTravelReserv.putExtra("cr",t.getCapacite());


               v.getContext().startActivity(intTravelReserv);

           }
       });



    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class LayoutStar extends RecyclerView.ViewHolder{

        TextView vd,va,dd,da,prix,hd,ha,capacite;
        Button reserver;

        public LayoutStar(@NonNull View itemView) {
            super(itemView);

            vd=(TextView) itemView.findViewById(R.id.vd);
            va=(TextView) itemView.findViewById(R.id.va);
            dd=(TextView) itemView.findViewById(R.id.dd);
            da=(TextView) itemView.findViewById(R.id.da);
            prix=(TextView) itemView.findViewById(R.id.prix);
            hd=(TextView) itemView.findViewById(R.id.hd);
            ha=(TextView) itemView.findViewById(R.id.ha);
            capacite=(TextView) itemView.findViewById(R.id.capacite);
            reserver=(Button) itemView.findViewById(R.id.reserver);





        }
    }
}
