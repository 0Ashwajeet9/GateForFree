package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

public class Main2Activity extends AppCompatActivity {

int c=0;
    public static final String Extra_Text="go slow";

    String arr[]=new String[300];
    String arr1[]=new String[300];


    String data=null,me="";


   private ArrayList<ExampleItem> filteredList;
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdaptor mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        extractfile();
        createExampleList();
        buildExampleView();


    /*    et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
          filter(editable.toString());
            }
        });*/

        }
        private void filter(String text){
        filteredList=new ArrayList<>();
        for(ExampleItem item :mExampleList){
            if (item.getText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
                c=c+1;

            }
        }

       mAdapter.filterList(filteredList);

        }

public void createExampleList()
{
    mExampleList = new ArrayList<>();
    int i=0;


            while (arr[i] != null) {
                mExampleList.add(new ExampleItem(R.drawable.yicon, arr[i], "Line 2"));
                i = i + 1;
            }


}


public void buildExampleView()
{
    mRecyclerView = findViewById(R.id.recyclerView);
    mRecyclerView.setHasFixedSize(true);
    mLayoutManager = new LinearLayoutManager(this);
    mAdapter = new ExampleAdaptor(mExampleList);
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setAdapter(mAdapter);

    mAdapter.setOnItemClickListener(new ExampleAdaptor.onItemClickListener() {
        @Override
        public void onItemClick(int position) {
            int pos;
            pos=position;
            openNext( pos);

        }
    });
}

public void openNext(int pos1){
        String s2;
        if(c==0) {
            s2 = mExampleList.get(pos1).getText1();
        }
        else {
            s2 = filteredList.get(pos1).getText1();
        }
      int  p=0;
      int pos2=1;
      while(arr[p]!=null)
      {
          if(arr[p].equals(s2))
          {
              pos2=p;
              break;
          }
          p=p+1;
      }

      String s3=arr1[pos2];
            Intent inte = new Intent(getApplicationContext(), ashwajeet.class);
            inte.putExtra(Extra_Text, s3);
            startActivity(inte);


}
public void extractfile(){
        StringBuffer sb=new StringBuffer();
    Intent it=getIntent();
    String l=it.getStringExtra(alright.SEM);
int id=this.getResources().getIdentifier(l,"raw",this.getPackageName());
    InputStream is=this.getResources().openRawResource(id);
    BufferedReader br=new BufferedReader((new InputStreamReader(is)));
    if(is!=null)
    {
        try{
            int c=0,b=1;
            while((data=br.readLine())!=null){
                if(b%2!=0){
                    arr[c]=data;
                    b=b+1;
                }
                else{
                    arr1[c]=data;
                    b=b+1;
                    c=c+1;
                }
            }
            is.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }}

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);


        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)searchItem.getActionView();
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String s) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {
              filter(s);

               return false;

           }
       });
        return true;
    }
}
