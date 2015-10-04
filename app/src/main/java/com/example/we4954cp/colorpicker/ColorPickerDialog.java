package com.example.we4954cp.colorpicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import java.util.HashMap;

/**
 * Created by we4954cp on 9/25/2015.
 */
public class ColorPickerDialog extends DialogFragment{

    //Need text to display; these will be shown in this order in the dialog
    final CharSequence[] COLOR_CHOICES = { "Red", "Magenta", "Green"};   //Replace with colors of your choice if desired
    //Parallel array with the color each choice represents
    final int[] COLOR_VALUES = { Color.RED, Color.MAGENTA, Color.GREEN};   //Replace with colors of your choice - match with Strings in COLOR_CHOICES

    interface ColorDialogListener {
        void onNewColorSelected(int color);
    }

    ColorDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (ColorDialogListener) activity; //TODO try-catch block for ClassCastException
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a new color")
                .setItems(COLOR_CHOICES, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //which is the index of the item selected
                        mListener.onNewColorSelected(COLOR_VALUES[which]);
                    }
                });

        return builder.create();

    }



}
