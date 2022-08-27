package com.example.goodtravel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class afterreservationdialogue extends AppCompatDialogFragment {
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Thanks")
                .setMessage("Visite Our Website To Check Your Ticket!!")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent tickint=new Intent(getContext(),Home1.class);
                        startActivity(tickint);
                        getActivity().finish();
                    }
                })
              ;
        return builder.create();

    }
}
