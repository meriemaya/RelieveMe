package com.e.releiveme.homeActivity.doneTasksFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.releiveme.R;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.homeActivity.toDoFragment.Adapter;
import com.e.releiveme.homeActivity.toDoFragment.TodoTaskViewModel;
import com.e.releiveme.utils.AlertDialogClass;

import java.util.List;
import java.util.stream.Collectors;

public class DoneTasksFragment extends Fragment implements View.OnClickListener, Adapter.ItemClickListener, AlertDialogClass.DialogListener {

    private Button button, retour;
    private TextView fait;
    public Adapter adapter;
    RecyclerView recyclerView;
    DoneTasksViewModel taskViewModel;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DoneTasksFragment() {
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
    public static DoneTasksFragment newInstance(String param1, String param2) {
        DoneTasksFragment fragment = new DoneTasksFragment();
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
        taskViewModel = new DoneTasksViewModel(getActivity().getApplication());

    }

    /**
     * @param view
     */
    private void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.fait_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        button = (Button) view.findViewById(R.id.buttonFait);
        button.setOnClickListener(this);
        retour = (Button) view.findViewById(R.id.returnFait);
        retour.setOnClickListener(this);
        retour.setVisibility(View.GONE);
        fait = (TextView) view.findViewById(R.id.fait);
        recyclerView.setVisibility(View.GONE);

    }

    /**
     * @param view
     */
    private void initObservers(View view) {
        taskViewModel.mAllDoneTasks.observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                List<String> description = tasks.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
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
        View view = inflater.inflate(R.layout.fragment_fait, container, false);
        initViews(view);
        initObservers(view);

        return view;
    }



    @Override
    public void onClick(View v) {
        if(v == button) {
            button.setVisibility(View.GONE);
            fait.setVisibility(View.GONE);
            retour.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        else if(v == retour){
            button.setVisibility(View.VISIBLE);
            fait.setVisibility(View.VISIBLE);
            retour.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        taskViewModel.selectedTask = position;
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}