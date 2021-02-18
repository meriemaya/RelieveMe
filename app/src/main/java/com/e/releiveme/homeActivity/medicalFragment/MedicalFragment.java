package com.e.releiveme.homeActivity.medicalFragment;

import android.os.Bundle;
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

import com.e.releiveme.data.DateConverter;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.homeActivity.doneTasksFragment.DoneTasksViewModel;
import com.e.releiveme.homeActivity.toDoFragment.Adapter;
import com.e.releiveme.R;
import com.e.releiveme.utils.AlertDialogClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicalFragment extends Fragment implements View.OnClickListener, Adapter.ItemClickListener, AlertDialogClass.DialogListener  {
    private Button button, retour;
    private TextView medical;
    private RecyclerView medicalrecyclerView;
    private View view;
    public Adapter adapter;
    DoneTasksViewModel taskViewModel;
    AlertDialogClass alert;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MedicalFragment() {
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
    public static MedicalFragment newInstance(String param1, String param2) {
        MedicalFragment fragment = new MedicalFragment();
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
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_medical, container, false);
        initViews(view);

        initObservers(view);

        return view;
    }
    private void initViews(View view) {
        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.medical_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        button = (Button) view.findViewById(R.id.buttonMedical);
        button.setOnClickListener(this);
        retour = (Button) view.findViewById(R.id.returnMedical);
        retour.setOnClickListener(this);
        retour.setVisibility(View.GONE);
        medical = (TextView) view.findViewById(R.id.medical);
        medicalrecyclerView = (RecyclerView) view.findViewById(R.id.medical_recycler_view);
        medicalrecyclerView.setVisibility(View.GONE);

    }
    private void initObservers(View view) {

        taskViewModel.rdvList.observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                List<String> description = tasks.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
                List<String> types = tasks.stream().map(task -> task.getTypeTask()).collect(Collectors.toList());
                populateData(description,types);
            }
        });
    }
    private void populateData(List<String> data,List<String> types){
        adapter = new Adapter(getContext(), data,types);
        adapter.setClickListener(this);
        medicalrecyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(medicalrecyclerView.getContext(), 1);
        medicalrecyclerView.addItemDecoration(dividerItemDecoration);

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
        }else if(v.getId()==R.id.dialog_ok){
            //taskViewModel.updateTaskDone();
            alert.dismiss();
            Toast.makeText(getContext(), "Tâche " +taskViewModel.getAllRDV().getValue().get(taskViewModel.selectedTask).getTaskDescription()+" Supprimée" , Toast.LENGTH_SHORT).show();

        }else if(v.getId()==R.id.dialog_cancel){
            alert.dismiss();
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        taskViewModel.selectedTask = position;
        alert = new AlertDialogClass(this);
        Task selectedTask=taskViewModel.getAllRDV().getValue().get(position);
        String details= DateConverter.dateToString(selectedTask.getTaskDate());

        alert.setButtonsText("Supprimer","Retour",selectedTask.getTaskDescription());
        alert.setDetailsText(details);
        alert.setIconType(selectedTask.getTypeTask());
        alert.show(getChildFragmentManager(), AlertDialogClass.TAG);




    }
}
