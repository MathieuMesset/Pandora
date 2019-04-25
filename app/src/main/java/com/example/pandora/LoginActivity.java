package com.example.pandora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        displayInfo();

    }


    public void displayInfo(){

        TextView usernameView = (TextView)findViewById(R.id.Username);

        String username = getIntent().getStringExtra("USERNAME");

        usernameView.setText(username);

    }


    public void Check_Password(View view) {

        EditText password;

        password = (EditText) findViewById(R.id.password);

        if (password.getText().toString().equals("testpassword")) {
            Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, ItemsActivity.class);

            startActivity(intent);


        } else {
            Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_LONG).show();
        }

    }
}
