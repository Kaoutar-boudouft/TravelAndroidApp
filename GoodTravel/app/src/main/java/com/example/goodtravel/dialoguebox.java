package com.example.goodtravel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialoguebox extends AppCompatDialogFragment {
    private String title,message,idtour,nbrplace;

    public dialoguebox(String title, String message,String idtour,String nbrplace) {
        this.title = title;
        this.message = message;
        this.idtour = idtour;
        this.nbrplace = nbrplace;

    }

    public String getIdtour() {
        return idtour;
    }

    public void setIdtour(String idtour) {
        this.idtour = idtour;
    }

    public String getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(String nbrplace) {
        this.nbrplace = nbrplace;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(this.title)
                .setMessage(this.message)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        globalvariable.typeres="Tour";
                        Intent intpay=new Intent(getContext(),payment.class);
                        intpay.putExtra("type","Tour");
                        intpay.putExtra("idtour",idtour);
                        intpay.putExtra("nbrpla",nbrplace);
                        startActivity(intpay);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();

    }
}
