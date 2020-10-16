package com.sevketbuyukdemir.firebaseloginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Context context;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference userDatabaseReference = database.getReference("User");

    public static ArrayList<User> userArrayList = new ArrayList<>();
    //Activity
    EditText userName;
    EditText userPassword;
    Button loginButton;
    Button forgottenButton;
    Button logCreBut;
    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //Click listeners
        userName = (EditText) findViewById(R.id.loginUserName);
        //For security
        userName.setText("");
        //For security
        userName.setOnClickListener(v -> userName.setText(""));
        userPassword = (EditText) findViewById(R.id.loginPassword);
        //For security
        userPassword.setText("");
        //For security
        userPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPassword.setText("");
            }
        });
        //***********************************************************************
        //***********************************************************************
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entered_user_name = userName.getText().toString();
                String entered_user_password = userPassword.getText().toString();
                for(User user : userArrayList){
                    if(user.getUserName().equals(entered_user_name) && user.getUserPassword().equals(entered_user_password)){
                        Toast.makeText(context, "Giriş Yapıldı", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Hata", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        //***********************************************************************
        //***********************************************************************
        forgottenButton = (Button) findViewById(R.id.forgottenPasswordButton);
        forgottenButton.setOnClickListener(v -> {
            Intent fpa = new Intent(MainActivity.this,ForgottenPassword.class);
            startActivity(fpa);
        });
        logCreBut = (Button) findViewById(R.id.logCreBut);
        logCreBut.setOnClickListener(v -> {
            Intent caa = new Intent(MainActivity.this,CreateAccount.class);
            startActivity(caa);
        });

        userDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(userArrayList.size() > 0) {
                    userArrayList.clear();
                }
                for(DataSnapshot temp : dataSnapshot.getChildren()){
                    User user = temp.getValue(User.class);
                    userArrayList.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        //Click Listener
    }


    @Override
    protected void onStart() {
        //For security
        userName.setText("");
        userPassword.setText("");
        //For security
        super.onStart();
    }
    @Override
    protected void onResume() {
        //For security
        userName.setText("");
        userPassword.setText("");
        //For security
        super.onResume();
    }
    @Override
    protected void onPause() {
        //For security
        userName.setText("");
        userPassword.setText("");
        //For security
        super.onPause();
    }
    @Override
    protected void onStop() {
        //For security
        userName.setText("");
        userPassword.setText("");
        //For security
        super.onStop();
    }
    @Override
    protected void onRestart() {
        //For security
        userName.setText("");
        userPassword.setText("");
        //For security
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        //For security
        userName.setText("");
        userPassword.setText("");
        //For security
        super.onDestroy();
    }
}