package com.e.releiveme.homeActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.e.releiveme.R;


public class Sante extends Fragment implements View.OnClickListener {

    private Button button;
    private TextView sante;
    private View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sante() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AFaire newInstance(String param1, String param2) {
        AFaire fragment = new AFaire();
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
        view = inflater.inflate(R.layout.fragment_sante, container, false);

        button = (Button) view.findViewById(R.id.buttonSante);
        button.setOnClickListener(this);
        sante = (TextView) view.findViewById(R.id.sante);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == button) {

        }
    }
}