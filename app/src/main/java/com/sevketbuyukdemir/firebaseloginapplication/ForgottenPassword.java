package com.sevketbuyukdemir.firebaseloginapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgottenPassword extends AppCompatActivity {
    //Activity
    Button backLoginForgot;
    Button takeNewPasswordButton;
    EditText fpNameUserText;
    EditText fpUserEmailText;
    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);
        //Click listeners
        fpNameUserText = (EditText) findViewById(R.id.fpNameUserText);
        fpUserEmailText = (EditText) findViewById(R.id.fpUserEmailText);

        takeNewPasswordButton = (Button) findViewById(R.id.fpButton);
        takeNewPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entered_user_name = fpNameUserText.getText().toString();
                String entered_email = fpUserEmailText.getText().toString();
                for(User user: MainActivity.userArrayList){
                    if(user.getUserName().equals(entered_user_name) && user.getUserMail().equals(entered_email)){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.context);
                        builder.setTitle(R.string.alert_dialog_title);
                        builder.setMessage(user.getUserPassword());
                        builder.setCancelable(false);
                        builder.setPositiveButton(R.string.fpErrorDoneButton, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create();
                        builder.show();
                    }
                }
            }
        });
        backLoginForgot = (Button) findViewById(R.id.backLoginForgot);
        backLoginForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lba = new Intent(ForgottenPassword.this,MainActivity.class);
                startActivity(lba);
            }
        });
        //Click listeners
    }
}