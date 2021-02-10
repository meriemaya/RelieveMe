package com.e.releiveme.homeActivity.medicalFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.releiveme.homeActivity.toDoFragment.Adapter;
import com.e.releiveme.R;

import java.util.ArrayList;

public class Medical extends Fragment implements View.OnClickListener, Adapter.ItemClickListener {
    private Button button, retour;
    private TextView medical;
    private RecyclerView medicalrecyclerView;
    private View view;
    public Adapter adapter;
    private ArrayList<String> toDoList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Medical() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AFaire.
     */
    // TODO: Rename and change types and number of parameters
    public static Medical newInstance(String param1, String param2) {
        Medical fragment = new Medical();
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
        view = inflater.inflate(R.layout.fragment_medical, container, false);

        button = (Button) view.findViewById(R.id.buttonMedical);
        button.setOnClickListener(this);
        retour = (Button) view.findViewById(R.id.returnMedical);
        retour.setOnClickListener(this);
        retour.setVisibility(View.GONE);
        medical = (TextView) view.findViewById(R.id.medical);
        medicalrecyclerView = (RecyclerView) view.findViewById(R.id.medical_recycler_view);
        medicalrecyclerView.setVisibility(View.GONE);

        toDoList = new ArrayList<>();
        toDoList.add("rdv1");
        toDoList.add("rdv2");
        toDoList.add("rdv3");
        toDoList.add("rdv4");
        toDoList.add("rdv5");

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.medical_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), toDoList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == button) {
            button.setVisibility(View.GONE);
            medical.setVisibility(View.GONE);
            retour.setVisibility(View.VISIBLE);
            medicalrecyclerView.setVisibility(View.VISIBLE);
        }
        else if(v == retour){
            button.setVisibility(View.VISIBLE);
            medical.setVisibility(View.VISIBLE);
            retour.setVisibility(View.GONE);
            medicalrecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
