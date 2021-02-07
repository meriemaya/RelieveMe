package com.e.releiveme.homeActivity.toDoFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.releiveme.R;
import com.e.releiveme.data.Models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoTaskFragment extends Fragment implements View.OnClickListener, Adapter.ItemClickListener {

    private Button button;

    public Adapter adapter;
    RecyclerView recyclerView;
    TodoTaskViewModel taskViewModel ;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ToDoTaskFragment() {
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
    public static ToDoTaskFragment newInstance(String param1, String param2) {
        ToDoTaskFragment fragment = new ToDoTaskFragment();
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
         taskViewModel = new TodoTaskViewModel(getActivity().getApplication());

    }

    /**
     * @param view
     */
    private void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.a_faire_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    /**
     * @param view
     */
    private void initObservers(View view) {
        taskViewModel.mAllTasks.observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
               List<String> description= tasks.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
              populateData(description);
            }
        });
    }

    /**
     * @param data
     */
    private void populateData(List<String> data){
        adapter = new Adapter(getContext(), data);

        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), 1);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a_faire, container, false);
        initViews(view);
        initObservers(view);

        return view;
    }



    @Override
    public void onClick(View v) {
        if (v == button) {
            Toast.makeText(getContext(), "appui sur le bouton", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}