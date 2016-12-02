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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by fabio on 02/12/2016.
 */

public class modifynameActivity extends DialogFragment {

    public String name;
    public static final String mKey = "name";
    public static final int REQUEST_CODE = 1;

    private void sendResult(int resultCode)
    {
        if (getTargetFragment() == null)
        {
            return;
        }

        Intent i = new Intent();
        i.putExtra(mKey, name);
        getTargetFragment().onActivityResult(REQUEST_CODE, resultCode, i);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.modifyname_popup, null);
        TextInputLayout inputLayout = (TextInputLayout) v.findViewById(R.id.name_text_modify);
        final TextInputEditText nameInput = (TextInputEditText) v.findViewById(R.id.name_modify);


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
                        modifynameActivity.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }
}
