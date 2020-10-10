package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;


public class bestpage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    SharedPreferences prefs;

    public static final String Low_me="help";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bestpage);
       Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     drawer=findViewById(R.id.drawer_layout);



        NavigationView navigationView=findViewById(R.id.nav_view);
        View headerview=navigationView.getHeaderView(0);
        TextView nav=(TextView) headerview.findViewById(R.id.etve);
        TextView gm=(TextView) headerview.findViewById(R.id.gm);

        /*GoogleSignInAccount signInAccount= GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null){
            nav.setText( "welcome "+signInAccount.getDisplayName());
            gm.setText(signInAccount.getEmail());
        }*/


        Intent in=getIntent();
    String   s1=in.getStringExtra(MainActivity.XML);

        prefs = getSharedPreferences("myPref", 0);
String s=prefs.getString("srt",null);
        nav.setText("Welcome "+s);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OnlyFragment()).commit();

        }

    }
    /* c1=findViewById(R.id.cardview);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),alright.class);
                i1.putExtra(Low_me,"CSE");
                startActivity(i1);

            }
        });
        c2=findViewById(R.id.cardview1);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),alright.class);
                i1.putExtra(Low_me,"ECE");
                startActivity(i1);

            }
        });
        c3=findViewById(R.id.cardview2);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),alright.class);
                i1.putExtra(Low_me,"MEC");
                startActivity(i1);

            }
        });
        c4=findViewById(R.id.cardview3);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),alright.class);
                i1.putExtra(Low_me,"EE");
                startActivity(i1);

            }
        });
        c5=findViewById(R.id.cardview4);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),alright.class);
                i1.putExtra(Low_me,"CE");
                startActivity(i1);

            }
        });
        c6=findViewById(R.id.cardview5);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),alright.class);
                i1.putExtra(Low_me,"COMP");
                startActivity(i1);

            }
        });*/



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_message:

                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new messageFragment()).commit();
                Toast.makeText(this,"this feature will be available soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                showDialog();
                //Toast.makeText(this,"send",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:

                Toast.makeText(this,"this feature will be available soon",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_message1:
               showDialog1();
               // Toast.makeText(this,"message1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_message2:
                Toast.makeText(this,"this feature will be available soon",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
     else {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    }
    public void showDialog()
    {
      final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
      dialog.setTitle("Feedback Form");
      dialog.setMessage("provide us your valuable feedback");
       LayoutInflater inflater=this.getLayoutInflater();
       View reg_layout=inflater.inflate(R.layout.feedback,null);


       final EditText m3=reg_layout.findViewById((R.id.em));
       final EditText m1=reg_layout.findViewById(R.id.username);
       final EditText m2=reg_layout.findViewById(R.id.feedback);
       dialog.setView(reg_layout);


       dialog.setPositiveButton("send", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
           if(TextUtils.isEmpty(m1.getText().toString())){
              Toast.makeText(bestpage.this,"please type your username",Toast.LENGTH_SHORT).show();
              return;
           }
               if(TextUtils.isEmpty(m2.getText().toString())){
                   Toast.makeText(bestpage.this,"Feedback cannot empty ..",Toast.LENGTH_SHORT).show();
                   return;
               }
               if(TextUtils.isEmpty(m3.getText().toString())){
                   Toast.makeText(bestpage.this,"please type your email",Toast.LENGTH_SHORT).show();
                   return;
               }
               FirebaseDatabase database=FirebaseDatabase.getInstance();
               DatabaseReference myref=database.getReference();
               myref.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       Object value=dataSnapshot.getValue();
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {
                       Toast.makeText(bestpage.this, "failed to read value", Toast.LENGTH_SHORT).show();
                   }
               });
               myref.child("users").child(m1.getText().toString()).child("username").setValue(m1.getText().toString());
               myref.child("users").child(m1.getText().toString()).child("Email").setValue(m3.getText().toString());
               myref.child("users").child(m1.getText().toString()).child("feedback").setValue(m2.getText().toString());

             Toast.makeText(bestpage.this,"thanks for your feedback",Toast.LENGTH_SHORT).show();

           }
       });
       dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.dismiss();
           }
       });
        dialog.show();

    }
    public void showDialog1() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("About");
        dialog.setMessage("About this app");


        LayoutInflater inflater = this.getLayoutInflater();
        View reg_layout1 = inflater.inflate(R.layout.about_us, null);
        dialog.setView(reg_layout1);
        dialog.show();
    }


}
