package com.e.releiveme.homeActivity.contactFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.e.releiveme.R;

public class Contact extends Fragment implements View.OnClickListener {

    private Button button, envoi;
    private TextView contact;
    private View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Contact() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static com.e.releiveme.homeActivity.contactFragment.Contact newInstance(String param1, String param2) {
        com.e.releiveme.homeActivity.contactFragment.Contact fragment = new com.e.releiveme.homeActivity.contactFragment.Contact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);

        button = (Button) view.findViewById(R.id.buttonContact);
        button.setOnClickListener(this);

        envoi = (Button) view.findViewById(R.id.envoiMail);
        envoi.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == button) {
            String[] to = {"thome.cathy@laposte.net"};
            String[] cc = {""};

            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.setData(Uri.parse("mailto:"));
            mail.setType("text/plain");

            mail.putExtra(Intent.EXTRA_EMAIL, to);
            mail.putExtra(Intent.EXTRA_CC, cc);


            mail.putExtra(Intent.EXTRA_TEXT, "This email will be send " );
            mail.putExtra(Intent.EXTRA_SUBJECT, "Codeloop.org");


            startActivity(Intent.createChooser(mail, "mailto") );
        }
        else if (v == envoi){
            String[] to = {"thome.cathy@laposte.net"};
            String[] cc = {""};

            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.setData(Uri.parse("mailto:"));
            mail.setType("text/plain");

            mail.putExtra(Intent.EXTRA_EMAIL, to);
            mail.putExtra(Intent.EXTRA_CC, cc);


            mail.putExtra(Intent.EXTRA_TEXT, "This email will be send " );
            mail.putExtra(Intent.EXTRA_SUBJECT, "Codeloop.org");


            startActivity(Intent.createChooser(mail, "mailto") );
        }
    }
}
