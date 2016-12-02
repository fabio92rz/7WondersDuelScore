package com.example.fabio.a7wondersduelscore;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by fabio on 30/11/2016.
 */

public class newPlayerActivity extends DialogFragment{

    public String name;
    public static final String nameKey = "name";

    private void sendResult(int resultCode)
    {
        if (getTargetFragment() == null)
        {
            return;
        }

        Intent i = new Intent();
        i.putExtra(nameKey, name);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);

        Log.d("prova passagio", "resultCode" + resultCode);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.newplayer_popup, null);
        TextInputLayout inputLayout = (TextInputLayout) v.findViewById(R.id.name_text);
        final TextInputEditText nameInput = (TextInputEditText) v.findViewById(R.id.name);


        builder.setView(v)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String input = nameInput.getText().toString();

                        if (input.length() > 0){

                            name = input;

                        }else {

                            return;
                        }

                        sendResult(Activity.RESULT_OK);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newPlayerActivity.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }
}




