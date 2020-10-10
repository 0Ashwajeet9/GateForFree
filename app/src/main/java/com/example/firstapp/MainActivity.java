
package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.*;

public class MainActivity extends AppCompatActivity{
    public static final String XML="me";
    EditText e1,e2;
    DatabaseHelper db;
    Button b,b1,b2;
    String user;
 SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN=123;
    private FirebaseAuth mAuth;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (prefs.getBoolean("Bool", false)) {
            Intent i=new Intent(this,bestpage.class);
            startActivity(i);
        setContentView(R.layout.activity_main);
      /*  signInButton=findViewById(R.id.sign_in);
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient=GoogleSignIn.getClient(this,gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        */
        db=new DatabaseHelper(this);

        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button3);
        b2=(Button) findViewById(R.id.sign_in);
         prefs = getSharedPreferences("myPref", 0);
       ;
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(getApplicationContext(), ashwajeet3.class);
                startActivity(l);
                finish();
            }


        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               user=e1.getText().toString().trim();
                String pwd=e2.getText().toString().trim();

                boolean res =db.checkuser(user,pwd);
                if(res==true)
                {
                    Toast.makeText(MainActivity.this,"successfully logged in",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("Bool", true);
                    editor.putString("srt",user);
                    editor.commit();
                    Intent in=new Intent(getApplicationContext(),bestpage.class);
                    in.putExtra(XML,user);
                    startActivity(in);

                }
                else

                    Toast.makeText(MainActivity.this,"invalid username or password",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"successfully logged in",Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("Bool", true);
                editor.putString("srt","Guest");
                editor.commit();
                Intent in=new Intent(getApplicationContext(),bestpage.class);
                in.putExtra(XML,"Guest");
                startActivity(in);
            }
        });

    }
    private void signIn(){
        Intent signInIntent=mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
           Task<GoogleSignInAccount>  task=GoogleSignIn.getSignedInAccountFromIntent(data);
           handleSignInresult(task);
        }
    }
    private void handleSignInresult(Task<GoogleSignInAccount> CompletedTask){
        try {
            GoogleSignInAccount account=CompletedTask.getResult(ApiException.class);
            startActivity(new Intent(MainActivity.this,bestpage.class));
        }catch (ApiException e){
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null)
        {
            startActivity(new Intent(MainActivity.this,bestpage.class));
        }
        super.onStart();
    }
}
