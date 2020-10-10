package com.example.firstapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BlankFragment extends Fragment {

    private ArrayList<ExampleItem> mEampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdaptor mAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;

private  View v;
    String str="";
    String data=null,data1=null;
    String arr1[]=new String[100];
    String arr[]=new String[100];


@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.fragment_blank, container, false);


        extractfile();
    createexamplelist();
    buildrecyclerview();


     return v;
    }

    private void createexamplelist() {
        Intent i1=getActivity().getIntent();
        String s1=i1.getStringExtra(bestpage.Low_me);
        mEampleList = new ArrayList<>();
        if(s1.equals("ECE")) {
            int i=0;
                while(arr[i]!=null) {
                    mEampleList.add(new ExampleItem(R.drawable.studym, arr1[i], "line2"));
                    i=i+1;
                }
        }
        if(s1.equals("CSE")) {
            int i=0;
            while(arr[i]!=null) {
                mEampleList.add(new ExampleItem(R.drawable.studym, arr1[i], "line2"));
                i=i+1;
            }
        }
        if(s1.equals("MEC")) {
            int i=0;
            while(arr[i]!=null) {
                mEampleList.add(new ExampleItem(R.drawable.studym, arr1[i], "line2"));
                i=i+1;
            }
        }
        if(s1.equals("CE")) {
            int i=0;
            while(arr[i]!=null) {
                mEampleList.add(new ExampleItem(R.drawable.studym, arr1[i], "line2"));
                i=i+1;
            }
        }
        if(s1.equals("EE")) {
            int i=0;
            while(arr[i]!=null) {
                mEampleList.add(new ExampleItem(R.drawable.studym, arr1[i], "line2"));
                i=i+1;
            }
        }

    }
    private void buildrecyclerview(){
        mRecyclerView=v.findViewById(R.id.recyclerView3);
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

         if(s1.equals("ECE")){

            String s=arr[pos];
            Intent inte=new Intent(Intent.ACTION_VIEW, Uri.parse(s));
            startActivity(inte);
        }
        if(s1.equals("CSE")){

            String s=arr[pos];
            Intent inte=new Intent(Intent.ACTION_VIEW, Uri.parse(s));
            startActivity(inte);
        }
        if(s1.equals("MEC")){

            String s=arr[pos];
            Intent inte=new Intent(Intent.ACTION_VIEW, Uri.parse(s));
            startActivity(inte);
        }
        if(s1.equals("CE")){

            String s=arr[pos];
            Intent inte=new Intent(Intent.ACTION_VIEW, Uri.parse(s));
            startActivity(inte);
        }
        if(s1.equals("EE")){

            String s=arr[pos];
            Intent inte=new Intent(Intent.ACTION_VIEW, Uri.parse(s));
            startActivity(inte);
        }


    }
    public void extractfile(){
        StringBuffer sb=new StringBuffer();
       // Intent it=getActivity().getIntent();
       // String l=it.getStringExtra(alright.SEM);
        Intent i1=getActivity().getIntent();

        String s1=i1.getStringExtra(bestpage.Low_me);


     //   int id=this.getResources().getIdentifier(l,"raw",this.getPackageName());
       if(s1.equals("ECE"))
       {
        InputStream is=this.getResources().openRawResource(R.raw.ecetopic);
        BufferedReader br=new BufferedReader((new InputStreamReader(is)));
        if(is!=null)
        {
            try{
                int b=1,c=0;
                while((data=br.readLine())!=null){
                    if(b%3!=0){
                     str=str+" "+data;
                     b=b+1;
                    }
                    else{
                        str=str+" "+data;
                        arr1[c]=str;
                        c=c+1;
                        str="";
                        b=b+1;
                    }
                }
                is.close();
            }

            catch (Exception e){
                e.printStackTrace();
            }}}
        if(s1.equals("ECE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.ecelinks);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int c=0;
                    while((data1=br.readLine())!=null){
                       arr[c]=data1;
                       c=c+1;
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("CSE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.cstopic);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int b=1,c=0;
                    while((data=br.readLine())!=null){
                        if(b%2!=0){
                            str=str+" "+data;
                            b=b+1;
                        }
                        else{
                            str=str+" "+data;
                            arr1[c]=str;
                            c=c+1;
                            str="";
                            b=b+1;
                        }
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("CSE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.cslink);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int c=0;
                    while((data1=br.readLine())!=null){
                        arr[c]=data1;
                        c=c+1;
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("MEC"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.metopic);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int b=1,c=0;
                    while((data=br.readLine())!=null){
                        if(b%2!=0){
                            str=str+" "+data;
                            b=b+1;
                        }
                        else{
                            str=str+" "+data;
                            arr1[c]=str;
                            c=c+1;
                            str="";
                            b=b+1;
                        }
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("MEC"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.melink);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int c=0;
                    while((data1=br.readLine())!=null){
                        arr[c]=data1;
                        c=c+1;
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("CE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.cetopic);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int b=1,c=0;
                    while((data=br.readLine())!=null){
                        if(b%2!=0){
                            str=str+" "+data;
                            b=b+1;
                        }
                        else{
                            str=str+" "+data;
                            arr1[c]=str;
                            c=c+1;
                            str="";
                            b=b+1;
                        }
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("CE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.celink);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int c=0;
                    while((data1=br.readLine())!=null){
                        arr[c]=data1;
                        c=c+1;
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("EE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.eetopic);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int b=1,c=0;
                    while((data=br.readLine())!=null){
                        if(b%2!=0){
                            str=str+" "+data;
                            b=b+1;
                        }
                        else{
                            str=str+" "+data;
                            arr1[c]=str;
                            c=c+1;
                            str="";
                            b=b+1;
                        }
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}
        if(s1.equals("EE"))
        {
            InputStream is=this.getResources().openRawResource(R.raw.eelink);
            BufferedReader br=new BufferedReader((new InputStreamReader(is)));
            if(is!=null)
            {
                try{
                    int c=0;
                    while((data1=br.readLine())!=null){
                        arr[c]=data1;
                        c=c+1;
                    }
                    is.close();
                }

                catch (Exception e){
                    e.printStackTrace();
                }}}

}
}
