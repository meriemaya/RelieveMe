package com.e.releiveme.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.e.releiveme.R;

public class AlertDialogClass extends DialogFragment {
    public static String TAG = "onCreateDialog";
    private DialogListener dialogListener;


    public AlertDialogClass(DialogListener dialogListener) {

        this.dialogListener = dialogListener;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoglayout, container, false);

        Button cancel = (Button) v.findViewById(R.id.dialog_cancel);
        Button conf =v.findViewById(R.id.dialog_ok);
        cancel.setOnClickListener(dialogListener);
        conf.setOnClickListener(dialogListener);

        return v;
    }

    public interface DialogListener extends View.OnClickListener {
    }
}