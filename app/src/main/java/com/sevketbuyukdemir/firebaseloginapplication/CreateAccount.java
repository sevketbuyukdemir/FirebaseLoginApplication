package com.sevketbuyukdemir.firebaseloginapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {
    //Activity
    Button backLogin;
    Button createAccountButton;
    EditText cuNameText;
    EditText cuPassText;
    EditText cuEmailText;
    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //**************************************************************************
        createAccountButton = (Button) findViewById(R.id.cuButton);
        cuNameText = (EditText) findViewById(R.id.cuNameText);
        cuPassText = (EditText) findViewById(R.id.cuPassText);
        cuEmailText = (EditText) findViewById(R.id.cuEmailText);
        //**************************************************************************
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = cuNameText.getText().toString();
                String password = cuPassText.getText().toString();
                String email = cuEmailText.getText().toString();

                if(name.equals("") || password.equals(""))
                {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccount.this);
                    builder.setCancelable(false);
                    builder.setTitle(R.string.caAlertTitle);
                    builder.setMessage(R.string.caAlertMessage);
                    builder.setNegativeButton(R.string.caAlertButton, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    builder.show();
                }
                else if(email.equals(""))
                {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccount.this);
                    builder.setCancelable(false);
                    builder.setTitle(R.string.caAlertTitle);
                    builder.setMessage(R.string.caAlertMessageTwo);
                    builder.setNegativeButton(R.string.caAlertButton, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    builder.show();
                } else {
                    User user = new User(name, password, email);
                    MainActivity.userDatabaseReference.child(user.getUser_UUID()).setValue(user);
                }
            }
        });
        //**************************************************************************
        //Click listeners
        backLogin = (Button) findViewById(R.id.backLogin);
        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lba = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(lba);
            }
        });
        //Click listeners

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
