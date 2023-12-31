package com.example.bookmage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    AlertDialog.Builder builder;
    ConstraintLayout constraintLayout;
    private LinearLayout linearLayout;
    private TextInputLayout usernameTextInputLayout,passwordTextInputLayout;
    private TextInputEditText usernameEditText, passwordEditText;
    private Button submitButton,resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTextInputLayout = findViewById(R.id.filledTextField);
        passwordTextInputLayout = findViewById(R.id.textInputLayout);
        usernameEditText = findViewById(R.id.edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        linearLayout = findViewById(R.id.buttons);
        submitButton = findViewById(R.id.submit);
        resetButton = findViewById(R.id.reset);
        constraintLayout = findViewById(R.id.constraintLayout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        builder = new AlertDialog.Builder(this);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                login();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }
    private void login()
    {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(username.isEmpty() || password.isEmpty())
        {
            Snackbar snackbar = Snackbar.make(constraintLayout,"Username and Password field cannot be empty", Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            snackbar.show();
        }

        if(username.equals("admin") && password.equals("admin"))
        {
            Intent i = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(i);
        }
        else {
            showAlertDialog("Invalid Authentication","Username or Password is incorrect");
        }

    }

    private void showAlertDialog(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void reset()
    {
        usernameEditText.setText("");
        passwordEditText.setText("");

    }
}