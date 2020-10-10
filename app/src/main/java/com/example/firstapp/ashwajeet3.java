package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ashwajeet3 extends AppCompatActivity {
    private static final Pattern passpat=Pattern.compile("^" +
            "(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[a-zA-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{4,}" +
            "$");

    DatabaseHelper db;
    EditText et1,et2,et3;
    Button bu,be;
    TextView tw;

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        db= new DatabaseHelper(this);
        et1=(EditText)findViewById(R.id.editText3);
        et2=(EditText)findViewById(R.id.editText4);
        et3=(EditText)findViewById(R.id.editText5);
        bu=(Button)findViewById(R.id.button5);


      bu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              long val;
              String email=et2.getText().toString().trim();
              String user=et1.getText().toString().trim();
              String pwd=et3.getText().toString().trim();


              if(!validateEmail()|!validatePassword()|!validateUsername())
              {
                  return;
              }

              val = db.adduser(user,pwd,email);
              String val1 = db.sendemail(user, pwd, email);
              sendMail(val1);
                  if (val > 0) {



                      Toast.makeText(ashwajeet3.this, "you have registered", Toast.LENGTH_SHORT).show();
                      Intent l = new Intent(getApplicationContext(), MainActivity.class);
                      startActivity(l);

                  } else {
                      Toast.makeText(ashwajeet3.this, "registration error", Toast.LENGTH_SHORT).show();
                  }

          }
      });
    }

          public boolean validateEmail()
        {
            String email=et2.getText().toString().trim();
            if(email.isEmpty())
            {
                et2.setError("field can't be empty");
                return false;
            }
              else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                et2.setError("please enter correct email");
                return false;
        }
                else
            {
                et2.setError(null);
                return true;
            }}
        public boolean validateUsername()
            {
                String user=et1.getText().toString().trim();
                if (user.isEmpty()) {
                    et1.setError("field can't be empty");

                    return false;
                }
                else if(user.length()>15){
                    et1.setError("username too long");
                    return false;
                }
                else if(user.length()<8){
                    et1.setError("username is less than 8 characters");
                    return false;
                }
                else
            {
                et1.setError(null);
                return true;
            }
            }
        public boolean validatePassword()
        {
            String pwd=et3.getText().toString().trim();
            if(pwd.isEmpty())
            {
                et3.setError("field can't be empty");
                return false;
            }
                else if(!passpat.matcher(pwd).matches()) {
                et3.setError("password too weak! need combination of special character/numerals/text");
                return false;
            }
                 else if(pwd.length()<8){
                    et3.setError("password is less than 8 characters");
                    return false;
                }

                else
            {
                et3.setError(null);
                return true;
            }
        }
    public void sendMail(String mai)
    {
        String mail=mai;
        String message="thanks for sign up in ash's app ! you will get a million rupees  ";
        String subject="sign up to ash's app";
        JavaMailAPI javaMailAPI=new JavaMailAPI(this,mail,subject,message);
        javaMailAPI.execute();
    }

}

