package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class alright extends AppCompatActivity {

public static final String SEM="me";
     String CSE1[] = {"theory of computation", "digital_logic", "data_structure", "algorithm", "compiler_design", "operating system", "databases", "coa", "computer_network"};
     String ECE1[]={"communication","signal","network","analog","emft","digital","control_system"};
     String MEC1[]={"mechanics","fluids","industrial","heat","machine","production","thermodynamics","vibrations","tom","manufacturing","material"};
     String EE1[]={"electrical_machines","signal","digital","ei_measurement","emft","power_system"};
     String CE1[]={"fluids","geotechnical","environmental","concrete","construction","mechanics","hydrology","solid_mechanics","steel_structure","transportation"};
     String PROGRAM1[]={"number_theory","graph_theory","dynamic_programming"};
    private ArrayList<ExampleItem> mEampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdaptor mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alright);



        createexamplelist();
        buildrecyclerview();


    }
    public void createexamplelist() {
        Intent i1=getIntent();
           String s1=i1.getStringExtra(bestpage.Low_me);
        mEampleList = new ArrayList<>();
        if(s1.equals("CSE")) {
            int i;
            for (i = 0; i < 9; i++) {

                mEampleList.add(new ExampleItem(R.drawable.ic_android, CSE1[i], "line2"));
            }
        }
        else if(s1.equals("ECE")){
            int i;
            for(i=0;i<7;i++){
                mEampleList.add(new ExampleItem(R.drawable.ic_android, ECE1[i], "line2"));
            }
        }
        else if(s1.equals("MEC")){
            int i;
            for(i=0;i<11;i++){
                mEampleList.add(new ExampleItem(R.drawable.ic_android, MEC1[i], "line2"));
            }
        }
        else if(s1.equals("EE")){
            int i;
            for(i=0;i<6;i++){
                mEampleList.add(new ExampleItem(R.drawable.ic_android, EE1[i], "line2"));
            }
        }
        else if(s1.equals("CE")){
            int i;
            for(i=0;i<10;i++){
                mEampleList.add(new ExampleItem(R.drawable.ic_android, CE1[i], "line2"));
            }
        }
        else if(s1.equals("PROGRAM")){
            int i;
            for(i=0;i<3;i++){
                mEampleList.add(new ExampleItem(R.drawable.ic_android, PROGRAM1[i], "line2"));
            }
        }
    }
    public void buildrecyclerview(){
        mRecyclerView=findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
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
public void opennext(int pos){
    Intent i1=getIntent();
    String s1=i1.getStringExtra(bestpage.Low_me);
    if(s1.equals("CSE")) {
        String s2 = CSE1[pos];
        Intent it = new Intent(getApplicationContext(), Main2Activity.class);
        it.putExtra(SEM, s2);
        startActivity(it);
    }
    else if(s1.equals("ECE")){
        String s2 = ECE1[pos];
        Intent it = new Intent(getApplicationContext(), Main2Activity.class);
        it.putExtra(SEM, s2);
        startActivity(it);
    }
    else if(s1.equals("MEC")){
        String s2 = MEC1[pos];
        Intent it = new Intent(getApplicationContext(), Main2Activity.class);
        it.putExtra(SEM, s2);
        startActivity(it);
    }
    else if(s1.equals("EE")){
        String s2 = EE1[pos];
        Intent it = new Intent(getApplicationContext(), Main2Activity.class);
        it.putExtra(SEM, s2);
        startActivity(it);
    }
    else if(s1.equals("CE")){
        String s2 = CE1[pos];
        Intent it = new Intent(getApplicationContext(), Main2Activity.class);
        it.putExtra(SEM, s2);
        startActivity(it);
    }  else if(s1.equals("PROGRAM")){
        String s2 = PROGRAM1[pos];
        Intent it = new Intent(getApplicationContext(), Main2Activity.class);
        it.putExtra(SEM, s2);
        startActivity(it);
    }
}
}
