package com.e.releiveme.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.e.releiveme.R;

public class AlertDialogClass extends DialogFragment {
    public static String TAG = "onCreateDialog";
    private DialogListener dialogListener;
    Button conf;
    Button cancel;
    TextView title;
    TextView details;
    ImageView icon;
    String okText, cancelText,titleText,detailsText,iconType =null;



    public AlertDialogClass(DialogListener dialogListener) {

        this.dialogListener = dialogListener;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialoglayout, container, false);

        title=v.findViewById(R.id.dialog_title);
        cancel = (Button) v.findViewById(R.id.dialog_cancel);
        conf =v.findViewById(R.id.dialog_ok);
        details=v.findViewById(R.id.details_text);
        icon=v.findViewById(R.id.icon_task);
        cancel.setOnClickListener(dialogListener);
        conf.setOnClickListener(dialogListener);

        if(okText != null) {
            conf.setText(okText);
            cancel.setText(cancelText);
            title.setText(titleText);
        }

        if(detailsText != null) details.setText(this.detailsText);
        if(iconType != null) icon.setImageResource(getContext().getResources().getIdentifier("drawable/"+iconType, null, getContext().getPackageName()));


        return v;
    }
    public void setButtonsText(String okText, String cancelText, String title){
        this.cancelText=cancelText;
        this.okText=okText;
        this.titleText=title;
    }
    public void setDetailsText(String details){
        this.detailsText=details;
    }
    public void setIconType(String type){
        this.iconType=type;

    }




    public interface DialogListener extends View.OnClickListener {
    }
}