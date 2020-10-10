package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class messageFragment extends Fragment {
    public static final String SEM="me";
    String CSE1[] = {"theory_of_computation", "digital_logic", "data_structure", "algorithm", "compiler_design", "operating_system", "databases", "coa", "computer_network"};
    String ECE1[]={"communication","signal","network","analog","emft","digital","control_system"};
    String MEC1[]={"mechanics","fluids","industrial","heat","machine","production","thermodynamics","vibrations","tom","manufacturing","material"};
    String EE1[]={"electrical_machines","signal","digital","ei_measurement","emft","power_system"};
    String CE1[]={"fluids","geotechnical","environmental","concrete","construction","mechanics","hydrology","solid_mechanics","steel_structure","transportation"};
    String PROGRAM1[]={"number_theory","graph_theory","dynamic_programming"};
    private ArrayList<ExampleItem> mEampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdaptor mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_message,container,false);

        createexamplelist();
        buildrecyclerview();
        return view;
    }
    private void createexamplelist() {
        Intent i1=getActivity().getIntent();
        String s1=i1.getStringExtra(bestpage.Low_me);
        mEampleList = new ArrayList<>();
        if(s1.equals("CSE")) {
            int i;
            for (i = 0; i < 9; i++) {

                mEampleList.add(new ExampleItem(R.drawable.more1, CSE1[i].toUpperCase(), "line2"));
            }
        }
        else if(s1.equals("ECE")){
            int i;
            for(i=0;i<7;i++){
                mEampleList.add(new ExampleItem(R.drawable.ler1, ECE1[i].toUpperCase(), "line2"));
            }
        }
        else if(s1.equals("MEC")){
            int i;
            for(i=0;i<11;i++){
                mEampleList.add(new ExampleItem(R.drawable.ler1, MEC1[i].toUpperCase(), "line2"));
            }
        }
        else if(s1.equals("EE")){
            int i;
            for(i=0;i<6;i++){
                mEampleList.add(new ExampleItem(R.drawable.ler1, EE1[i].toUpperCase(), "line2"));
            }
        }
        else if(s1.equals("CE")){
            int i;
            for(i=0;i<10;i++){
                mEampleList.add(new ExampleItem(R.drawable.ler1, CE1[i].toUpperCase(), "line2"));
            }
        }
        else if(s1.equals("PROGRAM")){
            int i;
            for(i=0;i<3;i++){
                mEampleList.add(new ExampleItem(R.drawable.ler1, PROGRAM1[i].toUpperCase(), "line2"));
            }
        }
    }
    private void buildrecyclerview(){
        mRecyclerView=view.findViewById(R.id.recyclerView3);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(getContext());
        mAdaptor=new ExampleAdaptor(mEampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdaptor);
        mAdaptor.setOnItemClickListener(new ExampleAdaptor.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int pos=position;
                opennext(pos);
            }
        });
    }
    private void opennext(int pos){
        Intent i1=getActivity().getIntent();
        String s1=i1.getStringExtra(bestpage.Low_me);
        if(s1.equals("CSE")) {
            String s2 = CSE1[pos];
            Intent it = new Intent(getContext(), Main2Activity.class);
            it.putExtra(SEM, s2);
            startActivity(it);
        }
        else if(s1.equals("ECE")){
            String s2 = ECE1[pos];
            Intent it = new Intent(getContext(), Main2Activity.class);
            it.putExtra(SEM, s2);
            startActivity(it);
        }
        else if(s1.equals("MEC")){
            String s2 = MEC1[pos];
            Intent it = new Intent(getContext(), Main2Activity.class);
            it.putExtra(SEM, s2);
            startActivity(it);
        }
        else if(s1.equals("EE")){
            String s2 = EE1[pos];
            Intent it = new Intent(getContext(), Main2Activity.class);
            it.putExtra(SEM, s2);
            startActivity(it);
        }
        else if(s1.equals("CE")){
            String s2 = CE1[pos];
            Intent it = new Intent(getContext(), Main2Activity.class);
            it.putExtra(SEM, s2);
            startActivity(it);
        }  else if(s1.equals("PROGRAM")){
            String s2 = PROGRAM1[pos];
            Intent it = new Intent(getContext(), Main2Activity.class);
            it.putExtra(SEM, s2);
            startActivity(it);
        }
    }

}
